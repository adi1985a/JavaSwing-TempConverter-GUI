# Temperature Input Application

## Overview
Temperature Input Application is a Java desktop tool using Swing for collecting and displaying user information. It prompts users for their name, surname, and temperature (°C) via dialog boxes, validates input, converts the temperature to °F, and displays the results in a formatted HTML dialog.

## Features
- **User Input**: Collects name, surname, and temperature (°C) through Swing dialogs.
- **Input Validation**: Ensures name and surname contain only letters; temperature must be a valid number.
- **Temperature Conversion**: Converts °C to °F using the formula (°C * 9/5) + 32.
- **Output Display**: Shows name, surname, temperature (°C), and converted temperature (°F) in an HTML-formatted dialog.
- **Error Handling**: Displays error messages for invalid inputs.

## Requirements
- Java 8 or higher
- Libraries: Standard Java libraries (Swing, `java.util.Scanner`)

## Setup
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```
2. Compile the application:
   ```bash
   javac Zadanie_nr_2_nr_albumu_154256.java
   ```
3. Run the application:
   ```bash
   java Zadanie_nr_2_nr_albumu_154256
   ```

## Usage
1. Launch the application to start the input process.
2. **Interface**:
   - **Name Dialog**: Enter a name (letters only).
   - **Surname Dialog**: Enter a surname (letters only).
   - **Temperature Dialog**: Enter a temperature in °C (numeric value).
   - **Result Dialog**: Displays name, surname, temperature (°C), and temperature (°F).
3. **Actions**:
   - Invalid inputs (e.g., non-letters for name, non-numeric temperature) trigger error dialogs.
   - Valid inputs result in an HTML-formatted dialog showing all data.
4. The program exits after displaying the result.

## File Structure
- `Zadanie_nr_2_nr_albumu_154256.java`: Main Java file with input, validation, conversion, and display logic.
- `README.md`: This file, providing project documentation.

## Notes
- The app uses `JOptionPane` for all user interactions, ensuring a simple GUI experience.
- Input validation uses regex (`^[a-zA-Z]+$`) for names and try-catch for numeric temperature.
- The `Scanner` object is initialized but unused; it can be removed without affecting functionality.
- HTML formatting in the result dialog enhances readability but is basic.
- No data persistence; inputs are processed and displayed in memory.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make changes and commit (`git commit -m "Add feature"`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or feedback, open an issue on GitHub or contact the repository owner.