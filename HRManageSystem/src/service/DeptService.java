package service;

import dao.DeptDao;
import vo.Dept;

public class DeptService {
	public Dept query(Dept dept){
		return DeptDao.query(dept);
	}
	public int insert(Dept dept){
		return DeptDao.insert(dept);
	}
	public int delete(Dept dept){
		return DeptDao.delete(dept);
	}
	
	public int update(Dept dept){
		return DeptDao.update(dept);
	}
	
	public boolean isExist(Dept dept){
		return DeptDao.isExist(dept);
	}
}
