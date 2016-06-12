package com.vulcans.chatbot.utils;

/**
 * Created by user on 6/12/2016.
 */
public class Utils {


    public static String cleanupSentence(String sentence) {
        // Remove Punctuation mark.
        sentence = sentence.replaceAll("[?!,]", " ");
        // Trim left and right spaces.
        sentence.trim();
        return sentence;
    }
}
