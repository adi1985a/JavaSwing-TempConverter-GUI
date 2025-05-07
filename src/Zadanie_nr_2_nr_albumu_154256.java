import java.util.Scanner;
import javax.swing.JOptionPane;

public class Zadanie_nr_2_nr_albumu_154256
{

    public static void main(String[] args) 
    {
        Scanner wejscie = new Scanner(System.in);
        pobierzDane(wejscie);
        wejscie.close();
    }

    private static void pobierzDane(Scanner wejscie) 
    {
        String imie;
        String nazwisko;
        float temperatura;

        imie = pobierzImie();
        nazwisko = pobierzNazwisko();

        // Walidacja temp :
        while (true) 
        {
            try 
            {
                String tempStr = JOptionPane.showInputDialog(null, "Podaj temperature w st.Celcjusza:");
                temperatura = Float.parseFloat(tempStr);
                break;
            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Blad! Wprowadz poprawna liczbe.", "Blad", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Wywolanie funkcji wyswietl, z przeliczeniem na stopnie F:
        wyswietl(imie, nazwisko, temperatura, naFahrenheita(temperatura));
    }

    private static String pobierzImie() 
    {
        String imie;
        while (true) 
        {
            imie = JOptionPane.showInputDialog(null, "Podaj imie:");
            if (imie != null && imie.matches("^[a-zA-Z]+$")) 
            {
                break;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Blad! Wprowadz poprawne imie.", "Blad", JOptionPane.ERROR_MESSAGE);
            }
        }
        return imie;
    }

    private static String pobierzNazwisko() 
    {
        String nazwisko;
        while (true) 
        {
            nazwisko = JOptionPane.showInputDialog(null, "Podaj nazwisko:");
            if (nazwisko != null && nazwisko.matches("^[a-zA-Z]+$")) 
            {
                break;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Blad! Wprowadz poprawne nazwisko.", "Blad", JOptionPane.ERROR_MESSAGE);
            }
        }

        return nazwisko;
    }

    private static void wyswietl(String imie, String nazwisko, float temperatura, float tempF) 
    {
        // Tworzenie ciagu znakow do wyswiet. z HTML:
        String wynik = "<html><body>" +
                "<p>Twoje imie i nazwisko: " + imie + " " + nazwisko + "</p>" +
                "<p>Twoja temperatura to: " + temperatura + " °C </p>" +
                "<p>W stopniach Fahrenheita to: " + tempF + " °F</p>" +
                "</body></html>";

        // Wyswietlenie wyniku w oknie dialogu:
        JOptionPane.showMessageDialog(null, wynik, "Wynik", JOptionPane.INFORMATION_MESSAGE);
    }

    private static float naFahrenheita(float temperaturaCelsjusza) 
    {
        // Obliczenie temp. w st.Fahrenheita:
        return ((temperaturaCelsjusza * 9F) / 5F) + 32F;
    }
}
