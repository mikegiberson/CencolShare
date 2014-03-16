<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<h1 class="page-header">Document</h1>
<br>
<br>
<table class="table table-bordered">
	<tr>
		<th class="text-center text-danger">Document Name</th>
		<th class="text-center text-danger">Document Description</th>
		<th class="text-center text-danger">Action</th>
	</tr>
<c:forEach items="${requestScope.documents}" var="document">
  <tr > 
  	<td class="col-sm-2 text-info"><b>${document.documentTitle}</b></td>
  	<td class="text-info">${document.documentDescription}</td>
  	<td class="col-sm-2 text-center">
  		
  		<a href="${pageContext.request.contextPath}/document/view/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> View</i>
  		</a>
  		</td>
  </tr>
</c:forEach>
</table>
</div>

<%@ include file="..\common\footer.jsp"%>