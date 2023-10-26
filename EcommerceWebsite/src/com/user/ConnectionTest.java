package com.user;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest{



        Connection con=null;
        public Connection getconnection()
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","Magicworld@1");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return con;
        }
    }


