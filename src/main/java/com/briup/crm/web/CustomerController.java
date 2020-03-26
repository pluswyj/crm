package com.briup.crm.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.CstCustomer;
import com.briup.crm.service.CustomerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	  private CustomerService custService;
	  
	  @RequestMapping("/findAllCustomer")
		public String findAllCustomer(HttpSession session) {
		
		  //调用Service,把所有客户信息查询出来
		  List<CstCustomer> custList = custService.findAllCustomer();
		  session.setAttribute("custList", custList);
			return "customer/customer";
		}
	  
	  
	  //   findAllCustomerByPage/1  第一页的数据
	  //@PathVariable SpringMVC中的注解，从路径中拿值
	  //若路径中参数名和方法中不同 为curPaged，则(@PathVariable("curPaged") int curPage)
	  @RequestMapping("/findAllCustomerByPage/{curPage}")
	  public String findAllCustomerByPage(@PathVariable int curPage,HttpSession session) {
		  //调用Service中分页方法
		  PageInfo<CstCustomer> custInfo = custService.findAllCustomerByPage(curPage, 5);
		  session.setAttribute("custInfo", custInfo);
		  return "customer/customer";
	  }
	  //   deleteCustomerById/1
	  @RequestMapping("/deleteCustomerById/{id}")
	  @ResponseBody
	  public String deleteCustomerById(@PathVariable long id) {
		  custService.deleteCustomerById(id);
		  return "删除成功";
	  }
	  
	  @RequestMapping(value="/savaOrUpdate",method=RequestMethod.POST)
	  @ResponseBody
	  public String savaOrUpdate(CstCustomer customer) {
		  custService.saveOrUpdate(customer);
		  return "保存成功";
	  }
	  
	  @RequestMapping("/findCustomerById/{id}")
	  @ResponseBody
	  public CstCustomer findCustomerById(@PathVariable long id) {
		  CstCustomer customer = custService.findCustomerById(id);
		  return customer;
	  }
}
