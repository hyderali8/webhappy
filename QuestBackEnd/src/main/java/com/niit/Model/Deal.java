package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Deal {
	@Id
 String did;
 String dname,ddescription;
public String getDid() {
	return did;
}
public void setDid(String did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getDdescription() {
	return ddescription;
}
public void setDdescription(String ddescription) {
	this.ddescription = ddescription;
}

}
