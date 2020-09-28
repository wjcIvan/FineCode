package com.javen.service.impl;
import java.util.List;

import javax.annotation.Resource;  
  



import org.springframework.stereotype.Service;  

import com.javen.dao.IUserDao;
import com.javen.model.User;
import com.javen.service.IUserService;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;

	public void save(User user) {
		userDao.save(user);
		
	}

	public boolean isCreate(String user) {
		// TODO Auto-generated method stub
		User u = userDao.searchUid(user);
		if(u == null) {
			return false;
		}
		return true;
	}

	public User login(String user, String pswd) {
		// TODO Auto-generated method stub
		return userDao.login(user, pswd);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		
	}

	public User search(int uid) {
		// TODO Auto-generated method stub
		return userDao.searchUid2(uid);
	}

	public List<User> searchAll() {
		// TODO Auto-generated method stub
		return userDao.searchAll();
	}

	public void delete(int uid) {
		userDao.delete(uid);
		
	}

	public void updateXY(int credit, int uid) {
		// TODO Auto-generated method stub
		userDao.updateXY(credit, uid);
	}  
    
    
    
    
    
//    public User getUserById(int userId) {  
//        // TODO Auto-generated method stub  
//        return this.userDao.selectByPrimaryKey(userId);  
//    }  
  
}  
