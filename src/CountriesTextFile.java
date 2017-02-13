import java.io.File;
import java.util.Scanner;

/**
 * Created by davidshinabarger on 2/13/17.
 */
public class CountriesTextFile extends Main {
    public static int mainMenu(Scanner scan1) {
        System.out.println("Enter 1 to see all the countries you remembered.");
        System.out.println("Enter 2 to enter a new country. ");
        System.out.println("Enter 3 to remove a country.");
        System.out.println("Enter 4 to exit the app.");
        return Validator.getInt(scan1, "", 1, 4);
    }

    public CountriesTextFile() {

    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


}
