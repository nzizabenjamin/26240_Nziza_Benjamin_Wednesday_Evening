/**
 * Summary:
 * This file demonstrates Java programs that deliberately trigger specific exceptions
 * and handle them appropriately using try-catch blocks. Each program includes
 * comments to explain the purpose of the code.
 */

import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {

    // Checked Exception Examples

    // 1. IOException
    public static void simulateIOException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent_file.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 2. FileNotFoundException
    public static void simulateFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("nonexistent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException
    public static void simulateEOFException() {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(new byte[0]);
            ObjectInputStream ois = new ObjectInputStream(bais);
            ois.readObject();
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // 4. SQLException
    public static void simulateSQLException() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://invalid_url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    public static void simulateClassNotFoundException() {
        try {
            Class.forName("nonexistent.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Unchecked Exception Examples

    // 6. ArithmeticException
    public static void simulateArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // 7. NullPointerException
    public static void simulateNullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    // 8. ArrayIndexOutOfBoundsException
    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            int[] array = {1, 2, 3};
            int value = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // 9. ClassCastException
    public static void simulateClassCastException() {
        try {
            Object obj = new Integer(10);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    // 10. IllegalArgumentException
    public static void simulateIllegalArgumentException() {
        try {
            Thread.sleep(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught: " + e.getMessage());
        }
    }

    // 11. NumberFormatException
    public static void simulateNumberFormatException() {
        try {
            int number = Integer.parseInt("invalid_number");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Invoke each simulation
        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }
}
