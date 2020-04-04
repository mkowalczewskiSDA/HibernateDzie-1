//Utwórz klasę OrderDao, niech ta klasa dziedziczy po klasie GenericDao - stwórz odpowiedni kontruktor aby klasa mogła działać.
//napisz metody
// 1. findByDate()
// 2. findBeforeDate()
// 3. findAfterDate() - zastosuj NativeQuery dla odmiany
// 4. findAllContainingProduct()
// 5. findByUser()
// 6. findByPriceLowerThan()
// Zastosuj TypedQuery następnie zaprezentuj wyniki działania query w klasie main za pomocą System.out.println )

import dao.GenericDao;
import dao.OrderDao;
import model.Order;
import model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class zadanie2 {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        /*
        List<Order> orders = orderDao.findAfterDate(LocalDateTime.of(2019,2,28,15,35,05));
        orders.forEach(order -> System.out.println(order.toString()));*/
        GenericDao<Product> productDao = new GenericDao<>(Product.class);
        Product product = productDao.findById(2);
        List<Order> orders = orderDao.findAllContainingProduct(product);
        System.out.println("debug");
        orders.forEach(order -> System.out.println(order.toString()));



    }
}
