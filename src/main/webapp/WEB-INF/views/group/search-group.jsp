<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">Group</h1>
<br>
<br>
<table class="table table-bordered">
	<tr>
		<th>Group Name</th>
		<th>Group Description</th>
	</tr>
<c:forEach items="${requestScope.groups}" var="grp">
  <tr > 
  	<td>${grp.groupName}</td>
  	<td>${grp.groupDescription}</td>
  	
  </tr>
</c:forEach>
</table>
</div>

<%@ include file="..\common\footer.jsp"%>