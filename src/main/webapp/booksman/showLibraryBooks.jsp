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
<title>图书馆图书列表</title>

<script type="text/javascript">
	function delBook() {
		var flag = confirm("确认删除！");
		return flag;
	}
</script>

</head>
<body>

<center>
		<font size="5" color="#FF0000">《${home.homeName }》图书信息列表</font>
		&nbsp;&nbsp;<button onclick='javascript:location.href="<%=request.getContextPath()%>/bookman.do?method_=toAddBookPage"'>录入图书信息</button>
		<table border="1" >
			<tr>
				<td><bean:message bundle="km-books" key="books.name"/>:</td>
				<td><bean:message bundle="km-books" key="books.price"/>:</td>
				<td><bean:message bundle="km-books" key="books.jieYueFlag"/>:</td>
				<td><bean:message bundle="km-books" key="books.type"/>:</td>
				<td><bean:message bundle="km-books" key="books.home"/>:</td>
				<td><bean:message bundle="km-books" key="books.remarks"/>:</td>
			</tr>
				<c:forEach items="${home.books }" var="book">
				
			<tr>
			 	<td>${book.bookName } </td>
				<td>${book.bookPrice } </td>
				<td>

				<logic:equal value="1" name="book" property="browseFlag">
					是
				</logic:equal>

				<logic:equal value="0" name="book" property="browseFlag">
					否
				</logic:equal>
				
				</td>
				<td>
				<c:forEach items="${book.bookType}" var="type">	
					<c:if test="${type==1 }">文言文</c:if>
					<c:if test="${type==2 }">小说</c:if>
					<c:if test="${type==3 }">论文</c:if>
				</c:forEach>
				</td>
				<td>${book.home.homeName } </td>
				<td>${book.bookMarks }</td>
				<td>
					<a onclick="return delBook()" href="<%=request.getContextPath()%>/bookman.do?method_=delBook&id=${book.id}">删除</a>
					<a href="<%=request.getContextPath()%>/bookman.do?method_=showUpdatePage
						&id=${book.id }">修改</a>
					<a href="<%=request.getContextPath()%>/bookman.do?method_=showUpdatePage
						&id=${book.id }">查看</a>
				</td> 
			</tr>		
				</c:forEach>
		</table>
	</center>
</body>
</html>