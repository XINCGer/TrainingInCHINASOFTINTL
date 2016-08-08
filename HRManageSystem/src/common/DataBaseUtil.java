package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DataBaseUtil {
	private static Connection conn = null;

	public static Connection getConnection() throws SQLException {
		// ע������
		DriverManager.registerDriver(new OracleDriver());

		String url = "jdbc:mysql://localhost:3306/hr";
		String user = "root";
		String password = "123456";
		// �������ݿ�
		if (conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}

	public static void close() {
		try {
			if(!conn.isClosed())
			DataBaseUtil.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
