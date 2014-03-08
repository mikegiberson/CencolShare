<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">Group</h1>

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
  			<i class="fa fa-pencil-square-o"></i>
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