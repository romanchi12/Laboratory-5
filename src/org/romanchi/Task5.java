package org.romanchi;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task5 implements Task {

    @Override
    public void execute() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("text.txt")));
            StringBuilder text = new StringBuilder();
            String temp;
            while((temp = bufferedReader.readLine())!=null){
                text.append(temp);
            }
            String[] words = text.toString().split("[ .,!?]");
            List<String> wordsList = Arrays.asList(words);
            Object[] smt = (wordsList.stream().filter(word -> !"".equals(word)).sorted(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.toLowerCase().compareTo(o2.toLowerCase());
                }
            }).toArray());
            for(Object sm:smt){
                String s = (String) sm;
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
