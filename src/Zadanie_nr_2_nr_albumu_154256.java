import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Temperature Converter & Data Logger
 * Author: Adrian Lesniak
 *
 * This program allows you to:
 * 1. Enter your name and temperature in Celsius, convert it to Fahrenheit, and save the data.
 * 2. Read and display all saved data from file.
 * 3. Exit the program.
 *
 * All data is saved in dane.txt. Errors are logged in error.log.
 *
 * MENU OPTIONS:
 * 1 - Enter data and convert temperature
 * 2 - Read saved data from file
 * 3 - Exit
 */

public class Zadanie_nr_2_nr_albumu_154256 {
    // ANSI color codes for Windows CMD (bright colors)
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[93m";
    private static final String CYAN = "\u001B[96m";
    private static final String GREEN = "\u001B[92m";
    private static final String MAGENTA = "\u001B[95m";
    private static final String WHITE = "\u001B[97m";
    private static final String RED = "\u001B[91m";

    public static void main(String[] args) {
        new Zadanie_nr_2_nr_albumu_154256().start();
    }

    /**
     * Main program loop. Shows menu and returns after each action.
     */
    public void start() {
        boolean running = true;
        while (running) {
            clearScreen();
            printHeader();
            int choice = mainMenu();
            switch (choice) {
                case 1:
                    clearScreen();
                    enterData();
                    break;
                case 2:
                    readDataFromFile();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    break;
            }
            if (running) {
                returnToMenu();
            }
        }
        System.out.println(GREEN + "Thank you for using the program!" + RESET);
    }

    /**
     * Prints the program header, author, and menu instructions with ASCII art.
     */
    private void printHeader() {
        System.out.println(YELLOW + "============================================================" + RESET);
        System.out.println(CYAN + "   TEMPERATURE CONVERTER & DATA LOGGER" + RESET);
        System.out.println(CYAN + "   Author: Adrian Lesniak" + RESET);
        System.out.println(YELLOW + "------------------------------------------------------------" + RESET);
        System.out.println(CYAN + " 1 - Enter your name and temperature, convert and save" + RESET);
        System.out.println(CYAN + " 2 - Read and display all saved data" + RESET);
        System.out.println(CYAN + " 3 - Exit the program" + RESET);
        System.out.println(YELLOW + "============================================================" + RESET);
        printThermometerArt();
    }

    /**
     * Prints a simple ASCII thermometer (no text, just the thermometer art).
     */
    private void printThermometerArt() {
        System.out.println(YELLOW + "                            ______________________" + RESET);
        System.out.println(YELLOW + "                            |   ^F     _    ^C   |" + RESET);
        System.out.println(YELLOW + "                            |  100  - | | -  40  |" + RESET);
        System.out.println(YELLOW + "                            |   90  - | | -  30  |" + RESET);
        System.out.println(YELLOW + "                            |   80  - | | -  25  |" + RESET);
        System.out.println(YELLOW + "                            |   70  - | | -  20  |" + RESET);
        System.out.println(YELLOW + "                            |   60  - | | -  15  |" + RESET);
        System.out.println(YELLOW + "                            |   50  - | | -  10  |" + RESET);
        System.out.println(YELLOW + "                            |   40  - | | -   5  |" + RESET);
        System.out.println(YELLOW + "                            |   30  - | | -   0  |" + RESET);
        System.out.println(YELLOW + "                            |   20  - | | -  -5  |" + RESET);
        System.out.println(YELLOW + "                            |   10  - | | - -10  |" + RESET);
        System.out.println(YELLOW + "                            |    0  - | | - -20  |" + RESET);
        System.out.println(YELLOW + "                            |  -10  - | | - -25  |" + RESET);
        System.out.println(YELLOW + "                            |  -20  - |_| - -30  |" + RESET);
        System.out.println(YELLOW + "                            |  -30  - |*| - -35  |" + RESET);
        System.out.println(YELLOW + "                            |        '***`       |" + RESET);
        System.out.println(YELLOW + "                            |       (*****)      |" + RESET);
        System.out.println(YELLOW + "                            |        `---'       |" + RESET);
        System.out.println(YELLOW + "                            |____________________|" + RESET);
    }

    /**
     * Shows the main menu and returns the user's choice.
     */
    private int mainMenu() {
        System.out.print(WHITE + "Choose an option (1-3): " + RESET);
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(RED + "Invalid choice!" + RESET);
        }
        return choice;
    }

