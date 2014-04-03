<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()"> 
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<sec:authorize access="isAuthenticated()"> 
	<a href="${pageContext.request.contextPath}/discussion/create"
		class="btn btn-success pull-right"> <i class="fa fa-users"></i>
		Create new Discussion
	</a>
	</sec:authorize>
	<h1>
		<b>Result:Discussions</b>
	</h1>

	<hr class="colorgraph" />
	<c:if test="${empty requestScope.discussions}">
   
   <div class="thumbnail text-info alert alert-info"><b>Sorry! No matching discussion found. </b></div>
</c:if>
<c:if test="${!empty requestScope.discussions}">
	<c:forEach items="${requestScope.discussions}" var="discussion">
		<div class="row">
			
			<div class="col-sm-10">

				<h2 class="text-primary">${discussion.discussionTopic}</h2>
				<p class="text-info">${discussion.discussionContent} </p>
				<span
					class="label label-warning"><b>Comments: ${discussion.comments.size() }</b></span>
				<span class="pull-right">
				<sec:authorize access="isAuthenticated()"> 
	<a href="${pageContext.request.contextPath}/document/edit/${grp.groupId}" class="btn btn-success">
  			<i class="fa fa-thumbs-up"> Join</i></a>
  			<a href="${pageContext.request.contextPath}/document/edit/${grp.groupId}" class="btn btn-danger">
  		<i class="fa fa-thumbs-down"> Leave</i>
  		</a>
</sec:authorize>
				
  		<a href="${pageContext.request.contextPath}/discussion/view/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> View</i>
  		</a>
			</div>

		</div>
		<hr>
	</c:forEach>
	</c:if>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>