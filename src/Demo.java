import com.db.DBManager;
import com.entity.car.Car;

public class Demo {

    public static void main(String[] args) {

//        List<User> admin = new ArrayList<User>();
//        UserDAO ud = new UserDAO();

//        admin =ud.findAll();
//        for (User user : admin) {
//            System.out.println(user);
//        }


//        User user = ud.findEntityByLogin("sa");
//        System.out.println(user);

//          User user = new User("login1", "PAssword", "Ёштон", "ештон@mail.ru");

//          ud.create(user);

        DBManager dbManager = DBManager.getInstance();
//        dbManager.createCar(new Car("AS8975SB", TYPE.TANK, 12.7, 26.8, 15d, true, "ѕ»пец машине жопа"));
     Car c1c =   new Car();
     c1c.setId(2);
       System.out.println(dbManager.deleteCar(c1c));

    }

}
