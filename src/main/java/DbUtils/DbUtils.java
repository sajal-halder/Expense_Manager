package DbUtils;

public class DbUtils {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/expense_manager";
    public static final String USER = "root";
    public static final String PASS = "";

    public static final String INSERT_INTO_EXPANSES=     "INSERT INTO `expenses` (`name`, `description`, `amount`, `date`, `category`, `expanse_id`) VALUES (?, ?, ?, ? ,?, NULL)";
    public static final String GET_ALL_SORT_BY_DATE = "SELECT * FROM `expenses` ORDER BY date DESC";

}