    /**
     * Waits for the user to press ENTER to return to the menu.
     * Uses Scanner to avoid leaving newline in buffer.
     */
    private void returnToMenu() {
        System.out.print(CYAN + "\nPress ENTER to return to the menu..." + RESET);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    /**
     * Prompts the user for their name, surname, and temperature, validates input, converts temperature, and saves data.
     * Handles exceptions and logs errors to error.log.
     */
    private void enterData() {
        String name = null;
        String surname = null;
        float temperature = 0;
        Scanner sc = new Scanner(System.in);
        try {
            // Get name
            while (true) {
                System.out.print(WHITE + "Enter your name: " + RESET);
                name = sc.nextLine().trim();
                if (name.matches("^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ]+$")) break;
                System.out.println(RED + "Error! Name can only contain letters." + RESET);
            }
            // Get surname
            while (true) {
                System.out.print(WHITE + "Enter your surname: " + RESET);
                surname = sc.nextLine().trim();
                if (surname.matches("^[A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ-]+$")) break;
                System.out.println(RED + "Error! Surname can only contain letters and hyphens." + RESET);
            }
            // Get temperature
            while (true) {
                System.out.print(WHITE + "Enter temperature in °C: " + RESET);
                String tempStr = sc.nextLine().replace(",", ".");
                try {
                    temperature = Float.parseFloat(tempStr);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(RED + "Error! Enter a valid number." + RESET);
                    logError("Temperature parsing error: " + tempStr);
                }
            }
            float tempF = toFahrenheit(temperature);
            showResult(name, surname, temperature, tempF);
            saveToFile(name, surname, temperature, tempF);
        } catch (Exception e) {
            System.out.println(RED + "An unexpected error occurred. Details saved in error.log" + RESET);
            logError("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Logs an error to error.log.
     */
    private void logError(String msg) {
        try (FileWriter fw = new FileWriter("error.log", true)) {
            fw.write(new Date() + ": " + msg + "\n");
        } catch (IOException e) {
            System.out.println(RED + "Cannot write to error.log" + RESET);
        }
    }

    /**
     * Saves user data to dane.txt.
     */
    private void saveToFile(String name, String surname, float tempC, float tempF) {
        try (FileWriter fw = new FileWriter("dane.txt", true)) {
            fw.write(name + "," + surname + "," + tempC + "," + tempF + "\n");
        } catch (IOException e) {
            System.out.println(RED + "Error saving to dane.txt" + RESET);
            logError("Error saving to dane.txt: " + e.getMessage());
        }
    }

    /**
     * Displays the result in the console with ASCII graphics and color.
     */
    private void showResult(String name, String surname, float tempC, float tempF) {
        System.out.println(GREEN + "\n****************************************" + RESET);
        System.out.println(GREEN + "*  Result for: " + name + " " + surname + RESET);
        System.out.println(GREEN + "*  Temperature: " + YELLOW + tempC + " °C" + RESET);
        System.out.println(GREEN + "*  In Fahrenheit: " + YELLOW + tempF + " °F" + RESET);
        System.out.println(GREEN + "****************************************" + RESET);
        printThermometerArtColor(tempC, tempF);
    }

    /**
     * Prints a thermometer with colored value for the closest value to tempC and tempF.
     * If value is not present, shows result below the thermometer.
     */
    private void printThermometerArtColor(float tempC, float tempF) {
        // Thermometer lines with value positions (poprawione wyrównanie)
        String[] lines = new String[] {
            "                            ______________________",
            "                            |   ^F     _    ^C   |",
            "                            |  100  - | | -  40  |",
            "                            |   90  - | | -  30  |",
            "                            |   80  - | | -  25  |",
            "                            |   70  - | | -  20  |",
            "                            |   60  - | | -  15  |",
            "                            |   50  - | | -  10  |",
            "                            |   40  - | | -   5  |",
            "                            |   30  - | | -   0  |",
            "                            |   20  - | | -  -5  |",
            "                            |   10  - | | - -10  |",
            "                            |    0  - | | - -20  |",
            "                            |  -10  - | | - -25  |",
            "                            |  -20  - |_| - -30  |",
            "                            |  -30  - |*| - -35  |",
            "                            |        '***`       |",
            "                            |       (*****)      |",
            "                            |        `---'       |",
            "                            |____________________|"
        };
        // Dostępne wartości na termometrze
        int[] cVals = {40, 30, 25, 20, 15, 10, 5, 0, -5, -10, -20, -25, -30, -35};
        int[] fVals = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 0, -10, -20, -30};
        int cLine = -1, fLine = -1;
        boolean cOut = false, fOut = false;
        // Zakresy
        if (tempC > 40 || tempC < -35) cOut = true;
        if (tempF > 100 || tempF < -30) fOut = true;
        // Najbliższa większa lub równa wartość (zaokrąglanie w górę, jeśli nie ma to najniższa)
        if (!cOut) {
            for (int i = 0; i < cVals.length; i++) {
                if (tempC >= cVals[i]) { cLine = i + 2; break; }
            }
            if (cLine == -1) cLine = 2 + cVals.length - 1; // najniższa
        }
        if (!fOut) {
            for (int i = 0; i < fVals.length; i++) {
                if (tempF >= fVals[i]) { fLine = i + 2; break; }
            }
            if (fLine == -1) fLine = 2 + fVals.length - 1; // najniższa
        }
        // Kolorowanie tylko liczby, bez zmiany długości linii
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            // Koloruj tylko wartość F (po lewej)
            if (i == fLine && !fOut) {
                String fStr = String.format("%3d", fVals[fLine-2]);
                line = line.replaceFirst("\\b" + fStr + "\\b", CYAN + fStr + RESET);
            }
            // Koloruj tylko wartość C (po prawej)
            if (i == cLine && !cOut) {
                String cStr = String.format("%3d", cVals[cLine-2]);
                int idx = line.lastIndexOf(cStr);
                if (idx != -1) {
                    line = line.substring(0, idx) + CYAN + cStr + RESET + line.substring(idx + cStr.length());
                }
            }
            System.out.println(YELLOW + line + RESET);
        }
        // Jeśli wartość poza zakresem, pokaż wynik pod termometrem
        if (cOut || fOut) {
            System.out.println(CYAN + "\n  Value not on thermometer: " + tempC + " °C / " + tempF + " °F" + RESET);
        }
    }

    /**
     * Converts Celsius to Fahrenheit.
     */
    private static float toFahrenheit(float celsius) {
        return ((celsius * 9F) / 5F) + 32F;
    }

    /**
     * Reads and displays all saved data from dane.txt in a formatted table.
     */
    private void readDataFromFile() {
        System.out.println(CYAN + "\nSaved data from file:" + RESET);
        System.out.println(YELLOW + "+----------------+----------------+------------+------------+" + RESET);
        System.out.println(YELLOW + "|     Name       |    Surname     |   °C       |   °F       |" + RESET);
        System.out.println(YELLOW + "+----------------+----------------+------------+------------+" + RESET);
        try (BufferedReader br = new BufferedReader(new FileReader("dane.txt"))) {
            String line;
            boolean any = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.printf(WHITE + "| %-14s | %-14s | %-10s | %-10s |\n" + RESET,
                            parts[0], parts[1], parts[2], parts[3]);
                    any = true;
                }
            }
            if (!any) {
                System.out.println(RED + "No data found in file." + RESET);
            }
        } catch (IOException e) {
            System.out.println(RED + "Error reading dane.txt" + RESET);
            logError("Error reading dane.txt: " + e.getMessage());
        }
        System.out.println(YELLOW + "+----------------+----------------+------------+------------+" + RESET);
    }

    /**
     * Clears the console screen (works in most CMD/terminal environments).
     */
    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // ignore
        }
    }
}

