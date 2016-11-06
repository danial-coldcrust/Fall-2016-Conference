package com.ppp.grade.user.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}
	public List<UserVO> getUserList(UserVO vo) {
		return userDAO.getUserList(vo);
	}
	public UserVO CheckID(UserVO vo){
		return userDAO.CheckID(vo);
	}

}