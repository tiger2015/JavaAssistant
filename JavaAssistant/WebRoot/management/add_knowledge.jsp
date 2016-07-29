<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>添加知识点</title>

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
		<form action="./knowledge/addKnowledge" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>知识点标题</td>
					<td><input type="text" name="knowledge.subject">
					</td>
				</tr>
				<tr>
					<td>重要度(1-5)</td>
					<td><input type="text" name="knowledge.importance">
					</td>
				</tr>
				<tr>
					<td>内容</td>
					<td><textarea rows="5" cols="50" name="knowledge.content"></textarea>
					</td>
				</tr>
				<tr>
					<td>知识点图片(若有图片)</td>
					<td><input type="file" onchange="setImagePreview(this)" name="image">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="localImg">
							<img id="preview" />
						</div></td>
				</tr>
				<tr>
					<td><input type="button" value="取消"
						onclick="gotoUrl('<%=basePath%>knowledge/loadKnowledge?id=1&size=15');">
					</td>
					<td><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
<script type="text/javascript">
	function gotoUrl(url) {
		window.location.href = url;
	}
	function setImagePreview(img) {
		//var docObj = document.getElementById("doc");
		var imgObjPreview = document.getElementById("preview");

		var regext = /\.jpg$|\.gif$|\.jpeg$|\.png$|\.bmp$/gi;

		//火狐浏览器
		if (img.files && img.files[0]) {
			var imageSize = img.files[0].size;
			var imageName = img.files[0].name;//文件名称，不包含完整的路径
			//验证图片格式
			///if (!regext.test(imageName)) {
			//	alert("对不起，请您调整格式后重新上传！");
			//	return;
			//	}
			//判断图片大小
			//	if (imageSize > 1024 * 1024) {
			//		alert("图片大小为1MB以内");
			//		return;
			//	}
			//设image属性
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '100px';
			imgObjPreview.style.height = '100px';
			//imgObjPreview.src = docObj.files[0].getAsDataURL();
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
			imgObjPreview.src = window.URL.createObjectURL(img.files[0]);
		} else {
			//IE浏览器
			var filePath = img.value;
			//var image = new Image();
			//image.dynsrc = filePath;
			//fileSize = image.fileSize;
			//var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
			//var file = fileSystem.GetFile(filePath);
			//var fileSize = file.Size;
			if (!regext.test(filePath)) {
				alert("对不起，请您调整格式后重新上传！");
				return;
			}
			//if (fileSize > 1024 * 1024) {
			//		alert("图片大小为1MB以内");
			//	return;
			//	}
			//IE下，使用滤镜
			img.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImg");
			//必须设置初始大小
			localImagId.style.width = "100px";
			localImagId.style.height = "100px";
			localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters
					.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}
</script>
</html>
