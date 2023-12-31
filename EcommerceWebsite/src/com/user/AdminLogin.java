package com.user;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {

        private static final String ADMIN_USERNAME = "admin";
        private static final String ADMIN_PASSWORD = "password123";

        public static void main(String[] args) throws SQLException {
            Scanner scanner = new Scanner(System.in);



            // Ask for admin username and password
            System.out.print("Enter admin username: ");
            String username = scanner.nextLine();

            System.out.print("Enter admin password: ");
            String password = scanner.nextLine();

            // Check if the provided credentials match the admin credentials
            if (isAdmin(username, password)) {
                System.out.println("Admin login successful.");

            } else {
                System.out.println("Invalid admin credentials. Access denied.");
            }

            scanner.close();
        }

        private static boolean isAdmin(String username, String password) {
            // In a real application, you'd typically check admin credentials against a database.
            // Here, we're using hard-coded values for demonstration purposes.
            return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
        }

    }
