package com.vulcans.chatbot.runtime;

import com.vulcans.chatbot.data.Context;
import com.vulcans.chatbot.data.input.DataFeeder;
import com.vulcans.chatbot.data.input.TrainingData;
import com.vulcans.chatbot.data.nlp.ParserOutput;
import com.vulcans.chatbot.domain.model.Conversation;
import com.vulcans.chatbot.domain.model.Customer;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

/**
 * Created by user on 6/11/2016.
 */
public class KeyMatcher {

    private String key;
    public static final String COMMA = ",";
    public static final int MAX_MUTATIONS = 10;

    public boolean buildKey(ParserOutput parserOutput) {
        Set<String> nouns = parserOutput.getNouns();
        Set<String> verbs = parserOutput.getVerbs();

        StringBuilder key = new StringBuilder();
        for (String verb : verbs) {
            key.append(verb).append(COMMA);
        }
        for (String noun : nouns) {
            key.append(noun).append(COMMA);
        }
        if (key.toString().isEmpty()) {
            return false;
        }
        this.key = key.toString().substring(0, key.toString().length() - 1);
        return true;
    }

    public String getKey() {
        return key;
    }

    public TrainingData getResponse(Customer customer) {
        System.out.println("Key is - " + key);
        Context currentContext = customer.getCurrentContext();
        final Conversation lastConversation = customer.getConversationLog().getLastConversation();
        final TrainingData currAns = match(key);
        if (lastConversation != null) {
            String prevAns = lastConversation.getResponse();
            if ((!currentContext.equals(Context.DFT) && !currentContext.equals(Context.GRT)) &&
                    currentContext.equals(lastConversation.getContext())) {
                if (currAns.getResponse().equalsIgnoreCase(prevAns) || prevAns.contains(currAns.getResponse())) {
                    match(currAns.getResponse());
                }
            }
        }
        return currAns;
    }

    private TrainingData match(String key) {
        int minDistance = Integer.MAX_VALUE;
        if (DataFeeder.dataMap.containsKey(key)) {
            return DataFeeder.dataMap.get(key);
        }
        String matchedKey = null;
        for (String currKey : DataFeeder.dataMap.keySet()) {
            int distance = StringUtils.getLevenshteinDistance(currKey.toLowerCase(), key.toLowerCase());
            if (distance <= minDistance) {
                minDistance = distance;
                matchedKey = currKey;
            }
        }
        if (minDistance > MAX_MUTATIONS || matchedKey == null) {
            return null;
        }
        return DataFeeder.dataMap.get(matchedKey);
    }

}
