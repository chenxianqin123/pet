<%@page contentType="text/html; charset=UTF-8" language="java" %>>
<%@include file="../app.jsp"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>上传宠物信息</title>
		<link rel="stylesheet" type="text/css" href="css/pet_info.css" />
	</head>
	<body>
		<div class="body">
			<div class="title">上传宠物信息</div>
			<form action="${appPath}/PetServlet?method=add" method="post" enctype="multipart/form-data">
				<div class="contain">
					<div class="class1">
						请选择种类：<input type="radio" name="sort" value="狗狗">狗狗
						<input type="radio" name="sort" value="猫咪">猫咪
					</div>
					<div class="class2">
						宠物品种：<input type="text" name="breed">
					</div>
					<div class="class3">
						描述信息：<input type="text" name="description">
					</div>
					<div class="class4">
						数&nbsp;&nbsp;量：<input type="text" name="number">
					</div>
					<div class="class5">
						价&nbsp;&nbsp;格：<input type="text" name="price">
					</div>
					<div class="class6">
						展示图：<input type="file" name="picture">
					</div>
					<div class="class6">
						<input id="submit" type="submit" value="提交信息">
					</div>
				</div>
			</form>
		</div>
	</body>
</html>
