package by.gsu.pms.writers;

import by.gsu.pms.beans.RailwayCarriage;

import java.util.Arrays;

public class WriterInfo {
    public static void print(Object o){
        System.out.println(o.toString());
    }

    public static void print(String t){
        System.out.println(t);
    }
    public static void print(RailwayCarriage[] rc){
        String res = Arrays.toString(rc);
        if(res.length()==2) {
            System.out.println("Carriages array is empty!");
            return;
        }
        System.out.println("\t" + res.substring(1,res.length()-1).replaceAll(", ","\t"));
    }
}
