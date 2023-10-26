    package com.user;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.Scanner;

    public class Login {
        public static void main(String[] args) {


            try {
                // Establish a database connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "Magicworld@1");

                // Create a prepared statement for login
                String loginQuery = "SELECT * FROM registration WHERE username = ? AND password = ?";
                PreparedStatement loginStatement = connection.prepareStatement(loginQuery);

                // Read user input
                Scanner scanner = new Scanner(System.in);
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();

                // Set values in the prepared statement
                loginStatement.setString(1, username);
                loginStatement.setString(2, password);

                // Execute the query to check if the user exists
                ResultSet resultSet = loginStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful!");
                    // You can add code here to navigate to the user's profile or perform other actions.
                } else {
                    System.out.println("Login failed. Invalid credentials.");
                }

                // Close resources
                loginStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }