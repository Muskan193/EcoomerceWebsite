package com.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class userHistory {
        public static void main(String[] args) {
            // Database connection parameters
            String jdbcURL = "jdbc:mysql://localhost:3306/miniproject"; // Change to your database URL
            String username = "root";
            String password = "Magicworld@1";

            try {
                // Establish a database connection
                Connection connection = DriverManager.getConnection(jdbcURL, username, password);

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the username to view history: ");
                String enteredUsername = scanner.nextLine();

                // Create a SQL query to retrieve the user's history
                String sqlQuery = "SELECT activity, date FROM userhistory WHERE username = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                preparedStatement.setString(1, enteredUsername);

                // Execute the SQL query
                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("User History for " + enteredUsername);
                System.out.println("Activity\tDate");

                // Iterate through the result set and print user history
                while (resultSet.next()) {
                    String activity = resultSet.getString("activity");
                    String date = resultSet.getString("date");

                    System.out.println(activity + "\t" + date);
                }

                // Close resources
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


