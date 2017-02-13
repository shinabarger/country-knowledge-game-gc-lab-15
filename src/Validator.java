import java.util.Scanner;

public class Validator {
    public static String getString(Scanner sc, String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt);
        String s = scan.nextLine();// read user entry

           // discard any other data entered on the line

        return s;
    }
    public static String getRockPaperScissorsString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();// read user entry

        boolean isValid = false;
        while (isValid == false) {
            if (s.equalsIgnoreCase("rock") | s.equalsIgnoreCase("paper") | s.equalsIgnoreCase("scissors")) {
                isValid = true;
                break;

            } else {
                System.out.println("Oh no! That wasn't rock paper or scissors. Try again.");
                s = sc.nextLine();
            }
            sc.nextLine();
        }
        return s;
    }
    public static String yesOrNo(Scanner sc, String prompt) {

        String s = "";
        boolean isValid = false;
        while (isValid == false) {
            System.out.println(prompt);
            s = sc.next();// read user entry
            if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N")) {
                break;

            } else {
                System.out.println("Oh no! That wasn't right. Try again..");

            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return s;
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Oopsie! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
                             int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i < min)
                System.out.println(
                        "Oops! Number must be " + min + " or greater.");
            else if (i > max)
                System.out.println(
                        "Uh-oh! Number must be " + max + " or less.");
            else
                isValid = true;
        }

        return i;
    }

    public static double getDouble(Scanner sc, String prompt) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner sc, String prompt,
                                   double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d < min)
                System.out.println(
                        "Ruh-roh! Number must be " + min + " or greater.");
            else if (d > max)
                System.out.println(
                        "Nice try buddy! Number must be " + max + " or less.");
            else
                isValid = true;
        }
        return d;
    }
}