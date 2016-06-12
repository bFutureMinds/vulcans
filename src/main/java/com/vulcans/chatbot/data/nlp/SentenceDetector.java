package com.vulcans.chatbot.data.nlp;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.IOException;
import java.io.InputStream;

public class SentenceDetector {

    public String[] sentenceDetect(String input) throws IOException {
        InputStream modelIn = getClass().getResourceAsStream("/en-sent.bin");
        SentenceModel model = new SentenceModel(modelIn);
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
        String sentences[] = sentenceDetector.sentDetect(input);
//        for (String sentence : sentences)
//            System.out.println(sentence);
        modelIn.close();
        return sentences;
    }
}
