package com.liuzi.bean;

public class Admin {
	public static String ADMIN_ID="admin_Id";
    public static String PASSWORD="password";
    public static String NAME="name";
    public static String PHONE="phone";
    public static String IDENTITY="identity";
    public static String STATUS="status";

    private String admin_Id;
    private String password;
    private String name;
    private String phone;
    private String identity;

    public String getAdmin_Id() {
        return admin_Id;
    }

    public void setAdmin_id(String admin_Id) {
        this.admin_Id = admin_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
    
    public Admin(String admin_Id,String password){
    	this.admin_Id=admin_Id;
    	this.password=password;
    	
    }

}
