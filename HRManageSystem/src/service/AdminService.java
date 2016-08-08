package service;

import dao.AdminDao;
import vo.Admin;

public class AdminService {
	public boolean login(Admin ad){
		boolean result=AdminDao.qurey(ad);
		return result;
	}
}
