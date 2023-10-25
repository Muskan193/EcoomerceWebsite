package com.admin;	
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
	        private static final String ADMIN_USERNAME = "admin";
	        private static final String ADMIN_PASSWORD = "password123";
	        
	        public void login()
	        {
	        	   Scanner scanner = new Scanner(System.in);



	  	         //Enter username and password
	  	            System.out.print("Enter admin username: ");
	  	            String username = scanner.nextLine();

	  	            System.out.print("Enter admin password: ");
	  	            String password = scanner.nextLine();

	  	            // Check if the provided credentials match the Admin credentials
	  	            if (isAdmin(username, password)) {
	  	                System.out.println("Admin login successful.");

	  	            } else {
	  	                System.out.println("Invalid admin credentials. Access denied.");
	  	            }

	  	            scanner.close();
	  	        }

	  	        private static boolean isAdmin(String username, String password) {
	  	          
	  	            return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
	  	        }

	        

	        public static void main(String[] args) throws SQLException {
	        	AdminLogin adminlogin=new AdminLogin();
	        	adminlogin.login();
	        }}

