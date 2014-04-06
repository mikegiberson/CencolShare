<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">My Discussions</h1>

<br>
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
  	  		<a href="${pageContext.request.contextPath}/discussion/delete/${d.discussionId}/fromMyDiscussions" class="btn btn-danger">
  			<i class="fa fa-trash-o"></i>
  		</a>
  	</td>
  </tr>
</c:forEach>
</table>

<%@ include file="../common/footer.jsp"%>