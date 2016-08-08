package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Admin;
import common.DataBaseUtil;

public class AdminDao {
	private static PreparedStatement pstmt=null;
	private static ResultSet rs=null;
	
	public static boolean qurey(Admin ad) {
		String sql = "select *from user where username=? and password=?";
		try {
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, ad.getName());
			pstmt.setString(2, ad.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pstmt.close();
				rs.close();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DataBaseUtil.close();
		}
	}
}
