
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Models.Expense" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>

<head>
    <title>Expense Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .mybg {
            background: #1e1d1e;
        }
        .glass {
            background: #353435;
            border: 1px solid #fff;
            border-radius: 15px;
            box-shadow: 0 0 1rem 0 rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<%
    List<Expense> expenses=(List<Expense>) request.getSession().getAttribute("expenses");
%>

<body class="mybg">

<div class="container-fluid">
    <div class="row justify-content-center my-5">


        <div class="col-md-3 card py-4 text-light   glass">
            <h2 class="text-center">Expense Form</h2>
            <form class="flex" id="expense-form " method="post" action="expense_servlet">
                <div class="form-group">
                    <label for="name">Expense Name:</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="category">Expense Category:</label>
                    <select class="form-control" id="category" name="category">
                        <option value="Transportation">Transportation</option>
                        <option value="Food">Food</option>
                        <option value="Fees">Fees</option>
                        <option value="Bills">Bills</option>
                        <option value="Entertainment">Entertainment</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="date">Date:</label>
                    <input type="date" class="form-control" id="date" name="date" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" required></textarea>
                </div>
                <div class="form-group">
                    <label for="amount">Amount:</label>
                    <input type="number" step="any" class="form-control" id="amount" name="amount" required>
                </div>
                <div class=" text-center mt-5 mb-3">
                    <button type="submit" class="btn btn-primary w-75">Add</button>
                </div>
            </form>
        </div>

        <div class="col-md-2 ">
        </div>

        <div class="col-md-6 card py-4 text-light  glass">
            <h2 class="text-center">All Expenses</h2>
            <table class="table mt-3">
                <thead>
                <tr>
                    <th>Category</th>
                    <th>Date</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Amount</th>
                </tr>
                </thead>
                <tbody>
                <%  for (Expense expense : expenses)
                {
                %>
                <tr>
                    <td><%=expense.getCategory()%></td>
                    <td><%=expense.getDate()%></td>
                    <td><%=expense.getExpanse_name()%></td>
                    <td><%=expense.getDescription()%></td>
                    <td><%=expense.getAmount()%></td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</div>


</body>

</html>
