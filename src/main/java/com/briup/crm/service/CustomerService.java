package com.briup.crm.service;

import java.util.List;

import com.briup.crm.bean.CstCustomer;
import com.github.pagehelper.PageInfo;

public interface CustomerService {
			public List<CstCustomer> findAllCustomer();
			public PageInfo<CstCustomer> findAllCustomerByPage(int curPage,int size);
			public void deleteCustomerById(long id);
			public void saveOrUpdate(CstCustomer customer);
			public CstCustomer findCustomerById(long id);
}
