package com.vulcans.chatbot.data.input;

import com.vulcans.chatbot.data.Context;
import com.vulcans.chatbot.data.input.TrainingData;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 6/11/2016.
 */
public class DataFeeder {

    private static final String DATA_SPLITTER = "\\|";
    private static final int CTX_INDEX= 0;
    private static final int SEQ_INDEX = 1;
    private static final int KEY_INDEX= 2;
    private static final int VALUE_INDEX = 3;
    public static Map<String, TrainingData> dataMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public void loadData(InputStream dataFile) {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new InputStreamReader(dataFile));
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) continue;
                String[] data = line.split(DATA_SPLITTER);
                dataMap.put(data[KEY_INDEX], new TrainingData(Context.valueOf(data[CTX_INDEX]), Integer.valueOf(data[SEQ_INDEX]), data[VALUE_INDEX]));
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }

    }
}
