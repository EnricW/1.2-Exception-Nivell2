package Level2.Exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static byte readByte(String message) {
        byte value = 0;
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + ": ");
                value = scanner.nextByte();
                valueCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static int readInt(String message) {
        int value = 0;
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + ": ");
                value = scanner.nextInt();
                valueCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static float readFloat(String message) {
        float value = 0.0f;
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + ": ");
                value = scanner.nextFloat();
                valueCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static double readDouble(String message) {
        double value = 0.0;
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + ": ");
                value = scanner.nextDouble();
                valueCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static char readChar(String message) {
        char value = ' ';
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + ": ");
                value = scanner.next().charAt(0);
                valueCorrect = true;
            } catch (Exception e) {
                System.out.println("Error. Please enter a character.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static String readString(String message) {
        String value = "";
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + ": ");
                value = scanner.nextLine();
                valueCorrect = true;
            } catch (Exception e) {
                System.out.println("Error. Please enter a text string.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static boolean readYesNo(String message) {
        String value = "";
        boolean response = false;
        boolean valueCorrect = false;

        while (!valueCorrect) {
            try {
                System.out.print(message + " (y/n): ");
                value = scanner.nextLine().toLowerCase();
                if (value.equals("y")) {
                    response = true;
                    valueCorrect = true;
                } else if (value.equals("n")) {
                    response = false;
                    valueCorrect = true;
                } else {
                    System.out.println("Error. Please enter 'y' or 'n'.");
                }
            } catch (Exception e) {
                System.out.println("Error. Please enter 'y' or 'n'.");
                scanner.nextLine();
            }
        }

        return response;
    }
}
