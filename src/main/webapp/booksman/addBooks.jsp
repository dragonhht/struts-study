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
<title>图书信息录入</title>
</head>
<body>
	<html:form action="/bookman.do?method_=addBook">
		<table border="1" >
			<tr>
				<td>图书名称:</td>
				<td> <html:text property="bookName" ></html:text>   </td>
			</tr>

			<tr>
				<td>图书价格:</td>
				<td> <html:text property="bookPrice" ></html:text>   </td>
			</tr>

			<tr>
				<td>是否被借阅:</td>
				<td> <html:radio property="browseFlag" value="1">是</html:radio>
					 <html:radio property="browseFlag" value="0">否</html:radio>	
				</td>
			</tr>
			
			<%-- <tr>
				<td>图书所在图书馆</td>
				<td> <html:text property="bookHome" ></html:text>    </td>
			</tr> --%>
		
			<tr>
				<td>图书馆列表</td>
				<td>
					<html:select property="homeId">
						<c:forEach items="${homes }" var="home">
							<html:option value="${home.id }">${home.homeName }</html:option>
						</c:forEach>
					</html:select>
				</td>
			</tr>
		
			<tr>
				<td>图书类别</td>
				<td>
				<html:multibox  property="bookType" value="1" />文言文
				<html:multibox  property="bookType" value="2" />小说 
				<html:multibox  property="bookType" value="3" />论文 
				</td>
			</tr>
	

			<tr>
				<td>图书简介</td>
				<td> <html:textarea property="bookMarks" cols="40" rows="8" ></html:textarea>    </td>
			</tr>
				
			<tr align="center">
				<td ><html:submit value="提交"></html:submit> 
				&nbsp;&nbsp;
					<button onclick="history.go(-1)">返回</button>
				</td>
			</tr>			
		</table>
	</html:form>
</body>
</html>