package com.design.patterns.SingletonDesignPatterns.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static ConnectionPool instance;
    private List<Connection> connectionPool;
    private static final int POOL_SIZE = 5;

    private ConnectionPool() {
        connectionPool = new ArrayList<>();
        try {
            // Load the PostgreSQL JDBC driver (this step is optional with JDBC 4.0 and beyond)
            Class.forName("org.postgresql.Driver");

            // Create the initial set of connections
            for (int i = 0; i < POOL_SIZE; i++) {
                connectionPool.add(createConnection());
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to create connection pool", e);
        }
    }

    private Connection createConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Daybreak_Dev";
        String user = "postgres";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("No available connections");
        }
        return connectionPool.remove(0);
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.add(connection);
    }
}

