package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;

public class JdbcSql {

	SqlRetrieveData SqlRetrieveData = new SqlRetrieveData();
	Connection connection = null;

	String url = null;
	String user = null;
	String password = null;
	static double avg;
	static int id;
	static Scanner inputScanner = new java.util.Scanner(System.in);

	private Connection connection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "testuser";
		String password = "test623";
		connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

/*	public boolean findId(int id) throws SQLException {
		Statement st = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT id FROM Students where id = " + id;
		connection = connection();
		st = connection.createStatement();
		rs = st.executeQuery(sqlQuery);

		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}*/

	public Students selectFunction() throws SQLException {
		Students student = new Students();
		connection = connection();
		Statement st = null;
		ResultSet rs = null;
		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery.append("SELECT ");
		sqlQuery.append("id , ");
		sqlQuery.append("name , ");
		sqlQuery.append("average , ");
		sqlQuery.append("email ");
		sqlQuery.append("FROM ");
		sqlQuery.append("students ");

		st = connection.createStatement();
		rs = st.executeQuery(sqlQuery.toString());

		while (rs.next()) {
			// System.out.println(rs.getInt(1));

			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setAverage(rs.getDouble("average"));
			student.setEmail(rs.getString("email"));
			System.out.println(student);

		}
		rs.close();

		try {
			if (st != null && !st.isClosed()) {
				st.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) { // ignore}
		}

		return student;
	}

/*	public Students insertFunction(Students student) throws SQLException {

		java.sql.PreparedStatement st = null;
		// ResultSet rs = null;
		try {
			connection = connection();

			String sql = "INSERT INTO students (id, name, average, email) VALUES (?, ?, ?, ?)";
			st = connection.prepareStatement(sql);
			st.setInt(1, student.getId());
			st.setString(2, student.getName());
			st.setDouble(3, (int) student.getAverage());
			st.setString(4, student.getEmail());
			st.execute();
			System.out.println("A new student was inserted successfully!");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return student;
	}*/

	public void update() {
		System.out.println("enter average :");
		JdbcSql.avg = inputScanner.nextDouble();
		System.out.println("enter ID :");
		JdbcSql.id = inputScanner.nextInt();

		try {

			connection = connection();
			// String query = "update students set average = 99 where id = 1";
			// String query = "update students set average = ? where id = ?";

			StringBuffer sqlQuery = new StringBuffer();
			sqlQuery.append("update ");
			sqlQuery.append("students ");
			sqlQuery.append("set ");
			sqlQuery.append("average = ?  ");
			sqlQuery.append("where ");
			sqlQuery.append("id = ?  ");

			java.sql.PreparedStatement preparedStmt = connection.prepareStatement(sqlQuery.toString());
			// execute the java preparedstatement preparedStmt.executeUpdate();
			// preparedStmt.executeUpdate();
			preparedStmt.setDouble(1, avg);
			preparedStmt.setInt(2, id);
			int i = preparedStmt.executeUpdate();
			if (i > 0) {
				System.out.println("Sudent Updated");
			} else {
				System.out.println("No Student with id = " + id);
			}

			try {
				if (preparedStmt != null && !preparedStmt.isClosed()) {
					preparedStmt.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) { // ignore}
			}

			connection.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

	}

	/*public void deleteStudent(int id) {
		PreparedStatement stmt = null;
		try {
			connection = connection();
			String sqlQuery = "DELETE FROM students WHERE id = ?";
			stmt = connection.prepareStatement(sqlQuery);
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("Student was deleted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/
	public void addStudent() {
		System.out.println("Enter student ID ");
		int id = inputScanner.nextInt();
		System.out.println("Enter student name ");
		String name = inputScanner.next();
		System.out.println("Enter student Average ");
		double avg = inputScanner.nextDouble();
		System.out.println("Enter student Email ");
		String email = inputScanner.next();

		Students student = new Students(id, name, avg, email);
		try {
			SqlRetrieveData.insertFunction(student);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
	}
	
	public Students retrieveStudent(int id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		Students student = null ;
		
		try {
			String query = "SELECT * FROM Students WHERE id = ?";
			connection = connection();
			st= connection.prepareStatement(query);
			st.setInt(1, id);
			rs=st.executeQuery();
			
			if(rs.next()) {
				student = new Students();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAverage(rs.getDouble("average"));
				student.setEmail(rs.getString("email"));
				System.out.println(student);
			}
			
			return student;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		finally {
			
		}try {
			rs.close();
			if (st != null && !st.isClosed()) {
				st.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) { // ignore}
		}

		return null;
		
		
	}
	
	public void deleteStudent() {
		System.out.println("Please Enter ID of Sutdent you want to Delete :");
		Students student = new Students();
		int id = inputScanner.nextInt();
		student = retrieveStudent(id);
		if(student != null) {
			System.out.println("This is the Information of Student You Want To Delete ");
			System.out.println(student);
			System.out.println("Do You Want To Continue? yes , no ");
			String result = inputScanner.next();
			if(result.equalsIgnoreCase("yes")) {
				SqlRetrieveData.deleteStudent(id);
			
			}else {
				System.out.println("no id found ");
			}
			
			
		}
		else {
			System.out.println("No student with this id !!!");
		}
	}
}
