<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()">
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">

	<h1>
		<b>Result:Documents</b>
	</h1>

	<hr class="colorgraph" />
	<c:if test="${empty requestScope.documents}">
   
   <div class="thumbnail text-info alert alert-info"><b>Sorry! No matching document found. </b></div>
</c:if>
<c:if test="${!empty requestScope.documents}">
	<c:forEach items="${requestScope.documents}" var="document">
		<div class="row">
			<div class="col-sm-2 text-center">
				<c:choose>
						<c:when test="${fn:contains(document.upload.fileType, '.doc')}">
							<img src="${pageContext.request.contextPath}/resources/images/word.jpg"
								class="media-object">
						</c:when>
						<c:when test="${document.upload.fileType=='.pdf'}">
							<img src="${pageContext.request.contextPath}/resources/images/pdf.jpg"
								class="media-object">
						</c:when>
						<c:when test="${fn:contains(document.upload.fileType, '.ppt')}">
							<img src="${pageContext.request.contextPath}/resources/images/ppt.png"
								class="media-object">
						</c:when>
						<c:when test="${fn:contains(document.upload.fileType, '.xls')}">
							<img src="${pageContext.request.contextPath}/resources/images/excel.png"
								class="media-object">
						</c:when>
						<c:otherwise>
							<img src="${pageContext.request.contextPath}/resources/images/doc.jpg"
								class="media-object">
						</c:otherwise>
					</c:choose>

			</div>
			<div class="col-sm-10">

				<h2 class="text-primary">${document.documentTitle}</h2>
				<p class="text-info">${document.documentDescription}</p>
				<span class="label label-warning">Size:
					${document.upload.fileSize} </span> &nbsp <span
					class="label label-warning"> Format:
					${document.upload.fileType} </span> <span class="pull-right"> <a
					href="${pageContext.request.contextPath}/docs/view/${document.documentId}"
					class="btn btn-primary"> <i class="fa fa-arrow-circle-right">
							Open</i>
				</a>
			</div>

		</div>
		<hr>
	</c:forEach>
	</c:if>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>