package by.gsu.pms;

import java.util.ArrayList;
import java.util.List;

public class Word implements Comparable<Word>{
    private String word;

    public Word(String word) {
        setWord(word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        if(Punctuation.hasPunctuation(word))
            throw new RuntimeException("Words can\'t contain punctuation!");
        this.word = word;
    }

    public static List<Word> getWordsStartWithVowel(List<Word> words){
        List<Word> ret = new ArrayList<>();
        for (Word w :
                words) {
            if (w.startsWithVowel()){
                ret.add(w);
            }
        }
        return ret;
    }

    public boolean startsWithVowel(){
        return Symbol.VOWELS.contains(String.valueOf(word.charAt(0)));

    }

    public Symbol getFirstConsonant(){
        for (char c :
                word.toCharArray()) {
            if (Symbol.CONSONANT.contains(String.valueOf(c)))
                return new Symbol(c);
        }
        return null;
    }

    @Override
    public int compareTo(Word o) {
        Symbol t = getFirstConsonant();
        Symbol x = o.getFirstConsonant();
        if(t == null && x == null)
            return word.charAt(0) - o.word.charAt(0);
        else if(t == null && x != null)
            return 1;
        else if(x == null && t != null)
            return -1;
        else
            return t.getSymbol().toLowerCase().compareTo(x.getSymbol().toLowerCase());
    }

    @Override
    public String toString() {
        return word;
    }
}