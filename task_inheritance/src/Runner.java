// 8. Транспорт. 
// Определить иерархию подвижного состава железнодорожного транспорта. 
// Создать пассажирский поезд. 
// Подсчитать общую численность пассажиров и багажа. 
// Провести сортировку вагонов поезда на основе уровня комфортности. 
// Найти в поезде вагоны, соответствующие заданному диапазону параметров числа пассажиров.



import by.gsu.pms.beans.*;
import by.gsu.pms.writers.WriterInfo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {
    private static Scanner in = new Scanner(System.in);
    private static Train train = new Train(10);

    public static void main(String[] args) {
        train.setCarriages(new RailwayCarriage[]{   new SleepingCar(5, 5, 5),
                                                    new SleepingCar(5,2, 2),
                                                    new CoupeCarriage(4,5, 3),
                                                    new CoupeCarriage(5,1, 5),
                                                    new OpenCarriage(5,5, 5),
                                                    new OpenCarriage(5,4, 4),
                                                    new SleepingCar(5,5, 3),
                                                    new SleepingCar(4,4, 4),
                                                    new CoupeCarriage(5,4, 5),
                                                    new SleepingCar(5,5, 5)
        });
        while (true){
            menu();
        }
    }

    private static void menu(){
        WriterInfo.print("1 - print all\n" +
                "2 - show total number of baggage and passengers\n" +
                "3 - get carriages in range\n" +
                "4 - sort carriages by comfort level\n" +
                "other number to exit");
        try {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    WriterInfo.print(train.getCarriages());
                    break;
                case 2:
                    WriterInfo.print("Total number is " + train.getTotalNumber());
                    break;
                case 3:
                    int min, max;
                    WriterInfo.print("Enter minimal number of passengers : ");
                    min = in.nextInt();
                    WriterInfo.print("Enter maximal number of passengers : ");
                    max = in.nextInt();
                    WriterInfo.print("Carriages in range : \n");
                    WriterInfo.print(train.getCarriagesInRad(min, max));
                    break;
                case 4:
                    train.sortByComfort();
                    WriterInfo.print("Carriages were sorted\n");
                    break;
                default:
                    WriterInfo.print("Goodbye!");
                    System.exit(0);
            }
        } catch (InputMismatchException e){
            WriterInfo.print("Enter number !");
            in.nextLine();
            return;
        }
    }
}
