package Level2.Exercise2;

public class Main {
    public static void main(String[] args) {

        byte age = Input.readByte("Enter your age");
        System.out.println("Your age is: " + age);

        int number = Input.readInt("Enter a number");
        System.out.println("The number is: " + number);

        float grade = Input.readFloat("Enter a grade");
        System.out.println("The grade is: " + grade);

        double height = Input.readDouble("Enter your height in meters");
        System.out.println("Your height is: " + height);

        char initial = Input.readChar("Enter the initial of your name");
        System.out.println("The initial is: " + initial);

        String name = Input.readString("Enter your name");
        System.out.println("Your name is: " + name);

        boolean response = Input.readYesNo("Do you like this code?");
        System.out.println("Your response is: " + response);
    }
}
