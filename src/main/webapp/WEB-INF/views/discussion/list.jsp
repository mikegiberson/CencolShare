<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">

	<span>
		<h1 class="page-header">My Discussions</h1>
	</span>

	<c:if test="${empty requestScope.discussions}">

		<div class="thumbnail text-info alert alert-info">
			<b>Sorry! You have not created any discussions. </b>
		</div>
	</c:if>
	<c:if test="${!empty requestScope.dicussions}">
		<c:forEach items="${requestScope.discussions}" var="d">

			<div class="row">

				<div class="col-sm-10">
					<h2 class="text-primary">
						<a
							href="${pageContext.request.contextPath}/discussion/view/${d.discussionId}">${d.discussionTopic}</a>
					</h2>

					<p class="text-info">
						${d.discussionContent } <span class="pull-right"> <a
							href="${pageContext.request.contextPath}/discussion/delete/${d.discussionId}/fromMyDiscussions"
							class="btn btn-danger"> <i class="fa fa-trash-o"></i>
						</a>
						</span>
					</p>
				</div>
			</div>
			<hr>
		</c:forEach>
	</c:if>
</div>

<%@ include file="../common/footer.jsp"%>