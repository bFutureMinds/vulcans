package com.vulcans.chatbot.data.nlp;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;


public class NLPParser {

    private InputStream modelIn;
    private ParserModel model;
    private Parser parser;
    static Set<String> identityTags = new HashSet(){{
        add("NN");
        add("NNP");
        add("NNS");
        add("NNPS");
        add("JJ");
        add("JJR");
        add("JJS");
        add("PRP");
        add("PRP$");

    }};
    static Set<String> actionTags = new HashSet(){{
        add("VB");
        add("VBD");
        add("VBZ");
        add("VBG");
        add("VBN");
        add("VBP");
        add("RB");
        add("RBR");
        add("RBS");
        add("WRB");
        add("UH");
    }};

    public void init() throws IOException {
        modelIn = getClass().getResourceAsStream("/en-parser-chunking.bin");
        model = new ParserModel(modelIn);
        modelIn.close();
        parser = ParserFactory.create(model);
    }

    public ParserOutput parse(String sentence) throws IOException {
        if (sentence.equalsIgnoreCase("Bye")) {
            sentence = sentence.concat(", Bye");
        }
        Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
        Set<String> nounPhrases = new HashSet<>();
        Set<String> verbPhrases = new HashSet<>();
        for (Parse p : topParses) {
            p.show();
            getPhrases(p, nounPhrases, verbPhrases);
//            System.out.println("Nouns: ");
//            for (String noun : nounPhrases) {
//                System.out.println("Noun: " + noun);
//            }
//            System.out.println("Verbs: ");
//            for (String verb : verbPhrases) {
//                System.out.println("Verb: " + verb);
//            }
        }
        ParserOutput output = new ParserOutput(nounPhrases, verbPhrases);
        return output;
    }

    private void getPhrases(Parse p, Set<String> nounPhrases, Set<String> verbPhrases) {
        if (identityTags.contains(p.getType())) {
            nounPhrases.add(p.getCoveredText());
        }
        if (actionTags.contains(p.getType())) {
            verbPhrases.add(p.getCoveredText());
        }
        for (Parse child : p.getChildren())
            getPhrases(child, nounPhrases, verbPhrases);
    }
}
