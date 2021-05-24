package by.gsu.asoilab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
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

        try {
            FileOutputStream fos = new FileOutputStream("wards.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(wards);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
