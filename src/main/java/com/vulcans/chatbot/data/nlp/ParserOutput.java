package com.vulcans.chatbot.data.nlp;

import java.util.Set;

/**
 * Created by user on 6/11/2016.
 */
public class ParserOutput {

    private Set<String> nouns;
    private Set<String> verbs;

    public ParserOutput(Set<String> nouns, Set<String> verbs) {
        this.nouns = nouns;
        this.verbs = verbs;
    }

    public Set<String> getNouns() {
        return nouns;
    }

    public Set<String> getVerbs() {
        return verbs;
    }
}
