package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/policy_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                ""
            );

            System.out.println("DB Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
