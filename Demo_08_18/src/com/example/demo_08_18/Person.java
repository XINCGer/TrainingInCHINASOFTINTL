package com.example.demo_08_18;

import java.io.Serializable;

public class Person implements Serializable{
	String name;
	String time;
	String introduce;
	int touxiang;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(int touxiang) {
		this.touxiang = touxiang;
	}
}
