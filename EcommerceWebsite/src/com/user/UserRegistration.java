package com.user;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class UserRegistration {
  public static void main(String[] args) throws SQLException {
	        
	            // Establish a database connection
	        	
	        Connection   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "Magicworld@1");

	            // Create a prepared statement for inserting data
	            String insertQuery = "INSERT INTO registration (firstname, lastname, username, password, city,email, mob) VALUES (?, ?, ?, ?, ?, ?, ?)";        
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

	            // Read user input
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("First Name: ");
	            String firstName = scanner.next();
	            System.out.print("Last Name: ");
	            String lastName = scanner.next();
	            System.out.print("Username: ");
	            String username = scanner.next();
	            System.out.print("Password: ");
	            String password = scanner.next();

	            System.out.print("City: ");
	            String city = scanner.next();
	            System.out.print("Email: ");
	            String email = scanner.next();
	            System.out.print("Mob: ");
	            String mob = scanner.next();

	            // Set values in the prepared statement
	            try {
	            preparedStatement.setString(1, firstName);
	            preparedStatement.setString(2, lastName);
	            preparedStatement.setString(3, username);
	            preparedStatement.setString(4, password);
	            preparedStatement.setString(5, city);
	            
	            preparedStatement.setString(6, email);
	            preparedStatement.setString(7, mob);
	        
	            }catch(Exception e)
	            {
	            	System.out.println("email ios already registered");
	            }
	            // Execute the query to insert the data
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("User registered successfully!");
	            } else {
	                System.out.println("Registration failed.");
	            }

	            // Close resources
	            preparedStatement.close();
	            connection.close();
	        } 
	    
	}



