<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()"> 
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	
	<h1>
		<b>Result:Documents</b>
	</h1>

	<hr class="colorgraph" />
	<c:forEach items="${requestScope.documents}" var="document">
		<div class="row">
			<div class="col-sm-2 text-center">
 			<c:if test="${document.upload.fileType =='pdf'}">
			<img class="pull-left " width="120px" height="120px" alt=""
					src="/cencolshare/resources/images/pdf.jpg">
			</c:if>
			<c:if test="${document.upload.fileType=='doc'}">
			<img class="pull-left " width="120px" height="120px" alt=""
					src="/cencolshare/resources/images/word.jpg">
			</c:if>
			<c:if test="${document.upload.fileType=='xlsx'}">
			<img class="pull-left " width="120px" height="120px" alt=""
					src="/cencolshare/resources/images/excel.jpg">
			</c:if>
			<c:if test="${document.upload.fileType=='ppt'}">
			<img class="pull-left " width="120px" height="120px" alt=""
					src="/cencolshare/resources/images/ppt.jpg">
			</c:if>
 				
			</div>
			<div class="col-sm-10">

				<h2 class="text-primary">${document.documentTitle}</h2>
				<p class="text-info">${document.documentDescription} </p>
				<span
					class="label label-warning">Size: ${document.upload.fileSize} Kb </span>
					
		<span class="pull-right">		
  		<a href="${pageContext.request.contextPath}/document/view/${document.documentId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> Open</i>
  		</a>
			</div>

		</div>
		<hr>
	</c:forEach>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>