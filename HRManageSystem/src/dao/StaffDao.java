package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Staff;
import common.DataBaseUtil;

public class StaffDao {
	private static PreparedStatement pstmt=null;
	private static ResultSet rs=null;
	
	public static Staff query(Staff staff) {
		try {
			String sql="select *from staff where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, staff.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				staff.setName(rs.getString(2));
				staff.setSex(rs.getString(3));
				staff.setSalary(rs.getString(4));
				staff.setTel(rs.getString(5));
				staff.setDept(rs.getString(6));
				staff.setDuty(rs.getString(7));
				pstmt.close();
				rs.close();
				return staff;
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
	
	public static int insert(Staff staff){
		try {
			String sql="insert into staff values(?,?,?,?,?,?,?)";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, staff.getId());
			pstmt.setString(2, staff.getName());
			pstmt.setString(3, staff.getSex());
			pstmt.setString(4, staff.getSalary());
			pstmt.setString(5, staff.getTel());
			pstmt.setString(6, staff.getDept());
			pstmt.setString(7, staff.getDuty());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			if(e.getErrorCode()==1062)return -1;
			return -2;
		}
	}
	public static int delete(Staff staff){
		try {
			String sql = "delete from staff where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, staff.getId());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int update(Staff staff){
		try {
			String sql="update staff set name=?,sex=?,salary=?,tel=?,dept=?,duty=? where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, staff.getName());
			pstmt.setString(2, staff.getSex());
			pstmt.setString(3, staff.getSalary());
			pstmt.setString(4, staff.getTel());
			pstmt.setString(5, staff.getDept());
			pstmt.setString(6, staff.getDuty());
			pstmt.setString(7, staff.getId());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
