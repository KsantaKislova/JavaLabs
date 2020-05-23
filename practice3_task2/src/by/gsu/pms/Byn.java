package by.gsu.pms;

public class Byn {
    private final int coins;

    public Byn(int coins) {
        this.coins = coins;
    }

    public Byn(Byn byn) {
        coins = byn.coins;
    }
    public int getRubs() {
        return coins/100;
    }
    public int getCoins() {
        return coins%100;
    }

    public Byn add(Byn byn) {
        return new Byn(this.coins + byn.coins);
    }
    public Byn sub(Byn byn) {
        return new Byn(coins - byn.coins);
    }

    public Byn mul(int k){
        return new Byn(coins * k);
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", coins/100, coins%100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return coins == byn.coins;
    }

    public int compareTo(Byn o){
        return coins - o.coins;
    }

}
