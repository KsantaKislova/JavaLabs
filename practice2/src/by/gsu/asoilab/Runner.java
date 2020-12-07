package by.gsu.asoilab;

public class Runner {

    public static void main(String[] args) {

        UniformMaterial steel = new UniformMaterial("steel",7850);
        SubjectUniformMaterial wire = new SubjectUniformMaterial("wire", steel, 0.03);

        UniformMaterial copper = new UniformMaterial("copper", 8500);

        System.out.println(steel.toString());
        System.out.println(wire.toString());

        wire.setMaterial(copper);
        System.out.println(copper.toString());
        System.out.println(wire.toString());
    }

}


