package com.vulcans.chatbot.domain.model;

import com.vulcans.chatbot.data.Context;

/**
 * Created by user on 6/12/2016.
 */
public class Conversation {

    private String key;
    private String response;
    private Integer sequence;
    private Context context;

    public Conversation(String key, String response, Integer sequence, Context context) {
        this.key = key;
        this.response = response;
        this.sequence = sequence;
        this.context = context;
    }

    public String getKey() {
        return key;
    }

    public String getResponse() {
        return response;
    }

    public Integer getSequence() {
        return sequence;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "key='" + key + '\'' +
                ", response='" + response + '\'' +
                ", sequence=" + sequence +
                ", context=" + context +
                '}';
    }
}
