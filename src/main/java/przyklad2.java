import model.Country;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad2 {
    public static void main(String[] args) {
        //usePersist();
        //useMerge();
        //useUpdate();
        useDelete();
    }
    //persist() zawsze tworzy nowy obiekt
//Służy do utrwalania obiektów. Jej wywołanie powoduje dołączenie przekazanego obiektu do zbioru obiektów zarządzanych oraz wywołanie INSERT
// w momencie zakończenia transakcji (albo wywołania flush). Jeżeli istnieje już encja o takim samym identyfikatorze dostaniemy wyjątek.
    public static void usePersist(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country newCountry = new Country();
        newCountry.setName("India");
        newCountry.setAlias("IN");
        System.out.println("Przed Persist");
        session.persist(newCountry);
        newCountry.setName("IndiaChanged");
        System.out.println("Po Persist");
        session.flush();
        System.out.println("Po Flush");
        session.getTransaction().commit();
        System.out.println("Po Commit");
        session.close();
    }
//merge() aktualizuje lub dodaje nowy obiekt obiektu Session
// Służy do synchronizowania stanu obiektu w kontekście utrwalania. W przeciwieństwie do poprzedniej metody encja przekazana w argumencie nie jest dołączana do
// zbioru obiektów zarządzanych. Jest ona kopiowana, kopia trafia pod zarząd EntityManagera lub Session i jest zwracana.
// W momencie zakończenia transakcji wywoływany jest INSERT albo UPDATE w zależności czy istnieje rekord o danym identyfikatorze w bazie danych.*/
// W tym miejscu warto też wspomnieć o update() - update zadziała tylko wtedy gdy do naszej sesji nie spersistowaliśmy danego obiektu, kiedy obiekt będzie załadowany dostaniemy exception
// W przypadku merge jest to bez znaczenia jednakże jest on ciut mniej wydajny - w tym miejscu po prostu trzeba odpowiedzieć sobie na pytanie, czy dany obiekt będzie znajdował się w sesji
// gdy będę chciał go modyfikować (raczej dość rzadka sytuacja)
    public static void useMerge(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country newCountry = new Country();
        newCountry.setName("Spain");
        newCountry.setAlias("ES");
        System.out.println("Before Merge");
        newCountry = (Country) session.merge(newCountry);
        newCountry.setName("SpainChanged");
        System.out.println("After Merge");
        session.flush();
        session.close();
        System.out.println("After Close");
    }

    public static void useUpdate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setId(10);
        country.setName("Japan");
        country.setAlias("JP");
        session.update(country);
        session.flush();
        session.close();
    }

    public static void useDelete(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country countryToBeDeleted = new Country();
        countryToBeDeleted.setId(89);
        session.delete(countryToBeDeleted);
        session.flush();
        session.close();
    }
}
