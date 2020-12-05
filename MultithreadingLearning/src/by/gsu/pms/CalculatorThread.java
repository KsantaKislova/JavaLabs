package by.gsu.pms;

import by.gsu.pms.utils.ThreadGenerator;
import static by.gsu.pms.enums.Messages.*;

public class CalculatorThread {
    public static void main(String[] args) {

         ThreadGenerator threadGenerator = new ThreadGenerator();

         threadGenerator.execute();

        System.out.println(RESULT.getText() + threadGenerator.getResult());

    }
}
