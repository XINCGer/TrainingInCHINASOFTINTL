package vo;

public class Duty {
	String id;
	String name;
	String minSalary;
	String maxSalary;
	
	public Duty() {
		super();
	}

	public Duty(String id, String name, String minSalary, String maxSalary) {
		super();
		this.id = id;
		this.name = name;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
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

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	
}
