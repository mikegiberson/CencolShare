<%@ include file="common/header.jsp"%>

<h1>Shop List page</h1>
<table class="table table-bordered">
<thead>
<tr>
<th width="25px">id</th><th width="150px">company</th><th width="25px">employees</th><th width="50px">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="shop" items="${shopList}">
<tr>
<td>${shop.id}</td>
<td>${shop.name}</td>
<td>${shop.emplNumber}</td>
<td>
<a class="btn btn-primary" href="${pageContext.request.contextPath}/shop/edit/${shop.id}.html"><i class="fa fa-pencil"></i></a>
<a class="btn btn-danger" href="${pageContext.request.contextPath}/shop/delete/${shop.id}.html"><i class="fa fa-trash-o"></i></a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>

<%@ include file="common/footer.jsp"%>