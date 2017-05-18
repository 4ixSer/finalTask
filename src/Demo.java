import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.db.DBManager;
import com.entity.car.Car;
import com.entity.car.TYPE;
import com.entity.subject.Request;
import com.entity.subject.Status;
import com.entity.users.User;

public class Demo {

    public static void main(String[] args) throws SQLException {

        // List<User> admin = new ArrayList<User>();
        // UserDAO ud = new UserDAO();

        // admin =ud.findAll();
        // for (User user : admin) {
        // System.out.println(user);
        // }

        // User user = ud.findEntityByLogin("sa");
        // System.out.println(user);

//         User user1 = new User("login1", "PAssword", "Эштон", "ештон@mail.ru");



         DBManager dbManager = DBManager.getInstance();


//         dbManager.create(user1);
//         dbManager.createCar(new Car("AS8975SB", TYPE.TANK, 12.7, 26.8, 15d,
//         true, "ПИпец машине жопа"));
        // Car c1c = new Car();
        // c1c.setId(2);
        // System.out.println(dbManager.deleteCar(c1c));

        // Request request = new Request();
        //
        // request.setCharacteristicsСak(new Car());
        // request.setNote("sdsdsds");
        // request.setOwnerRequest(user);
        // request.setStatus(Status.REJEJECTED);
        //
        //
        // dbManager.createRequest(request);
        // Calendar calendar = new Calendar();

        LocalDateTime curDateTime = LocalDateTime.now();
        LocalDateTime curDateFuche = LocalDateTime.parse("2017-05-18T10:53:15");

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
        User user = dbManager.findEntityByLogin("login1");
        System.out.println(user);
        Request request = new Request(user, curDateTime, curDateFuche, new Car("", TYPE.TANK, 12.5, 12.5, 175d, true, ""), Status.OPEN, "Коментарии к транспортному");
        dbManager.createRequest(request);

//        System.out.println("Сейчас = "+curDateTime.format(DateTimeFormatter.ofPattern("yyyy'-'MM'-'d hh:mm:ss")));

//        System.out.println("Прошлое = "+curDateFuche.format(DateTimeFormatter.ofPattern("yyyy'-'MM'-'d hh:mm:ss")));

        List<Request>  reques =dbManager.findAllRequest();

        for (Request requesst : reques) {
            System.out.println(requesst);
        }


//        Request request2= dbManager.findRequestByd(1);
//        System.out.println(request2);

//         Connection connection = ConnectorDB.getConnections("database");
//
//         Statement statement  = connection.createStatement();
//
//         ResultSet resultSet =statement.executeQuery("SELECT dataRequest FROM summarytask4.request");
//         resultSet.next();
//         System.out.println(resultSet.getString("dataRequest"));
//         System.out.println(resultSet.getTimestamp("dataRequest"));
//
//         ;


    }
}
