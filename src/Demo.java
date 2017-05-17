import com.dao.UserDAO;
import com.entity.users.User;

public class Demo {

    public static void main(String[] args) {

//        List<User> admin = new ArrayList<User>();
        UserDAO ud = new UserDAO();

//        admin =ud.findAll();
//        for (User user : admin) {
//            System.out.println(user);
//        }


//        User user = ud.findEntityByLogin("sa");
//        System.out.println(user);

          User user = new User("login1", "PAssword", "Ýרעמם", "ורעמם@mail.ru");

          ud.create(user);


    }

}
