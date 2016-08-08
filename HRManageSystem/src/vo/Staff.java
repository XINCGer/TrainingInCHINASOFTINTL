package vo;

public class Staff {
	String id;
	String name;
	String sex;
	String salary;
	String tel;
	String dept;
	String duty;
	
	public Staff() {
		super();
	}

	public Staff(String id, String name, String sex, String salary, String tel,
			String dept, String duty) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.salary = salary;
		this.tel = tel;
		this.dept = dept;
		this.duty = duty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
	
}
