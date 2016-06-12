package com.vulcans.chatbot;

import com.vulcans.chatbot.dao.CustomerDAO;
import com.vulcans.chatbot.data.input.DataFeeder;
import com.vulcans.chatbot.data.input.TrainingData;
import com.vulcans.chatbot.data.nlp.NLPParser;
import com.vulcans.chatbot.data.nlp.ParserOutput;
import com.vulcans.chatbot.data.nlp.SentenceDetector;
import com.vulcans.chatbot.domain.model.Conversation;
import com.vulcans.chatbot.domain.model.Customer;
import com.vulcans.chatbot.runtime.KeyMatcher;
import com.vulcans.chatbot.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class EndToEndParsing {

//    public static String trainingDataFilePath = "H:\\Projects\\OpenNLP_POC\\src\\main\\resources\\training_data.txt";
//
//    public static void main(String[] args) throws IOException {
//        DataFeeder dataFeeder = new DataFeeder();
//        dataFeeder.loadData(new File(trainingDataFilePath));
//        NLPParser nlpParser = new NLPParser();
//        nlpParser.init();
//        CustomerDAO customerDAO = new CustomerDAO();
//        System.out.println("Please enter the input text");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        do {
//            final String[] inputs = line.split("\\|");
//            final Customer customer = customerDAO.getCustomer(inputs[0]);
//            SentenceDetector sentenceDetector = new SentenceDetector();
//            String[] sentences = sentenceDetector.sentenceDetect(inputs[1]);
//            for (String sentence : sentences) {
//                final String cleanedStr = Utils.cleanupSentence(sentence);
//                ParserOutput parserOutput = nlpParser.parse(cleanedStr);
//                final KeyMatcher keyMatcher = new KeyMatcher();
//                keyMatcher.buildKey(parserOutput);
//                final TrainingData response = keyMatcher.getResponse(customer);
//                if (response == null) {
//                    System.out.println("No answer found");
//                }
//                else {
//                    customer.setCurrentContext(response.getContext());
//                    customer.getConversationLog().append(new Conversation(keyMatcher.getKey(), response.getResponse(),
//                            response.getSequence(), response.getContext()));
//                    System.out.println(response);
//                    System.out.println(customer);
//                }
//            }
//            line = br.readLine();
//        }
//        while (!line.equals("exit"));
//    }
}
