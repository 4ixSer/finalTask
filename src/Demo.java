import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws SQLException {

//        UserDAO userDAO = new UserDAO();
//        User user =null;
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти всех юзеров");
//        List<User> users =userDAO.findAll();
//
//        for (User user1 : users) {
//            System.out.println(user1);
//        }
//        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти юзера с ID = 1");
//
//        user = userDAO.findEntityById(1);
//        System.out.println(user);
//
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

//          Car car  = null;
//          CarDAO carDAO = new CarDAO();

//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Создать машину");
//
//        car = new Car("SD7856VS", TYPE.CONTAINER, 23.1, 123.2, 1d, true, null);
//        carDAO.create(car);
//
//        car = new Car("AD7856SE", TYPE.BOARD, 3.1, 23.2, 1d, true, ",барахлит руль");
//        carDAO.create(car);

//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти всех машин");
//
//        List<Car> cars = carDAO.findAll();
//        for (Car car2 : cars) {
//            System.out.println(car2);
//        }
//
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Найти машину по Id");
//
//          car =carDAO.findEntityById(1);
//          System.out.println(car);

//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Найти машину по namber");
//
//        car =carDAO.findEntityByNamber("AD7856SE");
//        System.out.println(car);
//        System.out.println("Изменяем мошьность");
//        car.setDefective(false);
//        System.out.println(carDAO.update(car));
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Удалить машину по namber");
//        System.out.println(carDAO.delete(car));
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        System.out.println("Создать машину");
//
//        car = new Car("AD7856SE", TYPE.BOARD, 3.1, 23.2, 1d, true, ",барахлит руль");
//        carDAO.create(car);
//      ==================================================================================


//      ==================================================================================
//          тестирование класса Рейса
//
//
//          UserDAO userDAO = new UserDAO();
//          User user =null;
//
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Найти всех юзеров");
//          List<User> users =userDAO.findAll();
//
//          for (User user1 : users) {
//              System.out.println(user1);
//          }
//
//          Car car  = null;
//          CarDAO carDAO = new CarDAO();
//
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Найти машину по Id");
//
//          car =carDAO.findEntityById(1);
//          System.out.println(car);
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("СОздать реййс");
//          LocalDateTime curDateTime = LocalDateTime.now();
//          Flight flight = new Flight(curDateTime, Status.PROCESSED, users.get(0), users.get(1), car, "Очень сложный маршрут");
//
//
//          FlightDAO flightDAO = new FlightDAO();
//
//          System.out.println("статус записи " + flightDAO.create(flight));
//
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Получить список всех рейсов");
//          List<Flight> flights = flightDAO.findAll();
//
//          for (Flight flight2 : flights) {
//            System.out.println(flight2);
//          }
//
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Получить рейсов по номеру");
//
//          flight=flightDAO.findEntityById(2);
//          System.out.println(flight);
//
//
//          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//          System.out.println("Обновил рейс по номеру");
//          flight.setNote("sdsads");
//          flight.setStatus(Status.CLOSED);
//
//
//          System.out.println(flightDAO.update(flight));
//      ==================================================================================

//      ==================================================================================
        //тестирование класса запрос
//      RequestDAO requestDAO= new RequestDAO();
//
//      LocalDateTime curDateTime = LocalDateTime.now();
//      LocalDateTime curDateFuche = LocalDateTime.parse("2017-05-18T10:53:15");
//
//      System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//      System.out.println("СОздать Заявку");
//
//      UserDAO userDAO = new UserDAO();
//      User user =userDAO.findEntityByLogin("NewLogin");
//      Car charCAr =new Car(null, TYPE.AVTOVOSCH, 15.5, 123.0, 0.1, true, null);
//      Request request = new Request(user, curDateTime, curDateFuche, charCAr, Status.REJEJECTED, "");
//      System.out.println("Статус создания: " + requestDAO.create(request));
//
//
//      System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//      System.out.println("Поиск всех заявок Заявку");
//
//      List<Request> requests = requestDAO.findAll();
//      for (Request request2 : requests) {
//        System.out.println(request2);
//      }
//
//
//      System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//      System.out.println("обновить Заявку");
//      System.out.println("изминениие парметров ");
//
//      requests.get(1).setStatus(Status.CANCELED);
//      System.out.println(requestDAO.update(requests.get(1)));
//
//      System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//      System.out.println("удалить Заявку");
//      System.out.println("изминениие парметров ");
//      System.out.print(requestDAO.delete(requests.get(1)));
//
//
//      System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//      System.out.println("НАйти по номеру Заявку id =1");
//      System.out.println("изминениие парметров ");
//      System.out.print(requestDAO.findEntityById(1));
//      ==================================================================================


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
