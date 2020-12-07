package by.gsu.asoilab;

public class SubjectUniformMaterial {

    private String subjectName;
    private UniformMaterial material;
    private double volume;

    public SubjectUniformMaterial() {
    }

    public SubjectUniformMaterial(String subjectName, UniformMaterial material, double volume) {
        this.subjectName = subjectName;
        this.material = material;
        this.volume = volume;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public UniformMaterial getMaterial() {
        return material;
    }

    public void setMaterial(UniformMaterial material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass(){
        return material.getDensity() * volume;
    }

    @Override
    public String toString() {
        return this.subjectName + ";"
                + this.material.getName() + ";"
                + this.material.getDensity() + ";"
                + this.volume + ";"
                + this.getMass() + ";";
    }
}
