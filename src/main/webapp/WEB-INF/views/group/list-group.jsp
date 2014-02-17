<%@ include file="..\common\header.jsp"%>

<ul>
<c:forEach items="${requestScope.groups}" var="grp">
   <li>${grp.groupName}</li>
</c:forEach>
</ul>

<%@ include file="..\common\footer.jsp"%>