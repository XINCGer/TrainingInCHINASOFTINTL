package com.example.demo_08_18;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PersonInfo implements Parcelable{
	String name;
	String time;
	String introduce;
	int touxiang;
	public PersonInfo(Parcel in) {
		name=in.readString();
		time=in.readString();
		introduce=in.readString();
		touxiang=in.readInt();
	}
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
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(touxiang);
		dest.writeString(name);
		dest.writeString(time);
		dest.writeString(introduce);
		
	}
	
	public static final Parcelable.Creator<PersonInfo> CREATOR = new Creator<PersonInfo>() {
		@Override
		public PersonInfo[] newArray(int size) {
			return new PersonInfo[size];
		}

		@Override
		public PersonInfo createFromParcel(Parcel in) {
			return new PersonInfo(in);
		}
	};
}
