package com.zerock.w02.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectTests {

    @Test
    public void test1(){
        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void testConnection()throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "root",
                "root"
        );

        Assertions.assertNotNull(connection);

        connection.close();
    }

}
