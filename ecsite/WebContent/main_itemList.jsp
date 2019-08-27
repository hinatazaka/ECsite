<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>itemlist画面</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
/*TAG LAYOUT*/
* {
	margin:0;
	padding:0;
}
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}
/*ID LAYOUT*/
#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 500px;
	background-color: black;
	clear: both;
}

#text-right {
	display: inline-block;
	text-align: right;
}

.item-box {
	border: solid;
	width:20vw;
	height:20vh;
	display:inline-block;
	flex-direction: row;
	flex-wrap: wrap;
}
</style>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>mainitemList</p>
		</div>
		<h3>商品情報は以下になります。</h3>
		<s:iterator value="session.buyItemList">
			<div class="item-box"><ul style ="list-style-type:none;">
				<li class="item-name">商品id:<s:property value="id" />
				<li>商品名:<s:property value="itemName" />
				<li>値段:<s:property value="itemPrice" /><span>円</span>
				<li><a href='<s:url action="ItemBuyAction"> <s:param name="id" value="%{id}"/> </s:url>'>購入</a>
			</ul></div>
		</s:iterator>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>