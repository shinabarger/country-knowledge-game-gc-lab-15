import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan1 = new Scanner(System.in);
        ArrayList<String> countryList = new ArrayList<>();
        int listSize = 0;
        int highScore = 0;
        String yesOrNo = "";
        CountriesTextFile countriesTextFile = new CountriesTextFile();
        Path temp = Paths.get("Temp.txt");
        File tempFile = temp.toFile();
        Scanner scan = new Scanner(System.in);

        int userOption = CountriesTextFile.mainMenu(scan1);

        while (true) {
            if (userOption == 4) {
                System.out.println("Okay! Thanks for playing! You remembered " + highScore + " countries!");
                break;

            } else if (userOption == 3) {
                //TODO remove the country;
                Path filePatch = Paths.get("countries.txt");
                File countries = filePatch.toFile();
                StringBuilder output = readTextFromFile("countries.txt");
                System.out.println(output);
                try {
                    String deleteCountry = Validator.getString(scan, "Which country would you like to delete?");
                    FileReader r = new FileReader(String.valueOf(countryList));
                    BufferedReader reader = new BufferedReader(r);

                    PrintWriter out = new PrintWriter(new FileOutputStream(tempFile), false);
                    for (String line; (line = reader.readLine()) != null; ) {
                        line = line.replace(deleteCountry, "");
                        out.println(line);
                    }
                    reader.close();
                    out.close();
                    countries.delete();
                    tempFile.renameTo(countries);
                } catch (FileNotFoundException e) {

                }

                yesOrNo = Validator.yesOrNo(scan, "Want to remove another one? again? Y/N");
                if (yesOrNo.equalsIgnoreCase("N")) {
                    break;
                }
            } else if (userOption == 2) {
                String addCountryName = Validator.getString(scan, "Add a country to the list: ");
                countryList.add(0, addCountryName);
                highScore = countryList.size();
                writeTextToFile("countries.txt", countryList + "\n");
                System.out.println("Great. Your current list is: ");
                StringBuilder output = readTextFromFile("countries.txt");
                System.out.println(output);
                yesOrNo = Validator.yesOrNo(scan, "Want to try again? Y/N");
                if (yesOrNo.equalsIgnoreCase("N")) {
                    break;
                } else
                    userOption = CountriesTextFile.mainMenu(scan1);

            } else if (userOption == 1) {
                System.out.println("Great. Your current list is: ");
                StringBuilder output = readTextFromFile("countries.txt");
                System.out.println(output);
                yesOrNo = Validator.getString(scan, "Press MENU to return to main Menu");
                if (yesOrNo.equalsIgnoreCase("MENU")) {
                    userOption = CountriesTextFile.mainMenu(scan1);
                } else break;

            }

        }

    }

    public static void writeTextToFile(String fileName, String Input) {
        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(
                    productsFile, true)); // append = true

            // PrintWriter out2 = new PrintWriter(productsFile);

            out.print(Input);

            out.close();

        } catch (FileNotFoundException ex) {

        }

    }

    public static StringBuilder readTextFromFile(String fileName) {
        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();
        StringBuilder result = new StringBuilder();

        try {
            FileReader r = new FileReader(productsFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line);
                result.append(line + "\n");
                line = reader.readLine();
            }

            reader.close();
            return result;
        } catch (FileNotFoundException ex) {

            return null;

        } catch (IOException ex) {
            return null;
        }

    }

}