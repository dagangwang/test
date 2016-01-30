/**
 * 
 */
package com.dot.live.auth.service;

import com.dot.live.auth.domain.User;
import com.dot.live.base.service.IBaseService;

/**
 * @author hesq1
 * @date 2015年10月18日
 * @desc 
 */
public interface IUserService extends IBaseService<User,Long>{
	
	public User getUserByName(String username);
}
