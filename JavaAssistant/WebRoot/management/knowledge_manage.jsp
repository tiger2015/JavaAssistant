<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>知识信息管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
		<input type="button" value="返回" onclick="gotoUrl('<%=basePath%>');"
			id="backButton"> <input type="button" value="添加"
			onclick="gotoUrl('<%=basePath%>management/add_knowledge.jsp')">
		<s:if test="list.size()==0">
			<h3 style="color: red;">没有数据！</h3>
		</s:if>
		<s:else>
			<table cellpadding="5px" style="text-align: center;">
				<tr>
					<th>编号</th>
					<th>知识点标题</th>
					<th>重要度</th>
					<th></th>
					<th></th>
				</tr>
				<s:iterator value="#request.list">
					<tr>
						<td><s:property value="id" />
						</td>
						<td><s:property value="subject" />
						</td>
						<td><s:property value="importance" />
						</td>
						<td><a href="javascript:void(0);"
							onclick="edit('<%=basePath%>knowledge/loadKnowledgeById',<s:property value="id" />)">编辑</a>
						</td>
						<td><input type="checkbox" name="delete_checkbox"
							value="<s:property value="id" />" onclick="selectSingle(this)">
						</td>
					</tr>
				</s:iterator>
			</table>
			<a href="javascript:void(0);"
				onclick="first('<%=basePath%>knowledge/loadKnowledge',0,<s:property value="#request.pageSize"/>)">首页</a>
			<a href="javascript:void(0);"
				onclick="previous('<%=basePath%>knowledge/loadKnowledge',<s:property value="#request.id"/>,<s:property value="#request.pageSize"/>)">上一页</a>
			<a href="javascript:void(0);"
				onclick="next('<%=basePath%>knowledge/loadKnowledge',<s:property value="#request.id"/>,<s:property value="#request.pageSize"/>)">下一页</a>
			<a href="javascript:void(0);"
				onclick="last('<%=basePath%>knowledge/loadKnowledge',<s:property value="#request.pageCount"/>,<s:property value="#request.pageSize"/>)">尾页</a>
			<input type="checkbox" title="全选" onclick="selectAll(this)"
				id="select_all">全选
		    <input type="button" value="删除" id="delete"
				onclick="deleteSelected('<%=basePath%>')">
		</s:else>
	</center>
	<script type="text/javascript">
	function gotoUrl(url) {
		window.location.href = url;
	}
	
	function first(url,start,size){
		window.location.href=url+"?id="+start;
	}
	function next(url,start,size){
		window.location.href=url+"?id="+(start+size);	
	}
	
	function previous(url,start,size){
		window.location.href=url+"?id="+(start-size);	
	}
	
	function last(url,count,size){
		window.location.href=url+"?id="+((count-1)*size);	
	}
	
	function edit(url,id){
		window.location.href=url+"?id="+id;
	}
	//选择全部
	function selectAll(check){
		if(check.checked){
			var nodeList = document.getElementsByName("delete_checkbox");
			for ( var i = 0; i < nodeList.length; i++) {
				nodeList[i].checked = true;
			}
		}
	}
	//选中某个选项
	function selectSingle(val) {
		if (val.checked == false) {
			var selAll = document.getElementById("select_all");
			selAll.checked = false;
		}
	}
	
	function deleteSelected(url){
		var vals="";
		var nodeList = document.getElementsByName("delete_checkbox");
		for ( var i = 0; i < nodeList.length; i++) {
			if(nodeList[i].checked){
				vals+=nodeList[i].value+",";
			}
		}
		if(vals.length==0){
			alert("若要删除，请至少选择一项！");
			return;
	    }
		
		if(window.confirm("确定要删除？")){		
			window.location.href=url+"ids="+vals;
		}	
	}
</script>
</body>
</html>
