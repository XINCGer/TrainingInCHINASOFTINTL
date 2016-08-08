package service;

import dao.DutyDao;
import vo.Duty;

public class DutyService {
	public Duty query(Duty duty){
		return DutyDao.query(duty);
	}
	
	public int insert(Duty duty){
		return DutyDao.insert(duty);
	}
	
	public int delete(Duty duty){
		return DutyDao.delete(duty);
	}
	
	public int update(Duty duty){
		return DutyDao.update(duty);
	}
	
	public Duty isExist(Duty duty){
		return DutyDao.isExist(duty);
	}
}
