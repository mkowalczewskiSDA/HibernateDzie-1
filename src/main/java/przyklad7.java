import dao.GenericDao;
import dao.OrderDao;
import model.Product;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad7 {
    public static void main(String[] args) {
        GenericDao<Product> genericDao = new GenericDao<>(Product.class);
        Product product = genericDao.findById(1);
        System.out.println("debug");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.merge(product);
        product.setDescription("Pyszna");
        Hibernate.initialize(product.getCategory());
        session.beginTransaction();
        session.flush();
        session.getTransaction().commit();
        System.out.println("debug");
        session.close();

    }
}
