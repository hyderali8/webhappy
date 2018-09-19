package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
 String cid;
 String cname,cdescription;
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCdescription() {
	return cdescription;
}
public void setCdescription(String cdescription) {
	this.cdescription = cdescription;
}

}