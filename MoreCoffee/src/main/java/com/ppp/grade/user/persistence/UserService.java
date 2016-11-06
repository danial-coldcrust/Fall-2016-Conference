package com.ppp.grade.user.persistence;

import java.util.List;

public interface UserService {
	public void insertUser(UserVO vo);
	public UserVO getUser(UserVO vo);
	public void updateUser(UserVO vo);
	public void deleteUser(UserVO vo);
	public List<UserVO> getUserList(UserVO vo);
	public UserVO CheckID(UserVO vo);
}
