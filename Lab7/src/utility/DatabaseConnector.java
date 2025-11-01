/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.sql.*;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author darhlilove
 */
public class DatabaseConnector {

    // DB_URL = "jdbc:<database>://ip_address:port/database_name";
    static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "my-secret-pw";

    // Create a connection
    // CRUD Operations
    // CRUD Operations on Database
    // C - Create: Inserting data into the database
    public static void addUser(User user) throws SQLException {
        String query = "INSERT INTO user(firstname,lastname, age, gender, phone, continent, hobbies) VALUES (?, ?, ?, ?, ?, ?) ";
        // Create a connection
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, user.getFirstname());
        stmt.setString(2, user.getLastname());
        stmt.setInt(3, user.getAge());
        stmt.setString(4, user.getGender());
        stmt.setString(5, user.getPhone());
        stmt.setString(6, user.getContinent());
        stmt.setString(7, user.getHobbies());

        // After this query will look like:
        // "INSERT INTO patient(name, age, college, phone, continent, experience) VALUES ('Nana', 27, 'College of Engineering (COE)', '437-345-3434', 'Africa', 'Football, Dancing') "
        int rows = stmt.executeUpdate();
        System.out.println("Rows inserted: " + rows);

        // Close the connection
        conn.close();
    }

    // R - Read: Getting all the values from the database
    public static ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> users = new ArrayList();
        String query = "SELECT * FROM student";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("student_id"));
            user.setFirstname(rs.getString("first_name"));
            user.setLastname(rs.getString("Last_name"));
            user.setAge(rs.getInt("age"));
            user.setGender(rs.getString("gender"));
            user.setPhone(rs.getString("phone"));
            user.setContinent(rs.getString("continent"));
            user.setHobbies(rs.getString("hobbies"));
            users.add(user);
        }
        rs.close();
        conn.close();

        return users;
    }

    // U - Update: Changing a value in the database
    public static void updateUser(User oldUser, User updatedUser) throws SQLException {
        String query = "UPDATE student SET full_name = ?,  age = ?, college = ?, phone = ?, continent = ?, experience = ? WHERE student_id = ? ";

        // Update the query
        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1, updatedUser.getFirstname());
        stmt.setString(1, updatedUser.getLastname());
        stmt.setInt(2, updatedUser.getAge());
        stmt.setString(3, updatedUser.getGender());
        stmt.setString(4, updatedUser.getPhone());
        stmt.setString(5, updatedUser.getContinent());
        stmt.setString(6, updatedUser.getHobbies());
        stmt.setInt(7, oldUser.getId());

        int rows = stmt.executeUpdate();

        System.out.println("Rows updated: " + rows);
        conn.close();

    }

    // D - Delete 
    public static void deleteUser(User user) throws SQLException {
        String query = "DELETE FROM student WHERE student_id = ?";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, user.getId());

        int rows = stmt.executeUpdate();

        System.out.println("Rows deleted: " + rows);
        conn.close();

    }
}
