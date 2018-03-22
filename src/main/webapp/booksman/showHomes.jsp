<%@page import="landray.study.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts/struts-logic.tld" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管</title>

<script type="text/javascript">
	function delBook() {
		var flag = confirm("确认删除！");
		return flag;
	}
</script>

</head>
<body>

<center>
		<font size="5" color="#FF0000">图书管列表</font>
		&nbsp;&nbsp;<button onclick='javascript:location.href="<%=request.getContextPath()%>/booksman/addHome.jsp"'>录入新图书馆</button>
		<table border="1" >
			<tr>
				<td><bean:message bundle="km-books" key="library.name"/>:</td>
				<td><bean:message bundle="km-books" key="library.marks"/>:</td>
			</tr>
				<c:forEach items="${homes }" var="home">
				
			<tr>
			 	<td>${home.homeName } </td>
				<td>${home.homeMarks } </td>
				<td>
				<td>
					<a onclick="return delBook()" href="<%=request.getContextPath()%>/library.do?method_=deleteHome&id=${home.id}">删除</a>
					<a href="<%=request.getContextPath()%>/library.do?method_=updatePage
						&id=${home.id }">修改</a>
					<a href="<%=request.getContextPath()%>/library.do?method_=updatePage
						&id=${home.id }">查看图书馆信息</a>
					<a href="<%=request.getContextPath()%>/library.do?method_=showLibraryBooks
						&id=${home.id }">查看馆内图书</a>
				</td> 
			</tr>		
				</c:forEach>
		</table>
	</center>
</body>
</html>