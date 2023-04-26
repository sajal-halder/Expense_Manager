package Servlets;

import DbUtils.DbConnector;
import Models.Expense;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/expense_servlet")
public class ExpenseServlet extends HttpServlet {
    DbConnector dbConnector = new DbConnector();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Expense>expenses = dbConnector.getAll();
        req.getSession().setAttribute("expenses", expenses);
        req.getRequestDispatcher("expanses.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbConnector.print();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String category = request.getParameter("category");
        String date = request.getParameter("date");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String amountStr = request.getParameter("amount");
        double amount = 0;
        amount = Double.parseDouble(amountStr);
        boolean result = dbConnector.insertExpense(name,description,amount,date,category);
        doGet(request,response); // redirecting to doGet
    }

}
