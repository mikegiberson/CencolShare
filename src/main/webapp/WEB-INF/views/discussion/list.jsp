<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">Discussions</h1>

<a href="${pageContext.request.contextPath}/discussion/create" class="btn btn-success"><i class="fa fa-users"></i> Create new Discussion</a>
<br>

<p>List of discussions</p>
<c:forEach items="${requestScope.title}" var="discussion">
<li>${discussion.discussionDate }</li>
<li>${discussion.discussionTopic }</li>
</c:forEach>
</ul>
<%@ include file="../common/footer.jsp"%>