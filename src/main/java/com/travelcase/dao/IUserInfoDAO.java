package com.travelcase.dao;
import com.travelcase.entity.UserInfo;
public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
}