package by.gsu.asoilab;

import by.gsu.asoilab.exceptions.EmptyNameException;
import by.gsu.asoilab.exceptions.NegativeNumberException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        try {
            Ward[] wards = {new Ward(5, "Bob", 2),
                    new Ward(4, "Mike",1),
                    new Ward(5,"Tom",0),
                    new Ward(4, "Bree",1),
                    new Ward(4, "Kevin",2),
                    new Ward(6, "Jim",5),
                    new Ward(6, "Vivien",3),
                    new Ward(5, "Leo",2),
                    new Ward(3, "Chris",0),
                    new Ward(5, "Justin",1)};

            FileOutputStream fos = new FileOutputStream("wards.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(wards);

            oos.close();
        } catch (StackOverflowError e) {
            System.out.println("You\'v run out of memory! :(");
        } catch (EmptyNameException e) {
            System.out.println(e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File \"wards.bin\" has not been found!");
        } catch (IOException e) {
            System.out.println("Some trouble with input happened!");
        }

    }
}
