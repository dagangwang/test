/**
 * 
 */
package com.dot.live.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.live.auth.dao.UserDao;
import com.dot.live.auth.domain.User;
import com.dot.live.auth.service.IUserService;
import com.dot.live.base.service.impl.BaseServiceImpl;
/**
 * @author hesq1
 * @date 2015年10月18日
 * @desc 
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements IUserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao){
		super(userDao);  
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.dot.live.auth.service.IUserService#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String username) {
		return null;
	}
}
