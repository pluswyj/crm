package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstCustomer;
import com.briup.crm.bean.CstCustomerExample;
import com.briup.crm.dao.CstCustomerMapper;
import com.briup.crm.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CstCustomerMapper mapper;
	
	@Override
	public List<CstCustomer> findAllCustomer() {
		//调用dao层查询所有的顾客信息
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> custList = mapper.selectByExample(example);
		
		return custList;
	}
	
	//查询所有客户信息并分页
	@Override
	public PageInfo<CstCustomer> findAllCustomerByPage(int curPage, int size) {
	//设置当前是第几页，每一页显示多少条数据
		PageHelper.startPage(curPage, size);
		
		//查询所有的顾客信息
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> custList = mapper.selectByExample(example);
		
		PageInfo<CstCustomer> custInfo=new PageInfo<CstCustomer>(custList);
		return custInfo;
	}

	@Override
	public void deleteCustomerById(long id) {
		mapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void saveOrUpdate(CstCustomer customer) {
	  Long id = customer.getCustId();
		//如果id为空新增，否则更新
	  if(id==null) {
		  //插入的时候会先做一个判断操作 如果某个字段传入为空就不插入 
		  //插入信息的时候可以不传全 信息可以不写全 不传的信息为null就不赋值 否则赋值
		  //而insert方法每个参数都必须传递
		  mapper.insertSelective(customer);
	  }else {
		  //该方法同上，参数可以不传全
		  mapper.updateByPrimaryKeySelective(customer);
	  }
	}

	@Override
	public CstCustomer findCustomerById(long id) {
		CstCustomer customer = mapper.selectByPrimaryKey(id);
		return customer;
	}
   
}
