package com.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;
import java.util.Scanner;

public class AdinCheckUser {


        public static void main(String[] args) {
            // Database connection parameters
            String jdbcURL = "jdbc:mysql://localhost:3306/miniproject"; // Change to your database URL
            String userName = "root";
            String password = "Magicworld@1";

            try {
                // Establish a database connection
                Connection connection = DriverManager.getConnection(jdbcURL, userName, password);

                // Create and execute a SQL query to retrieve the user list
                String sqlQuery = "SELECT username FROM registration";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);

                System.out.println("Admin: Registered Users List");
                System.out.println("Username");

                // Iterate through the result set and print user information
                while (resultSet.next()) {
                    String username = resultSet.getString("username");


                    System.out.println(username );
                }

                // Close resources
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
