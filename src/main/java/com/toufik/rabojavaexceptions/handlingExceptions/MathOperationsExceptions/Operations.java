package com.toufik.rabojavaexceptions.handlingExceptions.MathOperationsExceptions;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Operations {

    @Test
    public void mainOperations() {
//        BufferedReader reader = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"))){
            processingFile(reader);
        }
        catch (FileNotFoundException exception){
            System.out.println("Error: " + exception.getMessage());
        }
        catch (IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }catch (Exception exception){
            System.out.println("Error: " + exception.getMessage());
        }
//        catch (Exception ex) {
//            System.out.println("Error: " + ex.getMessage());
//        }
//
//        because of the argument try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputtt.txt"))){
//        finally {
//            try {
//                System.out.println("Closing file : \"src/main/resources/input.txt\"");
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Error closing file");
//
//            }
//        }
    }

    private static void processingFile(BufferedReader bufferedReader) throws IOException {
        String inputLine = null;
        while ((inputLine = bufferedReader.readLine()) != null)
            performOperation(inputLine);
    }
    private static void performOperation(String inputLine) {
        String[] parts = inputLine.split(" ");
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        int leftVal = valueFromWord(parts[1]);
        int rightVal = valueFromWord(parts[2]);

        int result = execute(operation, leftVal, rightVal);

        System.out.println(inputLine + " = " + result);
    }

    static int execute(MathOperation operation, int leftVal, int rightVal) {
        int result = 0;
        switch (operation) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                if (rightVal == 0){
                    throw new ArithmeticException("Zero not permitted by devide operations");
                }
                result = leftVal / rightVal;
                break;
        }
        return result;
    }

    static int valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        int value = -1;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if (value == -1)
            value = Integer.parseInt(word);

        return value;
    }
}
