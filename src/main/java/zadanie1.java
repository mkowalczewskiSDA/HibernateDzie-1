import dao.GenericDao;
import model.Address;
import model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Stworzyć prostego CRUDa (w klasie UserDAO) dla tabeli user używając hibernetowych
metod find(), persist(), merge(), delete() obiektu Session. Nasza klasa UserDAO powinna
zawierać 4 metody:
• insert -dodająca użytkownika przekazanego do metody
• select -znajdująca użytkownika na zadanym id
• update -aktualizująca użytkownika w bazie danych przekazanego do metody
• delete -usuwająca przekazanego do metody użytkownika
Dla chętnych - stworzyć klasę GenericDao - która te wszystkie operacje wykonywała by dla każdej tabeli - wykorzystując typy generyczne i parametr klasy przekazany w konstruktorze
Zadanie 2
Należy stworzyć w metodzie main() następujące operacje:
• Stworzyć listę 3 nowych użytkowników.
• Zapisać nowych użytkowników do bazy danych.
• Zmodyfikować nazwisko wszystkim użytkownikom, tak aby do nazwiska dopisać " - zakażony"
• Usunąć pierwszego i ostatniego użytkownika z listy.
 */
public class zadanie1 {
    public static void main(String[] args) {
        GenericDao<Address> addressDao = new GenericDao<>(Address.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setFirstName("Harry");
        user1.setLastName("Potter");
        user1.setPassword("buraki");
        user1.setEmail("kochamvoldemorta123@horkruks.uk");
        user1.setBirthDate(LocalDateTime.now());
        user1.setAddress(addressDao.findById(5));

        User user2 = new User();
        user2.setFirstName("Johnny");
        user2.setLastName("Bravo");
        user2.setPassword("majtki");
        user2.setEmail("miesnie@duze.com");
        user2.setBirthDate(LocalDateTime.now());
        user2.setAddress(addressDao.findById(10));

        User user3 = new User();
        user3.setFirstName("Kame");
        user3.setLastName("Hame");
        user3.setPassword("Ha");
        user3.setEmail("goku@ssj3.jp");
        user3.setBirthDate(LocalDateTime.now());
        user3.setAddress(addressDao.findById(12));

        users.add(user1);
        users.add(user2);
        users.add(user3);

        users.forEach(userDao::insertUser);
        users.forEach(user -> {
            user.setLastName(user.getLastName() + " - Zakażony");
            userDao.updateUser(user);
        });

        userDao.deleteUser(users.get(0));
        userDao.deleteUser(users.get(users.size()-1));
    }
}
