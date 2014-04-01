<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1 class="page-header">
		Group Documents <span class="pull-right">
		<a
			href="${pageContext.request.contextPath}/group/view/${groupId}">

				<button type="button" class="btn btn-info">
					<i class="fa fa-arrow-circle-left"></i> Back
				</button>
		</a> 
		<c:if test="${hasAccess == 'true'}">
			<a href="upload"><button type="button" class="btn btn-success ">
					<i class="fa fa-cloud-upload"> </i> Upload
				</button> 
			</a>
		</c:if>
		</span>
	</h1>
	<br>
	<c:if test="${hasAccess == 'true'}">
	<c:forEach var="document" items="${documents}">

		<div class="col-md-4">
			<div class="thumbnail">
				<br />
				<c:choose>
					<c:when test="${document.upload.fileType=='.doc'}">
						<img src="/cencolshare/resources/images/word.jpg"
							class="media-object">
					</c:when>
					<c:when test="${document.upload.fileType=='.pdf'}">
						<img src="/cencolshare/resources/images/pdf.jpg"
							class="media-object">
					</c:when>
					<c:when test="${document.upload.fileType=='.ppt'}">
						<img src="/cencolshare/resources/images/ppt.png"
							class="media-object">
					</c:when>
					<c:when test="${document.upload.fileType=='.xlsx'}">
						<img src="/cencolshare/resources/images/excel.png"
							class="media-object">
					</c:when>
					<c:otherwise>
						<img src="/cencolshare/resources/images/doc.jpg"
							class="media-object">
					</c:otherwise>
				</c:choose>
				<div class="caption">

					<h3>${document.documentTitle}</h3>
					<p>${document.documentDescription}</p>
					<p class="text-muted">Size: ${document.upload.fileSize} Format:
						${document.upload.fileType }</p>
					<p>
					<p class="text-muted">Uploaded by: ${document.user.firstName}
						${document.user.lastName}</p>
					<a
						href="${pageContext.request.contextPath}/docs/view/${document.documentId}">Preview</a>
					| <a href="${document.fileUrl}">Download</a> |
					<!--<a href="${pageContext.request.contextPath}/docs/delete/${document.documentId}">Delete</a> |
							<a href="${pageContext.request.contextPath}/docs/edit/${document.documentId}"> Edit</a>-->
					</p>
				</div>
			</div>
		</div>
	</c:forEach>

	</c:if>
	<c:if test="${hasAccess != 'true'}">
		<div class="well">Sorry, you dont have access to view documents of this group. Please join the group first.</div>
		<a onclick="window.history.back()">Go Back</a>
	</c:if>

</div>
</div>
<script type="text/javascript">
	function equalHeight(group) {
		tallest = 0;
		group.each(function() {
			thisHeight = $(this).height();
			if (thisHeight > tallest) {
				tallest = thisHeight;
			}
		});
		group.each(function() {
			$(this).height(tallest);
		});
	}

	$(document).ready(function() {
		equalHeight($(".thumbnail"));
	});
</script>
<%@ include file="../common/footer.jsp"%>