package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void removeExcessSpaces(){
        if(text.contains("\t"))
            text = text.replaceAll("\t"," ");
        while(text.contains("  ")) {
            text = text.replaceAll("  ", " ");
        }
    }

    public List<Word> getWords(){
        List<Word> words = new ArrayList<Word>();
        text = text.replaceAll("\\."," ");
        text = text.replaceAll("-"," ");
        text = text.replaceAll(";"," ");
        text = text.replaceAll(","," ");

        text = text.replaceAll("!"," ");
        text = text.replaceAll("\\?"," ");
        text = text.replaceAll(":"," ");

        removeExcessSpaces();
        for (String s :
                text.split(" ")) {
            words.add(new Word(s));
        }
        return words;
    }
}