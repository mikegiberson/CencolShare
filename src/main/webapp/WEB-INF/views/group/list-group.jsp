<%@ include file="..\common\header.jsp"%>

<div class="col-sm-8">
<a href="${pageContext.request.contextPath}/group/create" class="btn btn-success">Create new Group <i class="fa fa-users"></i></a>
<br>
<br>
<table class="table table-bordered">
	<tr>
		<th>Group Name</th>
		<th>Group Description</th>
	</tr>
<c:forEach items="${requestScope.groups}" var="grp">
  <tr > 
  	<td>${grp.groupName}</td>
  	<td class=>${grp.groupDescription}</td>
  </tr>
</c:forEach>
</table>

</div>

<%@ include file="..\common\footer.jsp"%>