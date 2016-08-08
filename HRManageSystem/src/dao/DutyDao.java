package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Duty;
import common.DataBaseUtil;

public class DutyDao {
	private static PreparedStatement pstmt=null;
	private static ResultSet rs=null;
	
	public static Duty query(Duty duty) {
		try {
			String sql="select *from duty where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, duty.getId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				duty.setName(rs.getString(2));
				duty.setMinSalary(rs.getString(3));
				duty.setMaxSalary(rs.getString(4));
				pstmt.close();
				rs.close();
				return duty;
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
	
	public static int insert(Duty duty){
		try {
			String sql="insert into duty values(?,?,?,?)";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, duty.getId());
			pstmt.setString(2, duty.getName());
			pstmt.setString(3, duty.getMinSalary());
			pstmt.setString(4, duty.getMaxSalary());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getErrorCode()==1062)return -1;
			return -2;
		}
	}
	public static int delete(Duty duty){
		try {
			String sql = "delete from duty where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, duty.getId());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int update(Duty duty){
		try {
			String sql="update duty set name=?,minSalary=?,maxSalary=? where id=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, duty.getName());
			pstmt.setString(2, duty.getMinSalary());
			pstmt.setString(3, duty.getMaxSalary());
			pstmt.setString(4, duty.getId());
			int tmp= pstmt.executeUpdate();
			pstmt.close();
			return tmp;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static Duty isExist(Duty duty) {
		try {
			String sql="select *from duty where name=?";
			pstmt = DataBaseUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, duty.getName());
			rs = pstmt.executeQuery();
			if(rs.next()){
				duty.setMinSalary(rs.getString(3));
				duty.setMaxSalary(rs.getString(4));
				pstmt.close();
				rs.close();
				return duty;
			}
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DataBaseUtil.close();
		}
	}
}
