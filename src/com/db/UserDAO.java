package com.db;

public class UserDAO {

//    protected WrapperConnector connector;
//
//    private static final Integer ADMIN = 1;
//    private static final Integer DISPATCHER = 2;
//    private static final Integer DRIVER = 3;
//    private static final String SQL_SELECT_All_USER = "SELECT * FROM user";
//    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM user WHERE id=?";
//    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
//    public UserDAO() {
//        connector = new WrapperConnector();
//    }
//
//    public List<User> findAll() {
//        List<User> users = new ArrayList<User>();
//        Statement st = null;
//        try {
//            st = connector.getStatement();
//            ResultSet resultSet = st.executeQuery(SQL_SELECT_All_USER);
//
//            while (resultSet.next()) {
//                // TODO вытягивать правильных людей
//
//                User user = null;
//                Integer role = resultSet.getInt("role");
//                if (role == ADMIN)
//                    user = new Admin();
//                else if (role == DISPATCHER)
//                    user = new Dispatcher();
//                else
//                    user = new Driver();
//
//                user.setId(resultSet.getInt("id"));
//                user.setLogin(resultSet.getString("login"));
//                user.setPassword(resultSet.getString("password"));
//                user.setEmail(resultSet.getString("email"));
//                user.setName(resultSet.getString("name"));
//                users.add(user);
//
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Error createStatement: " + e);
//        } finally {
//            connector.closeStatement(st);
//            connector.closeConnection();
//        }
//
//        return users;
//    }
//
//
//    public User findEntityById(int id) {
//
//        User user = null;
//        Statement st = null;
//        try {
//            st = connector.getStatement();
//            ResultSet resultSet = st.executeQuery(SQL_SELECT_USER_BY_ID);
//            Integer role = resultSet.getInt("role");
//            if (role == ADMIN)
//                user = new Admin();
//            else if (role == DISPATCHER)
//                user = new Dispatcher();
//            else
//                user = new Driver();
//
//            user.setId(resultSet.getInt("id"));
//            user.setLogin(resultSet.getString("login"));
//            user.setPassword(resultSet.getString("password"));
//            user.setEmail(resultSet.getString("email"));
//            user.setName(resultSet.getString("name"));
//
//        } catch (SQLException e) {
//            System.err.println("Error createStatement: " + e);
//        } finally {
//            connector.closeStatement(st);
//            connector.closeConnection();
//        }
//        return user;
//
//    }
//
//    //TODO это передалать бред пока он только для тестировки
//    public User findEntityByLogin(String login) {
//
//        User user = null;
//        Connection con = null;
//        PreparedStatement ps = null;
//        try {
//
//            con = ConnectorDB.getConnections("database");
//            ps = con.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
//            ps.setString(1, login);
//            ResultSet resultSet = ps.executeQuery();
//            resultSet.next();
//            Integer role = resultSet.getInt("role");
//            if (role == ADMIN)
//                user = new Admin();
//            else if (role == DISPATCHER)
//                user = new Dispatcher();
//            else
//                user = new Driver();
//
//            user.setId(resultSet.getInt("id"));
//            user.setLogin(resultSet.getString("login"));
//            user.setPassword(resultSet.getString("password"));
//            user.setEmail(resultSet.getString("email"));
//            user.setName(resultSet.getString("name"));
//
//        } catch (SQLException e) {
//            System.err.println("Error createStatement: " + e);
//        } finally {
//            try {
//                ps.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return user;
//
//    }
//
//
//    public boolean delete(int id) {
//
//        return false;
//    }
//
//
//    public boolean delete(User entity) {
//
//        return false;
//    }
//
//    //TODO это передалать бред пока он только для тестировки
//    public boolean create(User entity) {
//
//
//        String SQL_INSERT_USER = "INSERT INTO user (login, password, name, email, role) VALUES (?, ?, ?, ?, ?)";
//
//
//        PreparedStatement ps = null;
//        Connection con = null;
//        try {
//
//            con = ConnectorDB.getConnections("database");
//            ps = con.prepareStatement(SQL_INSERT_USER);
//            ps.setString(1, entity.getLogin());
//            ps.setString(2, entity.getPassword());
//            ps.setString(3, entity.getName());
//            ps.setString(4, entity.getEmail());
//            ps.setInt(5, 2);
//            ps.execute();
//            ps.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ps.close();
//
//            } catch (SQLException e) {
//                System.err.println("SQL exception (request or table failed): " + e);
//            }
//        }
//        return false;
//    }
//
//
//    public User update(User entity) {
//
//        return null;
//    }

}
