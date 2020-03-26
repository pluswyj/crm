package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.SysUser;
import com.briup.crm.bean.SysUserExample;
import com.briup.crm.dao.SysUserMapper;
import com.briup.crm.service.UserService;

//业务逻辑层

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private SysUserMapper mapper;
	
	@Override
	public SysUser login(String username, String password) throws Exception {
		/*
		 * 判断用户名是否正确,根据用户名去数据库查询是否有对应的用户信息
		 * 如果有说明用户名正确
		 * */
		 SysUserExample example = new SysUserExample();
		 example.createCriteria().andUsrNameEqualTo(username);
		List<SysUser> userList = mapper.selectByExample(example);
		//如果集合的长度大于0，说明数据库中有对应的数据
		if(userList.size()>0) {
			SysUser user = userList.get(0);
			//判断密码是否正确
			if(password.equals(user.getUsrPassword())){
				return user;
			}else {
				throw new Exception("密码输入错误，请重新输入");
			}
		}else {
			throw new Exception("用户名输入错误，请重新输入");
		}
		
	}

}
