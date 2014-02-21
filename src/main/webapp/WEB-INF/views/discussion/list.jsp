<%@ include file="../common/header.jsp"%>

<p>List of discussions</p>
	<ul>
		<li>Discussion 1</li>
		<li>Discussion 2</li>
		<li>Discussion 3</li>
		<li>Discussion 4</li>
		<li>Discussion 5</li>
	</ul>
<ul>
<c:forEach items="${requestScope.title}" var="discussion">
<li>${discussion.discussionDate }</li>
<li>${discussion.discussionTopic }</li>
</c:forEach>
</ul>
<%@ include file="../common/footer.jsp"%>