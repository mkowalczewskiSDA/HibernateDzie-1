import dao.UserDao;
import model.User;

import java.util.List;

public class przyklad8 {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.findById(1);
        List<User> users = userDao.findByUser(user);
        System.out.println("test");
        users.forEach(user1 -> System.out.println(user.toString()));
    }
}
