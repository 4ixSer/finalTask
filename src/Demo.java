import java.sql.SQLException;
import java.util.List;

import com.dao.CarDAO;
import com.entity.car.Car;
import com.entity.car.TYPE;

public class Demo {

    public static void main(String[] args) throws SQLException {

//        UserDAO userDAO = new UserDAO();
//        User user =null;

//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти всех юзеров");
//        List<User> users =userDAO.findAll();

//        for (User user1 : users) {
//            System.out.println(user1);
//        }
//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти юзера с ID = 1");

//        user = userDAO.findEntityById(1);
//        System.out.println(user);

//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Создать нового юзера ");

//        User newUser = new User("NewLogin", "пароль", "Гриша", null);

//        System.out.println("Статус запис " + userDAO.create(newUser));
//        user = userDAO.findEntityById(2);

//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Удаление нового юзера ");

//        System.out.println("Статус Удаления " +  userDAO.delete(user));

//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти юзера с login = admin");
//        user = userDAO.findEntityByLogin("admin");
//        System.out.println(user);


//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Обновление юзера с id = 2");
//        user = userDAO.findEntityByLogin("NewLogin");
//        System.out.println(user);
//        System.out.println("Изминение email");
//        user.setEmail("новый Email");
//        user = userDAO.update(user);
//        System.out.println(userDAO.findEntityByLogin("NewLogin"));

//        userDAO.close();

        Car car  = null;
        CarDAO carDAO = new CarDAO();

//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Создать машину");
//
//        car = new Car("SD7856VS", TYPE.CONTAINER, 23.1, 123.2, 1d, true, null);
//        carDAO.create(car);
//
//        car = new Car("AD7856SE", TYPE.BOARD, 3.1, 23.2, 1d, true, ",барахлит руль");
//        carDAO.create(car);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Найти всех машин");

        List<Car> cars = carDAO.findAll();
        for (Car car2 : cars) {
            System.out.println(car2);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Найти машину по Id");

        car =carDAO.findEntityById(1);
        System.out.println(car);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Найти машину по namber");

        car =carDAO.findEntityByNamber("AD7856SE");
        System.out.println(car);
        System.out.println("Изменяем мошьность");
        car.setDefective(false);
        System.out.println(carDAO.update(car));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Удалить машину по namber");
        System.out.println(carDAO.delete(car));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Создать машину");

        car = new Car("AD7856SE", TYPE.BOARD, 3.1, 23.2, 1d, true, ",барахлит руль");
        carDAO.create(car);




/ыфывф
//        LocalDateTime curDateTime = LocalDateTime.now();
//        LocalDateTime curDateFuche = LocalDateTime.parse("2017-05-18T10:53:15");

//         LocalDateTime curDateTime =
//                 LocalDateTime.parse("2017-05-18 10:53:15" ,
//                 DateTimeFormatter.ofPattern( "yyyy'-'MM'-'d hh:mm:ss"));
//
//                 System . out . println ( curDateTime.format(
//                 DateTimeFormatter.ofPattern("yyyy'-'MM'-'d hh:mm:ss")));

//         String now = "2017-05-18 10:53:15.0";
//
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n");
//
//         LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);
//
//         System.out.println("Before : " + now);
//
//         System.out.println("After : " + formatDateTime);

//         System.out.println("After : " + formatDateTime.format(formatter));
//
//        User user = dbManager.findEntityByLogin("login1");
//        User user2 = dbManager.findEntityById(11);
//         System.out.println(user);
//         System.out.println(user2);
//        Request request = new Request(user, curDateTime, curDateFuche, new Car("", TYPE.TANK, 12.5, 12.5, 175d, true, ""), Status.OPEN, "Коментарии к транспортному");
//        dbManager.createRequest(request);

//        System.out.println("Сейчас = "+curDateTime.format(DateTimeFormatter.ofPattern("yyyy'-'MM'-'d hh:mm:ss")));

//        System.out.println("Прошлое = "+curDateFuche.format(DateTimeFormatter.ofPattern("yyyy'-'MM'-'d hh:mm:ss")));

//        List<Request>  reques =dbManager.findAllRequest();
//
//        for (Request requesst : reques) {
//            System.out.println(requesst);
//        }




    }
}
