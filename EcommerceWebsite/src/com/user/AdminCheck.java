package com.user;

import java.sql.*;
import java.util.Scanner;

public class AdminCheck {
    public static void main(String[] args) throws SQLException {
        System.out.println("Enter the id to check quantity:");
        Scanner scanner=new Scanner(System.in);
       int quantitycheck= scanner.nextInt();

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "Magicworld@1");

        String query = "SELECT quantity FROM product WHERE id = ? ";

        PreparedStatement   preparedStatement = con.prepareStatement(query);

        preparedStatement.setInt(1,quantitycheck );
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
                       String productQuantity = resultSet.getString("Quantity");
                      System.out.println("Product Quantity: " + productQuantity);
            System.out.println();
        }
        resultSet.close();
        preparedStatement.close();
        con.close();

    }
}
