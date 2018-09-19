package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
 String uid;
 String uname,uemail,upwd,umobileno,ulocation;
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getUpwd() {
	return upwd;
}
public void setUpwd(String upwd) {
	this.upwd = upwd;
}
public String getUmobileno() {
	return umobileno;
}
public void setUmobileno(String umobileno) {
	this.umobileno = umobileno;
}
public String getUlocation() {
	return ulocation;
}
public void setUlocation(String ulocation) {
	this.ulocation = ulocation;
}

}
