package com.vulcans.chatbot.data;

/**
 * Created by user on 6/11/2016.
 */
public enum Context {
    DFT("Default"),
    PMT("Payment"),
    TSFR("Funds Transfer"),
    ADV("Advice"),
    GRT("Greetings");

    private Context(String greetings) {
        // NoOp
    }
}
