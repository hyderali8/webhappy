package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
 String pid;
 String pname,pdescription,pcost,pquantity;
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPdescription() {
	return pdescription;
}
public void setPdescription(String pdescription) {
	this.pdescription = pdescription;
}
public String getPcost() {
	return pcost;
}
public void setPcost(String pcost) {
	this.pcost = pcost;
}
public String getPquantity() {
	return pquantity;
}
public void setPquantity(String pquantity) {
	this.pquantity = pquantity;
}

}