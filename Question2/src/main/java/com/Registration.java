package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String phone = request.getParameter("phone");
        String marks = request.getParameter("marks");
        String branch = request.getParameter("branch");

        String url = "jdbc:mysql://localhost:3306/igt";
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt","root","1234");
            String sql = "INSERT INTO students (sid, sname, phone, marks, branch) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sid);
            statement.setString(2, sname);
            statement.setString(3, phone);
            statement.setString(4, marks);
            statement.setString(5, branch);

            // Execute the query
            int rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();

            if (rowsInserted > 0) {
                // Redirect to success page
                request.setAttribute("message", "Congrats, you are successfully registered!");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
