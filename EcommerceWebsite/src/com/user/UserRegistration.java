package com.user;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {
        Connection con=null;
        PreparedStatement pstmt=null;

        public void registration() throws SQLException {
                try {
                        ConnectionTest connection = new ConnectionTest();
                        con = connection.getconnection();

                        pstmt = con.prepareStatement("INSERT INTO registration (firstname, lastname, username, password, city,email, mob) VALUES (?, ?, ?, ?, ?, ?, ?)");

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

                        pstmt.setString(1, firstName);
                        pstmt.setString(2, lastName);
                        pstmt.setString(3, username);
                        pstmt.setString(4, password);
                        pstmt.setString(5, city);

                        pstmt.setString(6, email);
                        pstmt.setString(7, mob);

                         pstmt.executeUpdate();
                        System.out.println("Record is inserted" );


                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        con.close();
                        pstmt.close();
                }
        }

                public static void main(String[] args) throws SQLException  {

                        UserRegistration user=new UserRegistration();
                        user.registration();

                }

        }





