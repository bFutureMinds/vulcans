package com.vulcans.chatbot.runtime;

import com.vulcans.chatbot.domain.model.Conversation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 6/12/2016.
 */
public class ConversationLog {

    public List<Conversation> conversations = new ArrayList<>();

    public List<Conversation> getAllConversations() {
        return Collections.unmodifiableList(conversations);
    }

    public void append(Conversation conversation) {
        conversations.add(conversation);
    }

    public Conversation getLastConversation()  {
        if (conversations.isEmpty()){
            return null;
        }
        return conversations.get(conversations.size() - 1);
    }
    @Override
    public String toString() {
        return "ConversationLog{" +
                "conversations=" + conversations +
                '}';
    }
}
