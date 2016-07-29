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

<title>更新知识点</title>

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
		<form action="./knowledge/addKnowledge" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td></td>
					<td><input type="hidden" name="knowledge.id" readonly="readonly"
						value='<s:property value="#request.knowledge.id"/>'>
					</td>
				</tr>
				<tr>
					<td>知识点标题</td>
					<td><input type="text" name="knowledge.subject"
						value='<s:property value="#request.knowledge.subject"/>'>
					</td>
				</tr>
				<tr>
					<td>重要度(1-5)</td>
					<td><input type="text" name="knowledge.importance"
						value="${request.knowledge.importance}"></td>
				</tr>
				<tr>
					<td>内容</td>
					<td><textarea rows="5" cols="50" name="knowledge.content" id="content"><s:property value="#request.knowledge.content" /></textarea>
					</td>
				</tr>
				<tr>
					<td>知识点图片(若有图片)</td>
					<td><input type="file" onchange="setImagePreview(this)"
						name="image"></td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="localImg">
							<img id="preview"
								src="<%=basePath%><s:property value="#request.knowledge.imageUrl"/>" style="width: 100px;height: 100px"/>
						</div>
					</td>
				</tr>
				<tr>
					<td><input type="button" value="取消"
						onclick="gotoUrl('<%=basePath%>knowledge/loadKnowledge?id=0');">
					</td>
					<td><input type="submit" value="提交">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
<script type="text/javascript">
	function gotoUrl(url) {
		window.location.href = url;
	}
</script>
</html>
