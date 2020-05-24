package by.gsu.pms;

import java.util.Objects;

public class Symbol {
    public static final String VOWELS = "EYUIOAeyuioa";
    public static final String CONSONANT = "QWRTPSDFGHJKLZXCVBNMqwrtpsdfghjklzxcvbnm";
    private String symbol;

    public Symbol() {
    }

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public Symbol(char symbol) {
        setSymbol(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public char getCharSymbol() {
        return symbol.charAt(0);
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = String.valueOf(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != o.getClass() && String.class != o.getClass())) return false;
        if(o.getClass() == String.class)
            return o.equals(symbol);
        else
            return ((Symbol) o).symbol.equals(symbol);
    }

    public static boolean hasSymbol(String s, Symbol q){
        return s.contains(q.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
