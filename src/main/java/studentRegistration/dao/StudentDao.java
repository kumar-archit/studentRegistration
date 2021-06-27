package studentRegistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import studentRegistration.model.Student;
public class StudentDao {
	public boolean registerStudent(Student student) throws Exception  {
		String INSERT_STUDENTS_SQL = "INSERT INTO Student"
				+ " (rollNo, marks, name) VALUES "
				+ "(?, ?, ?);";		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=School;;user=dev;password=dev;");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_SQL);
			preparedStatement.setString(1, student.getRollNo());
			preparedStatement.setDouble(2, student.getMarks());
			preparedStatement.setString(3, student.getName());			
			preparedStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println("Exception : registerStudent()::" +e);
			throw(e);
		}finally {
			connection.close();						
		}
	}

	public ArrayList<Student> getAllStudent() throws Exception {
		ArrayList<Student> ans = new ArrayList<Student>();
		String SELECT_STUDENTS_SQL = "SELECT * FROM Student;";		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=School;;user=dev;password=dev;");
		try {
			Statement statement =  connection.createStatement();
			ResultSet resultSet =  statement.executeQuery(SELECT_STUDENTS_SQL);
			while(resultSet.next()) {
				Student student = new Student();
				student.setName(resultSet.getString("name"));
				student.setMarks(resultSet.getDouble("marks"));
				student.setRollNo(resultSet.getString("rollNo"));
				ans.add(student);
			}
			resultSet.close();
		}catch (SQLException e) {
			System.out.println("Exception : getAllStudent()::" +e);
			throw(e);
		}finally {
			connection.close();						
		}
		return ans;
	}

	public boolean deleteStudent(double rollNo) throws Exception {
		String DELETE_STUDENTS_SQL = "DELETE FROM Student WHERE rollNo = ?;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=School;;user=dev;password=dev;");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_SQL);
			preparedStatement.setDouble(1, rollNo);
			preparedStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println("Exception : deleteStudent()::" +e);
			throw(e);
		}finally {
			connection.close();						
		}
	}

	public boolean updateStudent(Student student) throws Exception {
		String UPDATE_STUDENTS_SQL = "UPDATE Student SET name = ?, marks = ? WHERE rollNo = ?;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=School;;user=dev;password=dev;");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setDouble(2, student.getMarks());
			preparedStatement.setString(3, student.getRollNo());
			preparedStatement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println("Exception : updateStudent()::" +e);
			throw(e);
		}finally {
			connection.close();						
		}
	}
	
	
}
