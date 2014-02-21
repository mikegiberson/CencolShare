<%@ include file="..\common\header.jsp"%>

<div class="col-sm-8">
<a href="${pageContext.request.contextPath}/group/create" class="btn btn-success"><i class="fa fa-users"></i> Create new Group</a>
<br>
<br>
<table class="table table-bordered">
	<tr>
		<th>Group Name</th>
		<th>Group Description</th>
		<th>Edit</th>
	</tr>
<c:forEach items="${requestScope.groups}" var="grp">
  <tr > 
  	<td>${grp.groupName}</td>
  	<td>${grp.groupDescription}</td>
  	<td>
  		<a href="${pageContext.request.contextPath}/group/edit/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-pencil"></i>
  		</a>
  		<a class="btn btn-danger">
  			<i class="fa fa-trash-o"></i>
  		</a>
  	</td>
  </tr>
</c:forEach>
</table>
</div>

<%@ include file="..\common\footer.jsp"%>