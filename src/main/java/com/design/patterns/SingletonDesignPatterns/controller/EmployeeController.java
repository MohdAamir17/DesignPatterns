package com.design.patterns.SingletonDesignPatterns.controller;

import com.design.patterns.SingletonDesignPatterns.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/fetchEmployees")
    public String fetchEmployeeData() {
        employeeService.fetchEmployeeData();
        return "Employee data fetched successfully";
    }
}


/*
package com.design.patterns.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConnectionPool {

    private static final int POOL_SIZE = 5;
    private static final long CONNECTION_TIMEOUT = 5000; // Timeout in milliseconds

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    public ConnectionPool() {
        connectionPool = new ArrayList<>();
        try {
            // Set login timeout for the DriverManager
            DriverManager.setLoginTimeout((int) (CONNECTION_TIMEOUT / 1000)); // Convert milliseconds to seconds

            for (int i = 0; i < POOL_SIZE; i++) {
                connectionPool.add(createConnection());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create connection pool", e);
        }
    }

    private Connection createConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Daybreak_Dev";
        String user = "postgres";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool();
    }

    public synchronized Connection getConnection() {
        long startTime = System.currentTimeMillis();
        while (connectionPool.isEmpty()) {
            try {
                // Wait for a connection to become available
                wait(CONNECTION_TIMEOUT);

                // Check if timeout has elapsed
                if (System.currentTimeMillis() - startTime >= CONNECTION_TIMEOUT) {
                    throw new RuntimeException("Connection timeout: No available connections in the pool");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted while waiting for a connection", e);
            }
        }

        // Get a connection from the pool
        Connection connection = connectionPool.remove(0);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            usedConnections.remove(connection);
            connectionPool.add(connection);
            notifyAll(); // Notify waiting threads that a connection is available
        }
    }

    public synchronized void closeAllConnections() {
        try {
            for (Connection connection : connectionPool) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
            for (Connection connection : usedConnections) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while closing connections", e);
        }
    }
}

 */