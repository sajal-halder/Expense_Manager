package DbUtils;


import Models.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbConnector {
    private Connection connection = null;

    public DbConnector (){
        this.getConnection();
    }
    public void  print(){
        System.out.println("from dbutil");
    }

    public void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DbUtils.DB_URL,DbUtils.USER,DbUtils.PASS);
            System.out.println("Db Connection successful");
        }
        catch (SQLException e) {
            System.out.println("Error :"+ e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertExpense(
            String expanseName,
            String description,
            Double amount,
            String date,
            String category
    ){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DbUtils.INSERT_INTO_EXPANSES);
            preparedStatement.setString(1,expanseName);
            preparedStatement.setString(2,description);
            preparedStatement.setDouble(3,amount);
            preparedStatement.setString(4,date);
            preparedStatement.setString(5,category);
            int result = preparedStatement.executeUpdate();
            System.out.println("Insertion success");
            return  result ==1;


        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }
    public List<Expense> getAll(){
        List<Expense> expenses = new ArrayList<>();
        try {
              PreparedStatement preparedStatement = connection.prepareStatement(DbUtils.GET_ALL_SORT_BY_DATE);
              ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()){
                String name = resultSet.getString("name") ;
                String description =  resultSet.getString("description") ;
                Double amount = resultSet.getDouble("amount") ;
                Date date =  resultSet.getDate("date") ;
                String category = resultSet.getString("category") ;
                expenses.add(new Expense(name,description,amount,date,category));

            }
            System.out.println("Got all from db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return expenses;
    }






}