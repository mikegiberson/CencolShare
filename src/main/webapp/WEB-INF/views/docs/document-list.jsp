<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<!--<ul class="nav nav-pills">
  <li class="active"><a href="list">My Documents</a></li>
  <li><a href="#">My Favorites</a></li>
  <li><a href="upload">Upload</a></li>
</ul>-->
	  <h1 class="page-header">
		My Docs 
		<span class ="pull-right"><a href="favorite">
			
			<button type="button" class="btn btn-warning"><i class="fa fa-star"></i> My Favorite</button></a>
		<a href="upload"><button type="button" class="btn btn-success "><i class="fa fa-cloud-upload"> </i> Upload</button>
		</a></span>
	</h1>
<br>
	<c:forEach var="document" items="${documents}">
		
			<div class="col-md-4">
				<div class="thumbnail" >
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