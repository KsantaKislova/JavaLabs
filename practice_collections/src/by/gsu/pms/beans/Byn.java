package by.gsu.pms.beans;

import java.util.Objects;

public class Byn implements Comparable<Byn>{
    private int value;

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn(Byn byn){
        this(byn.value);
    }

    public Byn mul(double multiplier){
        this.value = (int) (value * multiplier);
        return this;
    }

    public Byn mul(int multiplier){
        this.value *= multiplier;
        return this;
    }

    public Byn sub(Byn byn){
        this.value -= byn.value;
        return this;
    }

    public Byn sub(int value){
        this.value -= value;
        return this;
    }

    public Byn add(int value){
        this.value += value;
        return this;
    }

    public Byn add(Byn byn){
        this.value += byn.value;
        return this;
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }
}