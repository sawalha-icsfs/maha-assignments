package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlRetrieveData {
	
	
	private Connection connection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "testuser";
		String password = "test623";
		connection = DriverManager.getConnection(url, user, password);

		return connection;
	}
	Connection connection = null;

	String url = null;
	String user = null;
	String password = null;
	static double avg;
	static int id;
	static Scanner inputScanner = new java.util.Scanner(System.in);
	
	public Students insertFunction(Students student) throws SQLException {

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
	}
	public void deleteStudent(int id) {
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
	

}
