package by.gsu.pms.utils;

import by.gsu.pms.enums.Operation;

import java.io.BufferedReader;
import java.util.Scanner;

import static by.gsu.pms.enums.Messages.*;

public class ThreadGenerator {

    private static final int lowLimit = 1;
    private static final Scanner scanner = new Scanner(System.in);

    private Operation operation;
    private int numberOfThreads;
    private int topLimit;

    private volatile int result;

    public void execute() {

        readTopLimit();

        readThreadNumber();

        chooseOperation();

        if(operation == Operation.MULTIPLY) {
            result = 1;
        } else {
            result = 0;
        }

        Thread[] threads = new Thread[numberOfThreads];

        int difference = topLimit / numberOfThreads;

        int[] valuesToProcess = new int[numberOfThreads + 1];

        valuesToProcess[0] = lowLimit;

        StringBuffer stringBuffer = new StringBuffer(NUMBERS.getText());

        for (int i = 0; i < numberOfThreads; i++) {

            if(i == numberOfThreads - 1) {
                valuesToProcess[i + 1] = topLimit;
            } else {
                valuesToProcess[i + 1] = (i + 1) * difference;
            }

            int finalI = i;
            threads[i] = new Thread( () -> {
                int currentValue = valuesToProcess[finalI];
                while (currentValue < valuesToProcess[finalI + 1]) {
                    currentValue++;
                    if(checkSum(currentValue)) {
                        result = operation.executeOperation(currentValue, result);
                        stringBuffer.append(currentValue + SEPARATOR.getText());
                    }
                }
            });
        }

        for (Thread t: threads) { // parallel execution of files processing
            t.start(); // method "start" executes method "run" (which was override before) in the other thread
        }

        for (Thread t: threads) {
            try {
                t.join(); // waiting for every Thread finishes
            } catch (InterruptedException e) {
                System.out.println(THREAD_ERROR.getText());
            }
        }

        final String resultString = stringBuffer.toString();

        System.out.println(resultString.substring(0, resultString.length() - 21));
    }

    public int getResult() {
        return result;
    }

    private static boolean checkSum(int number){

        char[] numbers = Integer.toString(number).toCharArray();

        long sum = 0;

        for (char c : numbers) {
            sum += Integer.parseInt(Character.toString(c));
        }

        return sum > 10;
    }

    private void chooseOperation() {

        boolean isCorrect = true;
        String operationName;
        Operation operation;

        while(isCorrect){

            System.out.println(CHOOSE_OPERATION.getText());

            operationName = scanner.next();

            operation = Operation.getByName(operationName);

            if(operation != null) {
                this.operation = operation;
                isCorrect = false;
            } else {
                System.out.println(CHECK_ENTRY.getText());
            }
        }
    }

    private void readTopLimit() {

        boolean isCorrect = true;
        int topLimit;

        while(isCorrect){

            System.out.println(ENTER_TOP_LIMIT.getText());

            try{

                topLimit = scanner.nextInt();

                if(topLimit > 0) {
                    this.topLimit = topLimit;
                    isCorrect = false;
                } else {
                    System.out.println(CHECK_ENTRY.getText());
                }

            } catch (NumberFormatException e){
                System.out.println(CHECK_ENTRY.getText());
            }
        }
    }

    private void readThreadNumber() {

        boolean isCorrect = true;
        int threadNumber;

        while(isCorrect){

            System.out.println(ENTER_THREADS.getText());

            try{

                threadNumber = scanner.nextInt();

                if(threadNumber > 0) {
                    this.numberOfThreads = threadNumber;
                    isCorrect = false;
                } else {
                    System.out.println(CHECK_ENTRY.getText());
                }

            } catch (NumberFormatException e){
                System.out.println(CHECK_ENTRY.getText());
            }
        }
    }
}
