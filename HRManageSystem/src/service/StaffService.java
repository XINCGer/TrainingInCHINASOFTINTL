package service;

import dao.StaffDao;
import vo.Staff;


public class StaffService {
	public Staff query(Staff staff){
		return StaffDao.query(staff);
	}
	public int insert(Staff staff){
		return StaffDao.insert(staff);
	}
	
	public int delete(Staff staff){
		return StaffDao.delete(staff);
	}
	
	public int update(Staff staff){
		return StaffDao.update(staff);
	}
}
