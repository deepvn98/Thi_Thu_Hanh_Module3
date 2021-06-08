package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private static Connection connection;

    private ConnectionJDBC() {
    }

    private ConnectionJDBC(Connection connection) {
        this.connection = connection;
    }

    public static Connection getConnection() {
        if (connection == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/managerproduct",
                        "sangnguyen",
                        "677264"
                );
                System.out.println("yes");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}
