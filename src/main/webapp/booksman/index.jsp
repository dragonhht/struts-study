<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示图书信息信息</title>
</head>
<body>
	
	<a href="<%=request.getContextPath()%>/bookhomeman.do?method_=showHomes">进入图书馆管理界面</a>	
	<p></p>
	<a href="<%=request.getContextPath()%>/bookman.do?method_=showBooks">进入图书管理界面</a>	

</body>
</html>