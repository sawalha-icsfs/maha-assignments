package JDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMenue {

	private static JdbcSql jdbcSql = new JdbcSql();

	public static void main(String[] args) {
		Scanner inputScan = new Scanner(System.in);

		System.out.println("******** Menue ******** ");
		System.out.println("1 - Add Student ");
		System.out.println("2 - Update Student ");
		System.out.println("3 - Delete Student ");
		System.out.println("4 - Show All Students ");
		System.out.println("5 - Quit ");
		System.out.println("**************************");
		System.out.println("Please Enter your Choice : ");
		int inputMenueNum = inputScan.nextInt();

		switch (inputMenueNum) {
		case 1:
			System.out.println("****  Adding New Student  ****  ");
			jdbcSql.addStudent();
			break;

		case 2:
			System.out.println("****  Updating Student  **** ");
			jdbcSql.update();
			break;

		case 3:
			System.out.println("****  Deleting Student  **** ");
			jdbcSql.deleteStudent();
			break;
		case 4:
			System.out.println("****  Showing All Students  **** ");
			try {
				jdbcSql.selectFunction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Quitting... ");
			
			break;

		default:
			break;
		}
	}

	

}
