package Models;

import java.util.Date;

public class Expense {
    public Expense(String expanse_name, String description, Double amount, Date date, String category) {
        this.expanse_name = expanse_name;
        this.description = description;
        this.amount = amount;
        this.date = date;
        Category = category;
    }

    String expanse_name;
    String description;
    Double amount;
    Date date;
    String Category;

    public String getExpanse_name() {
        return expanse_name;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return Category;
    }

}
