package gb.server;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:userTestDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String login, String pass, String nick) {
        String sql = String.format("INSERT INTO userTable (login, password, nickname) " +
                "VALUES ('%s', '%s', '%s')", login, pass.hashCode(), nick);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String getNickByLoginAndPass(String login, String pass) {

        String sql = String.format("select nickname, password FROM userTable where" +
                " login = '%s'", login);
        try {
            int myHash = pass.hashCode();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if(myHash == dbHash) {
                    return nick;
                }
                // / return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
