package com.design.patterns.SingletonDesignPatterns.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class EmployeeService {

    public void fetchEmployeeData() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get connection from the pool
            connection = pool.getConnection();

            // Use the connection to perform a database operation
            String query = "SELECT * FROM employees";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            // Process the result set (for example, printing employee names)
            while (resultSet.next()) {
                System.out.println("Employee Name: " + resultSet.getString("emp_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Return the connection to the pool
            if (connection != null) {
                pool.releaseConnection(connection);
            }
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
