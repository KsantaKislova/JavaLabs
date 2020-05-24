package by.gsu.pms;

public class Punctuation {
    private static final String PUNCTUATION = ",.?!;:()[]{}\n\t -";

    public static boolean isPunctuation(String s){
        return PUNCTUATION.contains(s);
    }

    public static boolean hasPunctuation(String s){
        for (char q :
                PUNCTUATION.toCharArray()) {
            if(s.contains(String.valueOf(q)))
                return true;
        }
        return false;
    }
}
