<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">Discussion</h1>
<br>
<br>
<table class="table table-bordered">
	<tr>
		<th class="text-center text-danger">Discussion Name</th>
		<th class="text-center text-danger">Discussion Description</th>
		<th class="text-center text-danger">Action</th>
	</tr>
<c:forEach items="${requestScope.discussions}" var="discussion">
  <tr > 
  	<td class="col-sm-2 text-info"><b>${discussion.discussionTopic}</b></td>
  	<td class="text-info">${discussion.discussionContent}</td>
  	<td class="col-sm-2 text-center">
  		
  		<a href="${pageContext.request.contextPath}/discussion/view/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> View</i>
  		</a>
  		</td>
  </tr>
</c:forEach>
</table>
</div>

<%@ include file="..\common\footer.jsp"%>