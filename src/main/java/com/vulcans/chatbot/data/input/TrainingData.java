package com.vulcans.chatbot.data.input;

import com.vulcans.chatbot.data.Context;

/**
 * Created by user on 6/12/2016.
 */
public class TrainingData {
    private Context context;
    private int sequence;
    private String response;

    public TrainingData(Context context, int sequence, String response) {
        this.context = context;
        this.sequence = sequence;
        this.response = response;
    }

    public Context getContext() {
        return context;
    }

    public int getSequence() {
        return sequence;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "TrainingData{" +
                "context=" + context +
                ", sequence=" + sequence +
                ", response='" + response + '\'' +
                '}';
    }
}
