package com.dot.live.auth.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.dot.live.auth.dao.UserDao;
import com.dot.live.auth.domain.Role;
import com.dot.live.auth.domain.User;
import com.dot.live.base.dao.impl.BaseDaoImpl;
import com.dot.live.utils.Pagination;

@Repository("authUserDao")
public class UserDaoImpl extends BaseDaoImpl<User,Long>  implements UserDao{
	  
	    @Override  
	    public List findByProperty(String propertyName, Object value) {  
	        // TODO Auto-generated method stub  
	        return null;  
	    }  
	  
	    @Override
		public User getUserByName(String username) {  
	        return null;
	    }  
	  
	    @Override
		public List<String> loadUserAuthoritiesByName(String username) {  
	        User user = this.getUserByName(username);  
	        if (user != null) {  
	            List<Role> roles = user.getRoles();
	            if(null != roles){
	            	List<String> auth = new ArrayList<String>();  
	 	            Iterator<Role> it = roles.iterator();  
	 	            while (it.hasNext()) {  
	 	                auth.add(it.next().getRoleValue());  
	 	            }  
	 	            return auth; 
	            }
	        } 
            return null;  
	    }

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#init()
		 */
		@Override
		public boolean init() {
			return false;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#save(java.lang.Object)
		 */
		@Override
		public void save(User t) {
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#insert(java.lang.Object)
		 */
		@Override
		public void insert(User t) {
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#insert(java.util.List)
		 */
		@Override
		public void insert(List<User> ts) {
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#getById(java.io.Serializable)
		 */
		@Override
		public User getById(Long id) {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#remove(java.io.Serializable)
		 */
		@Override
		public void remove(Long id) {
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#removeAll(java.io.Serializable[])
		 */
		@Override
		public void removeAll(Long[] ids) {
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#getPage(int, org.springframework.data.mongodb.core.query.Query)
		 */
		@Override
		public Pagination<User> getPage(int currentPage, Query query) {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#update(org.springframework.data.mongodb.core.query.Query, org.springframework.data.mongodb.core.query.Update)
		 */
		@Override
		public void update(Query query, Update update) {
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#getAll()
		 */
		@Override
		public List<User> getAll() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#getColName()
		 */
		@Override
		public String getColName() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#generateId()
		 */
		@Override
		public long generateId() {
			return 0;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#getRedisTemplate()
		 */
		@Override
		public RedisTemplate<String, Object> getRedisTemplate() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.dot.live.base.dao.BaseDao#getMongoTemplate()
		 */
		@Override
		public MongoTemplate getMongoTemplate() {
			return null;
		}

}
