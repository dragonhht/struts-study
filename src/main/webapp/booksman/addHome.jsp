<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息录入</title>
</head>
<body>
	<html:form action="/library.do?method_=addHome">
		<table border="1" >
			<tr>
				<td>图书馆名称:</td>
				<td> <html:text property="homeName" ></html:text></td>
			</tr>

			<tr>
				<td>图书简介</td>
				<td> <html:textarea property="homeMarks" cols="40" rows="8" ></html:textarea>    </td>
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