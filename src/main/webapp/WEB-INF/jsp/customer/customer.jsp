<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 客户信息查询 -->
<div id="customer">
<div>
  <form class="form-inline">
  <div class="form-group">
    <input type="text" class="form-control" id="exampleInputEmail3" placeholder="请输入客户名称">
  </div>
  <!-- <div class="form-group">
    <input type="text" class="form-control" id="exampleInputPassword3" placeholder="请输入客户经理">
  </div> -->
  <div class="form-group">
	<select name="city" id="" class="form-control">
		 <option value="">请选择所属地区</option>
        <option value="0">华中</option>
        <option value="1">华北</option>
        <option value="2">华南</option>
        <option value="3">华东</option>
	</select>
  </div>
  <div class="form-group">
	<select name="lever" id="" class="form-control">
		<option value="">请选择客户等级</option>
        <option value="0">普通客户</option>
        <option value="1">大客户</option>
        <option value="2">重点开发客户</option>
        <option value="3">合作伙伴</option>
        <option value="4">战略合作伙伴</option>
	</select>
  </div>
  <input class="btn btn-default search" type="button" value="查询">
  <input class="btn btn-default" type="reset" value="重置">
  <input class="btn btn-default" type="button" value="新增" id="add">
</form>
</div>
<div>
	<table class="table table-hover">
		 <thead>
		    <tr style="background:#E8E8E8;">
		      <th>序号</th>
		      <th>客户名称</th>
		      <th>客户经理</th>
		      <th>所属地区</th>
		      <th>客户等级</th>			 
			  <th >操作</th>
		    </tr> 
		  </thead>

		  <tbody>
		  <c:forEach items="${custInfo.list }" var="customer"  >
		     <tr>
		      <td>${customer.custId }</td>
		      <td>${customer.custName }</td>
		      <td>${customer.custManagerName })</td>
		      <td>${customer.custRegion }</td>
		      <td>${customer.custLevelLabel }</td>		     
		      <td class="test">	
		      	<i value = "${customer.custId} " class="layui-icon layui-icon-edit first" title="编辑客户信息"></i> 
		        <i class="layui-icon layui-icon-username user" title="编辑联系人信息"></i>  
		      	<i class="layui-icon layui-icon-read editRecord" title="编辑交往记录"></i>
		        <i value="${customer.custId }" class="layui-icon layui-icon-delete deletee" title="删除客户记录"></i>    
		      </td>
		    </tr> 
		  
		  </c:forEach>
		    
         </tbody>
    </table>
</div>
<div class="fenye">
	<table class="footTable">
			<tr>
				<td colspan="5">共${custInfo.total } 条记录 每页${custInfo.size } 条 第${custInfo.pageNum } 页 <a
					href="javascript:void(0)" onclick="pageSelect(1)">首页</a>
						<c:choose>	
							<c:when test="${custInfo.hasPreviousPage }">
							<a href="javascript:void(0)" onclick="pageSelect(${custInfo.prePage})">上一页</a>
							</c:when>
							<c:otherwise>
							<font color="#ABA8AB">上一页</font>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${custInfo.hasNextPage }">
							<a href="javascript:void(0)" onclick="pageSelect(${custInfo.nextPage})">下一页</a>
							</c:when>
							<c:otherwise>
							<font color="#ABA8AB">下一页</font>
							</c:otherwise>
						</c:choose>
					 <a href="javascript:void(0)" onclick="pageSelect(${custInfo.lastPage })">尾页</a>
				</td>
			</tr>

		</table>
</div>
<!-- 删除模态框 -->
<div class="modal" id="deleteModal">
  <div class="modal-dialog"  style="width:350px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">是否确定删除</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default " data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
