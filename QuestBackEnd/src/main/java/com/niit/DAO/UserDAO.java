package com.niit.DAO;


import com.niit.Model.User;

public interface UserDAO {
public boolean addUser(User user);
public void ViewUser();
public User findUserById(String uid);
public boolean updateUser(User user);
public boolean deleteUser(String uid);
public <UserDetail> UserDetail getDetail(String trim);



}
