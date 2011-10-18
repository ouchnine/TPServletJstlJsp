<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page import="java.util.*" %>
<%@ page import="bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> l'afichage du catalogue avec JSP</title>
<link rel="stylesheet" title="droite" href="css/styles.css" type="text/css" media="screen" />
</head>
<body>


<%@include file="header.jsp" %> 
<%
Catalogue catalogue = (Catalogue) request.getAttribute("catalogue");
%>

<div class="titre"><%
 out.println(" "+ catalogue.getNom());
%></div>
<%
HashMap liste=catalogue.getListProduit();

for (Iterator i = liste.values().iterator(); i.hasNext();)
{   
      Produit item = (Produit) i.next(); 
%>
<br>
<br>
<div class="produit">
<table>
<tr>
<td rowspan="2"></td>
<td><a class="nom" href='AfficheProduit?id=<%=item.getId()%>'><%= item.getNom()%></a></td>
</tr>
<tr>
   <td> <img src="<%= item.getImage() %>"/></td> 
</tr>
<tr>
<td class="prix"><%= item.getPrix() %>&nbsp;&euro;</td>
</tr>
<tr>
<td colspan="2" class="desc"><%= item.getDescription()%> </td>
</tr>
</table>
</div>

<%
}

%>
</table> 
</div>
</body>
</html>