import java.sql.*;
import java.util.ArrayList;

public class DBManager{
    private static Connection connection;
    private static String url = "jdbc:postgresql://localhost:5432/oop";
    private static String user="postgres";
    private static String password = "1234567";
    public static void connect(){
        try {
            Class.forName("org.postgresql.Driver");///////путь к драйверу
            connection = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void addOwner(CarOwner carOwner) throws SQLException {
        String sql = "INSERT INTO Car_owner(id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue)VALUES (default, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, carOwner.getName());
        statement.setString(2, carOwner.getSurname());
        statement.setString(3, carOwner.getCarBrand());
        statement.setString(4, carOwner.getCarColor());
        statement.setString(5, carOwner.getCarNumber());
        statement.setString(6, carOwner.getRegNum());
        statement.setInt(7, carOwner.getYearOfIssue());

        statement.executeUpdate();
        statement.close();
    }
    public ArrayList<CarOwner> getListOwners(int operation) throws SQLException {
        ArrayList<CarOwner> carOwnerList = new ArrayList<>();
        String sql = "";
        if(operation==1){
            sql="SELECT id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue " +
                    "FROM Car_owner order by year_of_issue desc;";
        }
        else if(operation==2){
            sql = "SELECT id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue " +
                    "FROM Car_owner" +
                    " where car_color='white' and car_brand='Toyota';";
        }
        else if(operation==3){
            sql = "SELECT id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue " +
                    "FROM Car_owner " +
                    "where car_brand='Tesla' and (year_of_issue=2019 or year_of_issue=2020);";
        }
        else if(operation==4){
            sql="SELECT id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue" +
                    " FROM Car_owner;";
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("fname");
            String surname = resultSet.getString("lname");
            String brand = resultSet.getString("car_brand");
            String color = resultSet.getString("car_color");
            String number = resultSet.getString("car_number");
            String regNum = resultSet.getString("reg_num");
            int year = resultSet.getInt("year_of_issue");

            carOwnerList.add(new CarOwner(id, name, surname, brand, color, number, regNum, year));
        }
        statement.close();
        return carOwnerList;
    }
    public void deleteOwner(int id) throws SQLException {
        String sql = "DELETE FROM Car_owner " +
                "WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        System.out.println(id);
    }
    public void updateOwner(int id, String category, String text) throws SQLException {
        String sql = "";
        switch (category){
            case "Name":
                sql = "update Car_owner set fname = ? where id = ?";
                break;
            case "Surname":
                sql = "update Car_owner set lname = ? where id = ?";
                break;
            case "Brand":
                sql = "update Car_owner set car_brand = ? where id = ?";
                break;
            case "Color":
                sql = "update Car_owner set car_color = ? where id = ?";
                break;
            case "Number":
                sql = "update Car_owner set car_number = ? where id = ?";
                break;
            case "Reg.num":
                sql = "update Car_owner set reg_num = ? where id = ?";
                break;
            case "Year of issue":
                sql = "update Car_owner set year_of_issue = ? where id = ?";
                break;
        }
        PreparedStatement statement = connection.prepareStatement(sql);
        if(category.equals("Year of issue")){
            statement.setInt(1, Integer.parseInt(text));
        }else{
            statement.setString(1, text);
        }
        statement.setInt(2, id);
        statement.executeUpdate();
        statement.close();
    }
}
