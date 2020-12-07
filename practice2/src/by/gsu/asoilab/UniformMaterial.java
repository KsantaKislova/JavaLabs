package by.gsu.asoilab;

public class UniformMaterial {

    private String name;
    private int density;

    public UniformMaterial() {
    }

    public UniformMaterial(String name, int density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return this.name + ";" + this.density + ";";
    }
}
