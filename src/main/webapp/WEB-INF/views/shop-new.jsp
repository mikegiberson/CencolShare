<%@ include file="common/header.jsp"%>

<h1>Add Shop</h1>
<form:form method="POST" commandName="shop" action="${pageContext.request.contextPath}/shop/create.html" >
<table>
<tbody>
<tr>
<td>Shop name:</td>
<td><form:input path="name" /></td>
<td><form:errors path="name" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Employees number:</td>
<td><form:input path="emplNumber" /></td>
<td><form:errors path="emplNumber" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input class="btn btn-success" type="submit" value="Save" /></td>
<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/">Cancel</a></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>

<%@ include file="common/footer.jsp"%>