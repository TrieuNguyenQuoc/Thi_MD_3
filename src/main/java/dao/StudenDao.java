package dao;

import modle.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudenDao {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/exam_module_3?useSSL=false";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123456789";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<Student> getAllStudent(){
        String SELECT_ALL_SQL = "SELECT*FROM student LEFT JOIN department USING(department_id);";
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String birth = resultSet.getString("birth");
                int classroom = resultSet.getInt("department_name");
                studentList.add(new Student(id,name,email,address,phoneNumber,birth,classroom));
            }
        }
        catch (SQLException ex){
            printSQLException(ex);
        }
        return studentList;
    }

    public void insertStudent(Student student){
        String INSERT_STUDENT_SQL = "INSERT INTO studen VALUES (default,?,?,?,?,?,?);";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)){
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setString(6, student.getBirth());
            preparedStatement.setInt(7, student.getClassroom());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            printSQLException(ex);
        }
    }
    public void updateStudent(Student student){
        String UPDATE_STUDENT_SQL = "UPDATE student SET name=?,email=?,address=?,phone_number=?,salary=?,department_id=? WHERE studen_id = ?;";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)){
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhone());
            preparedStatement.setString(6, student.getBirth());
            preparedStatement.setInt(7, student.getClassroom());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            printSQLException(ex);
        }
    }

    public void deleteStudent(String student_id){
        String DELETE_STUDENT_SQL = "DELETE FROM student WHERE studen_id = ?;";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)){
            preparedStatement.setString(1, student_id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex){
            printSQLException(ex);
        }
    }

    public List<Student> searchStudent(String searchKey){
        String SELECT_EMPLOYEE_BY_ID = "SELECT*FROM employee LEFT JOIN department USING(department_id) WHERE name like ?;";
        List<Student> studenList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)){
            preparedStatement.setString(1, "%"+ searchKey + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String birth = resultSet.getString("birth");
                int classroom = resultSet.getInt("classroom");
                studenList.add(new Student(id,name,email,address,phone,birth,classroom));
            }
        }
        catch (SQLException ex){
            printSQLException(ex);
        }
        return studenList;
    }
}
