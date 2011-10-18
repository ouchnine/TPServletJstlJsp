<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage avec JSTL</title>
<link rel="stylesheet" title="droite" href="css/styles.css" type="text/css" media="screen" />

</head>

<body>


<c:import url="header.jsp"/>

<div class="titre"><%
 out.println(" ");
%></div>
<c:forEach var="item" begin="0" items="${catalogue.listProduit}">

<br>
<br>
<div class="produit">
<table>
<tr>
<td rowspan="2"></td>
<td><a class="nom" href='AfficheProduit?id=${item.value.id}'><c:out value="${item.value.nom}" /> </a></td>
</tr>
<tr>
   <td> <img src="${item.value.image}"/></td> 
</tr>
<tr>
<td class="prix">${item.value.prix}&nbsp;&euro;</td>
</tr>
<tr>
<td colspan="2" class="desc">${item.value.description} </td>
</tr>
</table>
</div>

</c:forEach> 

</table> 
</div>
</body>
</html>