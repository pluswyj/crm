package com.briup.crm.service;

import com.briup.crm.bean.SysUser;

public interface UserService {
		public SysUser login(String username,String password)throws Exception;
}
