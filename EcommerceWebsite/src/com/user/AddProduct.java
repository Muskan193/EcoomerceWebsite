package com.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProduct {
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
            proceedToAdminPanel();
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

    private static void proceedToAdminPanel() throws SQLException {
       
 

  
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "Magicworld@1");

        // Create a prepared statement for adding products
        String insertProductQuery = "INSERT INTO product (id,name, description, quantity, price) VALUES (?,?, ?, ?, ?)";
        PreparedStatement insertProductStatement = connection.prepareStatement(insertProductQuery);

        // Read product information from the admin
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Product Name: ");
        String productName = scanner.next();
        System.out.print("Product Description: ");
        String description = scanner.next();
        System.out.print("Available quantity: ");
        String quantity = scanner.next();
        System.out.print("Price: ");
        int price = scanner.nextInt();
      
        try {
        // Set values in the prepared statement
        	 insertProductStatement.setInt(1, productId);
        insertProductStatement.setString(2, productName);
        insertProductStatement.setString(3, description);
        insertProductStatement.setString(4, quantity);
        insertProductStatement.setInt(5, price);
        }catch(Exception e)
        {
        	System.out.println("product is already registered");
        }
        // Execute the query to add the product to the database
        int rowsAffected = insertProductStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Product addition failed.");
        }

        // Close resources
        insertProductStatement.close();
        connection.close();
    }



    }


