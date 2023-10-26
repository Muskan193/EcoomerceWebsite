package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;


public class ViewCart {


    public void view() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/miniproject";
        String dbUser = "root";
        String dbPassword = "Magicworld@1";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);


            String sortingColumn = "id";
            String sortingOrder = "ASC";


            String sqlQuery = "SELECT * FROM product ORDER BY " + sortingColumn + " " + sortingOrder;
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                String productDiscription = resultSet.getString("description");
//                        String productQuantity = resultSet.getString("Quantity");
                double price = resultSet.getDouble("price");


                System.out.println("Product ID: " + id);
                System.out.println("Product Name: " + productName);
                System.out.println("Product Discription: " + productDiscription);
//                        System.out.println("Product Quantity: " + productQuantity);
                System.out.println("Price: " + price);

                System.out.println();
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ViewCart viewcart = new ViewCart();
                              viewcart.view();


    }
}



