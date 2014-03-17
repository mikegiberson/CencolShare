<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">Discussions</h1>
<a href="${pageContext.request.contextPath}/discussion/create" class="btn btn-success"><i class="fa fa-users"></i> Create new Discussion</a>
<br>
<p>List of discussions</p>

<table class="table table-bordered">
	<tr>
		<th>Discussion Title</th>
		<th>Discussion Content</th>
		<th>Actions</th>
	</tr>
<c:forEach items="${requestScope.discussions}" var="d">
  <tr > 
  	<td>
  		<a href="${pageContext.request.contextPath}/discussion/view/${d.discussionId}">${d.discussionTopic }</a>
		
		</td>
		<td>${d.discussionContent }</td>
  	<td>
  		<a href="${pageContext.request.contextPath}/discussion/view/${d.discussionId}" class="btn btn-primary">
  			<i class="fa fa-pencil-square-o"></i>
  		</a>
  		<a class="btn btn-danger">
  			<i class="fa fa-trash-o"></i>
  		</a>
  	</td>
  </tr>
</c:forEach>
</table>
<%@ include file="../common/footer.jsp"%>