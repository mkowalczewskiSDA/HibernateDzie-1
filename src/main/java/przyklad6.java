import model.Address;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class przyklad6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> addressRoot = query.from(Address.class);
        query.select(addressRoot);

        Query<Address> q = session.createQuery(query);
        List<Address> addressList = q.getResultList();
        addressList.forEach(address -> System.out.println(address.getCity()));
        session.close();
    }
}
