# 🌡️👤 JavaSwing TempConverter & User Info GUI ☕
_A Java desktop application using Swing for collecting user name, surname, and temperature (°C), validating input, converting temperature to °F, and displaying results in an HTML-formatted dialog._

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-%3E%3D8-007396.svg?logo=java&logoColor=white)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/UI-Java%20Swing-orange.svg)]() <!-- Generic Swing badge -->

## 📋 Table of Contents
1.  [Overview](#-overview)
2.  [Key Features](#-key-features)
3.  [Screenshots (Conceptual)](#-screenshots-conceptual)
4.  [System Requirements](#-system-requirements)
5.  [Installation and Setup](#️-installation-and-setup)
6.  [Usage Guide](#️-usage-guide)
7.  [File Structure](#-file-structure)
8.  [Technical Notes](#-technical-notes)
9.  [Contributing](#-contributing)
10. [License](#-license)
11. [Contact](#-contact)

## 📄 Overview

The **JavaSwing TempConverter & User Info GUI** (from file `Zadanie_nr_2_nr_albumu_154256.java`), developed by Adrian Lesniak, is a simple desktop application built using Java's Swing toolkit. Its primary purpose is to collect personal information (name, surname) and a temperature reading in Celsius (°C) from the user via a series of input dialog boxes. The application performs validation on these inputs: names and surnames must contain only letters, and the temperature must be a valid number. Upon successful validation, it converts the Celsius temperature to Fahrenheit (°F) and then displays all the collected and calculated information in a neatly formatted HTML dialog message.

<br><br>
<p align="center">
  <img src="screenshots/1.gif" width="85%">
</p>

## ✨ Key Features

*   👤 **User Data Input**:
    *   Collects First Name, Surname, and Temperature in Celsius (°C) using Swing's `JOptionPane.showInputDialog`.
*   ✔️ **Input Validation**:
    *   **Name/Surname**: Ensures that these fields contain only alphabetical characters (using a regular expression `^[a-zA-Z]+$`).
    *   **Temperature**: Validates that the input for temperature can be successfully parsed as a number (double).
    *   Displays error messages via `JOptionPane.showMessageDialog` if validation fails.
*   🌡️ **Temperature Conversion**:
    *   Converts the input Celsius temperature to Fahrenheit using the standard formula: `°F = (°C × 9/5) + 32`.
*   📊 **Formatted Output Display**:
    *   Presents the user's full name, the original temperature in Celsius, and the converted temperature in Fahrenheit.
    *   This summary is displayed within a `JOptionPane.showMessageDialog` that renders basic HTML for enhanced readability (e.g., using `<html>`, `<b>`, `<br>`).
*   💬 **Interactive Dialogs**: All user interaction (input and output) is handled through Swing's `JOptionPane` dialog boxes, providing a simple graphical user interface (GUI) experience.

## 🖼️ Screenshots (Conceptual)

_Screenshots of: the sequence of input dialogs (for name, surname, temperature), an example of an error message dialog for invalid input, and the final HTML-formatted results dialog._

<p align="center">
  <img src="screenshots\1.jpg" width="300"/>
  <img src="screenshots\2.jpg" width="300"/>
  <img src="screenshots\3.jpg" width="300"/>
  <img src="screenshots\4.jpg" width="300"/>
  <img src="screenshots\5.jpg" width="300"/>
  <img src="screenshots\6.jpg" width="300"/>
  <img src="screenshots\7.jpg" width="300"/>
  <img src="screenshots\8.jpg" width="300"/>
  <img src="screenshots\9.jpg" width="300"/>
  <img src="screenshots\10.jpg" width="300"/>
</p>

## ⚙️ System Requirements

*   **Java Development Kit (JDK)**: Java 8 or higher (for compilation and running).
*   **Java Runtime Environment (JRE)**: Required to run the compiled application if distributed as a JAR.
*   **Standard Java Libraries**:
    *   `javax.swing.JOptionPane` (for GUI dialogs)
    *   `java.util.Scanner` (noted as initialized but unused in the description, could be removed)
    *   Core Java libraries for string manipulation, number parsing, etc.
*   **Operating System**: Any OS that supports Java and Swing (e.g., Windows, macOS, Linux).

## 🛠️ Installation and Setup

1.  **Clone or Download the Source Code**:
    ```bash
    git clone <repository-url>
    cd <repository-directory>
    ```
    *(Replace `<repository-url>` and `<repository-directory>` if applicable, or simply download/save `Zadanie_nr_2_nr_albumu_154256.java`)*

2.  **Ensure Java Development Kit (JDK) is Installed**:
    Verify you have JDK 8 or higher installed and configured in your system's PATH. You can check with `java -version` and `javac -version`.

3.  **Compile the Java Application**:
    Open a terminal or command prompt, navigate to the directory where you saved `Zadanie_nr_2_nr_albumu_154256.java`, and compile it:
    ```bash
    javac Zadanie_nr_2_nr_albumu_154256.java
    ```
    This will produce a `Zadanie_nr_2_nr_albumu_154256.class` file.

4.  **Run the Java Application**:
    From the same directory, run the compiled class file:
    ```bash
    java Zadanie_nr_2_nr_albumu_154256
    ```

## 💡 Usage Guide

1.  Compile and run the application `Zadanie_nr_2_nr_albumu_154256` as detailed in the "Installation and Setup" section.
2.  **Input Sequence (via Dialog Boxes)**:
    *   **Name Dialog**: A dialog box will appear prompting you to "Enter your name:". Type your first name (letters only) and click "OK".
    *   **Surname Dialog**: Another dialog will appear prompting "Enter your surname:". Type your surname (letters only) and click "OK".
    *   **Temperature Dialog**: A dialog will appear prompting "Enter temperature in Celsius (°C):". Type a numeric value for the temperature and click "OK".
3.  **Error Handling**:
    *   If you enter non-alphabetic characters for the name or surname, an error dialog will appear (e.g., "Invalid input. Please enter letters only for name/surname.") and you will be re-prompted for that specific input.
    *   If you enter non-numeric input for the temperature, an error dialog (e.g., "Invalid input. Please enter a valid number for temperature.") will appear, and you will be re-prompted for the temperature.
4.  **Output (Result Dialog)**:
    *   Upon successful entry of all valid inputs, a final dialog box will appear.
    *   This dialog will display the collected and converted information in an HTML-formatted message, for example:
        ```html
        <html>
        Name: John<br>
        Surname: Doe<br>
        Temperature in Celsius: 25.0 °C<br>
        Temperature in Fahrenheit: 77.0 °F
        </html>
        ```
5.  **Program Termination**:
    *   After you click "OK" on the result dialog, the program will typically exit.

## 🗂️ File Structure

*   `Zadanie_nr_2_nr_albumu_154256.java`: The single Java source file containing all the program logic, including input collection, validation, temperature conversion, and display using `JOptionPane`.
*   `README.md`: This documentation file.

*(No external data files, log files, or separate class files are indicated for this specific program as described beyond the main `.java` file.)*

## 📝 Technical Notes

*   **GUI with `JOptionPane`**: The entire user interface is built using `javax.swing.JOptionPane` static methods. This provides a very simple, modal dialog-based GUI, suitable for basic input/output tasks without the complexity of full Swing frame/panel layouts.
*   **Input Validation**:
    *   Name/Surname validation uses a regular expression (`^[a-zA-Z]+$`) to check for alphabetic characters only.
    *   Temperature validation uses a `try-catch` block around `Double.parseDouble()` to handle potential `NumberFormatException`.
*   **Unused `Scanner`**: The description notes that a `Scanner` object is initialized but unused. This can be safely removed from the code to avoid confusion or unnecessary object creation.
*   **HTML in Dialogs**: `JOptionPane` can render basic HTML if the message string starts with `<html>`. This is used to format the final results display with line breaks and bold text.
*   **No Data Persistence**: The application processes inputs and displays results in memory for a single run. No data is saved to files or a database.
*   **Single-File Structure**: All logic appears to be contained within the single `Zadanie_nr_2_nr_albumu_154256.java` file.

## 🤝 Contributing

Contributions to this **JavaSwing TempConverter & User Info GUI** are welcome, especially if they aim to:

*   Enhance the GUI beyond basic `JOptionPane` (e.g., using `JFrame`, `JPanel`, `JTextField` for a more integrated form).
*   Add more robust input validation (e.g., for realistic temperature ranges).
*   Implement features like saving data to a file or a simple history log.
*   Provide localization for prompts and messages.
*   Improve the HTML formatting of the output dialog.

1.  Fork the repository.
2.  Create a new branch for your feature (`git checkout -b feature/EnhancedGUI`).
3.  Make your changes to the Java source file(s).
4.  Commit your changes (`git commit -m 'Feature: Implement JFrame for input'`).
5.  Push to the branch (`git push origin feature/EnhancedGUI`).
6.  Open a Pull Request.

Please ensure your code is well-commented and adheres to good Java practices.

## 📃 License

This project is licensed under the **MIT License**.
(If you have a `LICENSE` file in your repository, refer to it: `See the LICENSE file for details.`)

## 📧 Contact

Application concept by **Adrian Lesniak**.
For questions or feedback, please open an issue on the GitHub repository or contact the repository owner.

---
☀️ _A simple Java Swing tool for quick temperature conversions and user info display!_
