import model.Address;
import model.Country;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

//       criteriaQuery.select(root).where(cb.gt(root.get("itemPrice"), 1000));
//       criteriaQuery.select(root).where(cb.lt(root.get("itemPrice"), 1000));
//       criteriaQuery.select(root).where(cb.like(root.get("itemName"), "%chair%"));
//       criteriaQuery.select(root).where(cb.between(root.get("itemPrice"), 100, 200));
//       criteriaQuery.select(root).where(cb.isNull(root.get("itemDescription")));
//       criteriaQuery.select(root).where(cb.isNotNull(root.get("itemDescription")));

public class przyklad6 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> addressRoot = query.from(Address.class);
        addressRoot.fetch("country");
        query.select(addressRoot).where(builder.like(addressRoot.get("city"),"Gdańsk"));
        TypedQuery<Address> q = session.createQuery(query);
        List<Address> addressList = q.getResultList();
        session.close();
        addressList.forEach(address -> System.out.println(address.getCountry()));
    }
}
