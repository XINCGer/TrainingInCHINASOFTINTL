package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Dept;
import common.DataBaseUtil;

public class DeptDao {
	private static PreparedStatement pstmt=null;
	private static ResultSet rs=null;
	
	public static Dept query(Dept dept) {
		try {
			String sql = "select * from dept where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, dept.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				dept.setName(rs.getString(2));
				dept.setAddress(rs.getString(3));
				pstmt.close();
				rs.close();
				return dept;
//				return new Dept(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DataBaseUtil.close();
		}
	}
	
	public static int insert(Dept dept){
		try {
			String sql = "insert into dept values(?,?,?)";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, dept.getId());
			pstmt.setString(2, dept.getName());
			pstmt.setString(3, dept.getAddress());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getErrorCode()==1062)return -1;
			return -2;
		}
	}
	public static int delete(Dept dept){
		try {
			String sql = "delete from dept where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, dept.getId());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int update(Dept dept){
		try {
			String sql="update dept set name=?,address=? where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, dept.getName());
			pstmt.setString(2, dept.getAddress());
			pstmt.setString(3, dept.getId());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static boolean isExist(Dept dept) {
		try {
			String sql = "select * from dept where name=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, dept.getName());
			rs = pstmt.executeQuery();
			if(rs.next()){
				pstmt.close();
				rs.close();
				return true;
			}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			DataBaseUtil.close();
		}
	}
}
