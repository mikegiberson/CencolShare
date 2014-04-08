<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<!--<ul class="nav nav-pills">
  <li class="active"><a href="list">My Documents</a></li>
  <li><a href="#">My Favorites</a></li>
  <li><a href="upload">Upload</a></li>
</ul>-->
	  <h1>
		My Docs 

		<span class ="pull-right"><a href="favorite">
			
			<button type="button" class="btn btn-warning"><i class="fa fa-star"></i> My Favorite</button></a>
		<a href="upload"><button type="button" class="btn btn-success "><i class="fa fa-cloud-upload"> </i> Upload</button>
		</a></span>
	</h1>
	<hr class="colorgraph" />
<br>

<c:if test="${empty requestScope.documents}">

		<div class="thumbnail text-info alert alert-info">
			<b>Sorry! You have not uploaded any document. </b>
		</div>
	</c:if>
	<c:forEach var="document" items="${documents}">
		
			<div class="col-md-4">
				<div class="thumbnail" >
					<br />
					<a href="${pageContext.request.contextPath}/docs/view/${document.documentId}">
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
					</a>
					<div class="caption">
						<div class="row-fluid">
						<a href="${pageContext.request.contextPath}/docs/view/${document.documentId}"><h3>${document.documentTitle}</h3></a>
						</div>
						<!-- <p>${document.documentDescription}</p> -->
						<p class="text-muted">Size: ${document.upload.fileSize} 
							Format: ${document.upload.fileType }</p>
						<p>
							<a href="${pageContext.request.contextPath}/docs/view/${document.documentId}">Preview</a> | 
							<a href="${document.fileUrl}">Download</a> | 
							<a href="${pageContext.request.contextPath}/docs/delete/${document.documentId}/fromMyDocs">Delete</a> |
							<a href="${pageContext.request.contextPath}/docs/edit/${document.documentId}"> Edit</a>
						</p>
					</div>
				</div>
			</div>
	</c:forEach>
	


</div>
</div>
<script type="text/javascript">
function equalHeight(group) {    
    tallest = 0;    
    group.each(function() {       
        thisHeight = $(this).height();       
        if(thisHeight > tallest) {          
            tallest = thisHeight;       
        }    
    });    
    group.each(function() { $(this).height(tallest); });
} 

$(document).ready(function() {   
    equalHeight($(".thumbnail")); 
});
</script>
<%@ include file="../common/footer.jsp"%>