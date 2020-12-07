package by.gsu.asoilab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner sr = null;
        try {
            sr = new Scanner(new FileReader("src/in.csv"));
            ArrayList<House> houseList = new ArrayList<>();
            Scanner sr = new Scanner(System.in);

            while ((sr.nextInt()) > 0) {
                houseList.add(sr.hasNext());
                System.out.println(houseList);
            }
            sr.close();
            Collections.sort(houseList);
            System.out.println(houseList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*
        try (BufferedReader br = new BufferedReader(new FileReader("src/in.csv"))){
            while(br.ready()) {
                houseList.add(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
          */

    }

}
