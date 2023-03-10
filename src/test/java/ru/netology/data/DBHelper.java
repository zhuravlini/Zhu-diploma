package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    @SneakyThrows
    public static String getPaymentStatus() {
        var usersSQL = "SELECT status FROM payment_entity;";
        var runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        System.getProperty("db.url"), System.getProperty("user"), System.getProperty("password")
                );
        ) {
            String paymentStatus = runner.query(conn, usersSQL, new ScalarHandler<>());
            return paymentStatus;
        }
    }

    @SneakyThrows
    public static String getCreditStatus() {
        var usersSQL = "SELECT status FROM credit_request_entity;";
        var runner = new QueryRunner();
        try (
                Connection conn = DriverManager.getConnection(
                        System.getProperty("db.url"), System.getProperty("user"), System.getProperty("password")
                );
        ) {
            String creditStatus = runner.query(conn, usersSQL, new ScalarHandler<>());
            return creditStatus;
        }
    }
}