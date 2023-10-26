//package com.user;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class MultipleProductBuy {
//
//
//    class Product {
//        private int id;
//        private String name;
//        private double price;
//
//        public Product(int id, String name, double price) {
//            this.id = id;
//            this.name = name;
//            this.price = price;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public double getPrice() {
//            return price;
//        }
//    }
//
//    class ShoppingCart {
//        private List<Product> items = new ArrayList<>();
//
//        public void addItem(Product product) {
//            items.add(product);
//        }
//
//        public void removeItem(int productId) {
//            items.removeIf(product -> product.getId() == productId);
//        }
//
//        public List<Product> getItems() {
//            return items;
//        }
//
//        public double calculateTotal() {
//            double total = 0;
//            for (Product product : items) {
//                total += product.getPrice();
//            }
//            return total;
//        }
//    }
//
//    public class OnlineStore {
//        public static void main(String[] args) {
//            String jdbcUrl = "jdbc:mysql://localhost:3306/miniproject";
//            String dbUser = "your_username";
//            String dbPassword = "your_password";
//
//            List<Product> availableProducts = new ArrayList<>();
//         //   ShoppingCart cart = new ShoppingCart();
//
//            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
//                String sqlQuery = "SELECT id, name, price FROM products";
//                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("id");
//                    String name = resultSet.getString("name");
//                    double price = resultSet.getDouble("price");
//                 //   availableProducts.add(new Product(id, name, price));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return;
//            }
//
//            Scanner scanner = new Scanner(System.in);
//
//            while (true) {
//                System.out.println("Available Products:");
//                for (Product product : availableProducts) {
//                    System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
//                }
//
//                System.out.print("Enter the ID of the product to add (0 to checkout): ");
//                int productId = scanner.nextInt();
//
//                if (productId == 0) {
//                    break; // User wants to checkout
//                }
//
//                Product selectedProduct = availableProducts.stream()
//                        .filter(product -> product.getId() == productId)
//                        .findFirst()
//                        .orElse(null);
//
//                if (selectedProduct != null) {
//                    //cart.addItem(selectedProduct);
//                    System.out.println(selectedProduct.getName() + " added to the cart.");
//                } else {
//                    System.out.println("Invalid product ID. Please try again.");
//                }
//            }
//
//            System.out.println("Items in Your Cart:");
//         //   for (Product product : cart.getItems()) {
//                System.out.println(product.getName() + " - $" + product.getPrice());
//            }
//
//            System.out.println("Total: $" + cart.calculateTotal());
//        }
//    }
//
//    {
//    }
//}
