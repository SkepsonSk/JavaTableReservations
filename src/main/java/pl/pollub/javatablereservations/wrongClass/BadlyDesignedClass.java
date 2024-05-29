package pl.pollub.javatablereservations.wrongClass;

import java.util.List;
import java.util.ArrayList;

public class BadlyDesignedClass {

    // Lista użytkowników
    List<String> userList = new ArrayList<>();

    // Konstruktor klasy
    public BadlyDesignedClass() {
        // Inicjalizacja listy
        userList.add("Adam");
        userList.add("Ewa");
        userList.add("Jan");
    }

    // Metoda dodająca użytkownika do listy
    public void dodajUzytkownika(String user, String email, String phone, String address, String city) {
        // Sprawdzenie, czy użytkownik już istnieje
        if (!userList.contains(user)) {
            userList.add(user);
        } else {
            System.out.println("Użytkownik już istnieje");
        }
    }

    // Metoda usuwająca użytkownika z listy
    public void usunUzytkownika(String user) {
        if (userList.contains(user)) {
            userList.remove(user);
        } else {
            System.out.println("Użytkownik nie istnieje");
        }
    }

    // Metoda wyszukująca użytkownika
    public boolean wyszukajUzytkownika(String user) {
        // Sprawdzenie obecności użytkownika w liście
        return userList.contains(user);
    }

    // Metoda drukująca listę użytkowników
    public void drukujUzytkownikow() {
        // Pętla po liście użytkowników
        for (String user : userList) {
            System.out.println("Użytkownik: " + user);
        }
    }

    // Metoda pobierająca szczegóły użytkownika
    public void pobierzSzczegolyUzytkownika(String user) {
        // Sprawdzenie, czy użytkownik istnieje
        if (userList.contains(user)) {
            System.out.println("Szczegóły użytkownika: " + user);
        } else {
            System.out.println("Użytkownik nie istnieje");
        }
    }

    // Metoda aktualizująca dane użytkownika
    public void aktualizujDaneUzytkownika(String user, String newEmail, String newPhone, String newAddress, String newCity) {
        if (userList.contains(user)) {
            // Aktualizacja danych (przykład)
            System.out.println("Dane użytkownika " + user + " zostały zaktualizowane.");
        } else {
            System.out.println("Użytkownik nie istnieje");
        }
    }

    // Metoda z liczbą komentarzy
    public void metodaZKomentarzami(String param1, int param2, boolean param3) {
        // Inicjalizacja zmiennych
        int wynik = 0; // Wynik operacji
        for (int i = 0; i < param2; i++) { // Pętla
            wynik += i; // Dodawanie wartości
        }
        // Sprawdzenie warunku
        if (param3) {
            wynik *= 2; // Mnożenie wyniku
        }
        System.out.println("Wynik: " + wynik); // Drukowanie wyniku
    }

    // Metoda o długiej nazwie i wielu argumentach
    public void metodaZDlugaNazwaIOgromnaIloscArgumentow(String param1, String param2, String param3, String param4, int param5, int param6, boolean param7, boolean param8, double param9, double param10) {
        // Operacje na parametrach
        if (param7 && param8) {
            System.out.println("Warunki spełnione.");
        } else {
            System.out.println("Warunki niespełnione.");
        }
    }
}