<!-- 新增模态框 -->
<div class="modal"  id="toAdd">
  <div class="modal-dialog" style="height:400px;overflow:auto;">
    <div class="modal-content">
       <form>
					<div class="modal-body">
						<div class="form-group">
							<label>客户姓名:</label>
							<input type="text" name="custName"  class="form-control">
						</div>
						<div class="form-group">
							<label>客户经理:</label>
							<input type="text" name="maName" class="form-control">
						</div>
						<div class="form-group">
							<label>所属地区:</label>
							<select name="region" id="" class="form-control">
								<option value="">请选择所属地区</option>
						        <option value="华中">华中</option>
						        <option value="华北">华北</option>
						        <option value="华南">华南</option>
						        <option value="华东">华东</option>
							</select>
						</div>
						<div class="form-group">
							<label>客户等级:</label>
							<select name="level" id="" class="form-control">
								<option value="">请选择客户等级</option>
						        <option value="普通客户">普通客户</option>
						        <option value="大客户">大客户</option>
						        <option value="重点开发客户">重点开发客户</option>
						        <option value="合作伙伴">合作伙伴</option>
						        <option value="战略合作伙伴">战略合作伙伴</option>
							</select>
						</div>
						<div class="form-group">
							<label>客户地址:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>邮政编码:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>客户电话:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>客户传真:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>客户网址:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>营业执照注册号:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>法人:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>注册资金（万元）:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>年营业额:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>开户银行:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>银行账号:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>地税登记号:</label>
							<input type="text" name="msName" class="form-control">
						</div>
						<div class="form-group">
							<label>国税登记号:</label>
							<input type="text" name="msName" class="form-control">
						</div>
					</div>
				</form>
				<div class="modal-footer">
				    <button class="btn" style="background:#ccc">取消</button>
					<button class="btn" style="background:#ccc">保存</button>
				</div>
    </div>
  </div>
</div>
</div>
<style>
#customer{
	width: 1140px;
	overflow: hidden;
}
.pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover, .pagination > .active > span, .pagination > .active > span:focus, .pagination > .active > span:hover {
    background-color: #ccc;
    border-color: #ccc;
}
.pagination > li > a, .pagination > li > span {
    color: black;
}
.fenye{
	margin-left: 400px;
}
	.form-inline{
		margin-top: 15px;
		margin-left: 10px;
		margin-bottom: 20px;
	}
	.search{
		margin-left: 50px;
	}
	.table th,td{
		text-align: center;
	}
	#add{
		margin-left: 250px;
	}
	#toAdd{
		margin-top: 50px;
	}
	#deleteModal{
		margin-top: 100px;
	}
</style>
<script type="text/javascript">
     function pageSelect(curPage){
    	 let url="customer/findAllCustomerByPage/"+curPage;
    	 $(".layui-body").load(url);
     }
	$(function(){
		let cust_id;
		$('.user').on('click',function(){
			$('.layui-body').load('./pages/linkman.html');  
		})
		$('.editRecord').on('click',function(){
			$('.layui-body').load('./pages/activities.html');  
		})

		// 点击新增显示模态框
		$('#add').click(function(){
			$('#toAdd').show();
		})
		// 新增模态框关闭
		$('button:contains(取消)').on('click',function(){
			$('button[type=reset]').trigger('click');
				$('#toAdd').hide();
		})
		// 新增模态框保存
		$('button:contains(保存)').on('click',function(){
			let custName=$("input[name=custName]").val();
			let maName=$("input[name=maName]").val();
			let region = $("select[name=region] option:selected").val();
			let level = $("select[name=level] option:selected").val();
			let data={
					custId:cust_id,
					custName:custName,
					custManagerName:maName,
					custRegion:region,
					custLevelLabel:level
			};
			let url="customer/savaOrUpdate";
		$.post(url,data,function(data){
			alert(data);
			$(".layui-nav-item dd:contains('客户信息查询')").trigger("click");
		});
				$('#toAdd').hide();
		})	
		// 显示编辑模态框
		$('.first').click(function(){
			cust_id=$(this).attr("value");
			let url="customer/findCustomerById/"+cust_id;
			$.get(url,function(data){
				
			   $("input[name=custName]").val(data.custName);
			   $("input[name=maName]").val(data.custManagerName);
			   $("select[name=region]").val(data.custRegion);
			   $("select[name=level]").val(data.custLevelLabel);
			   
			});
			
			
			$('#toAdd').show();
		})
		// 显示删除模态框
		$('.deletee').click(function(){
			cust_id=$(this).attr("value");
			
			$('#deleteModal').show();
		})
		// 关闭删除模态框
		$('.close').click(function(){
			$('#deleteModal').hide();
		})
		// 关闭删除模态框
		$('.btn-default').click(function(){
			$('#deleteModal').hide();
		})
		// 确定删除
		$('.btn-primary').click(function(){
			let url = "customer/deleteCustomerById/"+cust_id;
			$.get(url,function(data){
				alert(data);
				$(".layui-nav-item dd:contains('客户信息查询')").trigger("click");
			});
			$('#deleteModal').hide();
		})
		// 查询
		$('.search').click(function(){
			alert('查询');
		});

	})
</script>