package com.vulcans.chatbot.web;

import com.vulcans.chatbot.dao.CustomerDAO;
import com.vulcans.chatbot.data.input.DataFeeder;
import com.vulcans.chatbot.data.input.TrainingData;
import com.vulcans.chatbot.data.nlp.NLPParser;
import com.vulcans.chatbot.data.nlp.ParserOutput;
import com.vulcans.chatbot.data.nlp.SentenceDetector;
import com.vulcans.chatbot.domain.model.Conversation;
import com.vulcans.chatbot.domain.model.Customer;
import com.vulcans.chatbot.domain.model.Greeting;
import com.vulcans.chatbot.runtime.KeyMatcher;
import com.vulcans.chatbot.utils.Utils;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class ChatController {

    public static String trainingDataFilePath = "/training_data.txt";

    private NLPParser nlpParser = new NLPParser();

    public ChatController() throws IOException {
        DataFeeder dataFeeder = new DataFeeder();
        dataFeeder.loadData(getClass().getResourceAsStream(trainingDataFilePath));
        nlpParser.init();
    }

    @MessageMapping("/web")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {

        String retVal = "";

        if (message.isGreeting()) {
            return new Greeting("Hello, " + message.getName() + ", how can I help you!");
        }
        CustomerDAO customerDAO = new CustomerDAO();
        final Customer customer = customerDAO.getCustomer("ID1");
        SentenceDetector sentenceDetector = new SentenceDetector();
        String[] sentences = sentenceDetector.sentenceDetect(message.getName());
        for (String sentence : sentences) {
            final String cleanedStr = Utils.cleanupSentence(sentence);
            ParserOutput parserOutput = nlpParser.parse(cleanedStr);
            final KeyMatcher keyMatcher = new KeyMatcher();
            boolean result = keyMatcher.buildKey(parserOutput);
            if (!result) {
                return new Greeting("Sorry, I don't have an answer for this.");
            }
            final TrainingData response = keyMatcher.getResponse(customer);
            if (response == null) {
                return new Greeting("Sorry, I don't have an answer for this.");
            }
            else {
                retVal = response.getResponse();
                customer.setCurrentContext(response.getContext());
                customer.getConversationLog().append(new Conversation(keyMatcher.getKey(), response.getResponse(),
                        response.getSequence(), response.getContext()));
                System.out.println(response);
                System.out.println(customer);
            }
        }
        return new Greeting(retVal);
    }
}
