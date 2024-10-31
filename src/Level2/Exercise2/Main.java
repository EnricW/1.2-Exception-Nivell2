package Level2.Exercise2;

public class Main {
    public static void main(String[] args) {

        byte age = Input.readByte("Enter your age");
        System.out.println("Your age is " + age);

        int number = Input.readInt("Enter the year you were born");
        System.out.println("The year is " + number);

        float height = Input.readFloat("Enter your height in meters");
        System.out.println("Your height is " + height);

        double pi = Input.readDouble("Enter the pi number (with 4 decimals)");
        System.out.printf("The pi number is %.4f\n", pi);

        char initial = Input.readChar("Enter the initial of your name");
        System.out.println("The initial is " + initial);

        String username = Input.readString("Enter a Username");
        System.out.println("Your Username is " + username);

        boolean answer = Input.readYesNo("Did you like this code?");
        System.out.println("Your answer is " + answer);
    }
}
