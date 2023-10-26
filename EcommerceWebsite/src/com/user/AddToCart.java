package com.user;

import java.sql.*;
import java.util.Scanner;

public class AddToCart {


//    public static void main(String[] args) {
//        Map<Integer, Integer> cart = new HashMap<Integer,Integer>();
//        Map<Integer, String> products = new HashMap<>();


    public void buyproduct() {
        System.out.print("Enter the product id to buy product : ");
        Scanner scanner = new Scanner(System.in);

        int productIdToRetrieve = scanner.nextInt();

        try {
            // Connect to the database
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "Magicworld@1");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            // Create a SQL query using a prepared statement
            String sqlQuery = "SELECT * FROM product WHERE id = ?";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sqlQuery);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            preparedStatement.setInt(1, productIdToRetrieve);


            // Set the product ID as a parameter

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if the product was found
            if (resultSet.next()) {
                // Retrieve product information from the result set
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                String productDiscription = resultSet.getString("description");
                double productPrice = resultSet.getDouble("price");
                System.out.print("Enter the product quantity: ");
                int quantity = scanner.nextInt();

                System.out.print("Do you want to view cart (Yes/No): ");
                String viewCart = scanner.next().toLowerCase();
                // Add more columns as needed

                if (viewCart.equalsIgnoreCase("yes")) {
                    System.out.println("Your Cart:");
                    // Use the retrieved product information
                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Product Discription: " + productDiscription);
                    System.out.println("Product Price: " + productPrice * quantity);
                } else {

                    System.out.println("continue Shopping");
                    ViewCart viewcart=new ViewCart();
                             viewcart.view();


                }


                // Print or use other product information here
            } else {
                System.out.println("Product with ID " + productIdToRetrieve + " not found.");
            }
            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        {
AddToCart check=new AddToCart();
check.buyproduct();
            System.out.println("Do you want to continue Shopping(yes/no)");
            Scanner scanner= new Scanner(System.in);
                          String result=scanner.next().toLowerCase();
                          if(result.equalsIgnoreCase("yes"))
                          {

                              check.buyproduct();

                          }else {
                              System.out.println("hi");
                          }

        }
    }
}