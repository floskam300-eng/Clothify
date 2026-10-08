package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:sqlite:Clothify.db";

    private DBConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
            initializeDatabase(connection);
        } catch (Exception e) {
            System.err.println("Database connection failed. " + e.getMessage());
            throw new SQLException("Database connection failed", e);
        }
    }

    private void initializeDatabase(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON;");

            stmt.execute("CREATE TABLE IF NOT EXISTS Admin (" +
                    "adminId TEXT PRIMARY KEY, " +
                    "username TEXT NOT NULL, " +
                    "password TEXT NOT NULL, " +
                    "phoneNumber TEXT" +
                    ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS Staff (" +
                    "staffId TEXT PRIMARY KEY, " +
                    "username TEXT NOT NULL, " +
                    "password TEXT NOT NULL, " +
                    "fullName TEXT, " +
                    "address TEXT, " +
                    "phoneNumber TEXT, " +
                    "nic TEXT, " +
                    "dob TEXT, " +
                    "salary REAL" +
                    ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS Supplier (" +
                    "supplierId TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "company TEXT, " +
                    "email TEXT, " +
                    "phoneNumber TEXT" +
                    ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS Product (" +
                    "productId TEXT PRIMARY KEY, " +
                    "name TEXT, " +
                    "category TEXT, " +
                    "size TEXT, " +
                    "unitPrice REAL, " +
                    "qtyOnHand INTEGER" +
                    ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS SupplyProduct (" +
                    "supplyId TEXT, " +
                    "productId TEXT, " +
                    "supplierId TEXT, " +
                    "unitCost REAL, " +
                    "qty INTEGER, " +
                    "total REAL, " +
                    "dateAndTime TEXT, " +
                    "PRIMARY KEY (supplyId, productId, supplierId), " +
                    "FOREIGN KEY (productId) REFERENCES Product(productId), " +
                    "FOREIGN KEY (supplierId) REFERENCES Supplier(supplierId)" +
                    ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS Orders (" +
                    "orderId TEXT PRIMARY KEY, " +
                    "netTotal REAL, " +
                    "totalDiscount REAL, " +
                    "orderDateAndTime TEXT, " +
                    "staffId TEXT, " +
                    "customerEmail TEXT, " +
                    "customerPhoneNumber TEXT, " +
                    "FOREIGN KEY (staffId) REFERENCES Staff(staffId) ON DELETE SET NULL" +
                    ");");

            stmt.execute("CREATE TABLE IF NOT EXISTS OrderDetail (" +
                    "orderId TEXT, " +
                    "productId TEXT, " +
                    "unitPrice REAL, " +
                    "qty INTEGER, " +
                    "discount REAL, " +
                    "total REAL, " +
                    "PRIMARY KEY (orderId, productId), " +
                    "FOREIGN KEY (orderId) REFERENCES Orders(orderId), " +
                    "FOREIGN KEY (productId) REFERENCES Product(productId)" +
                    ");");

            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Admin");
            if (rs.next() && rs.getInt(1) == 0) {
                stmt.execute("INSERT INTO Admin (adminId, username, password, phoneNumber) VALUES ('A001', 'admin', 'admin123', '0771234567')");
                System.out.println("Default admin user created: admin / admin123");
            }
        } catch (SQLException e) {
            System.err.println("Error initializing SQLite database tables: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static synchronized DBConnection getInstance() throws SQLException {
        return instance == null ? instance = new DBConnection() : instance;
    }
}
