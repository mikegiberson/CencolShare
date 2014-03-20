<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>
<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1 class="page-header">
		My Docs <a href="upload">
			<button type="button" class="btn btn-success pull-right">Upload</button>
		</a>
	</h1>

	<c:forEach var="document" items="${documents}">
		<div class="row">
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
						<c:when test="${document.upload.fileType=='.xls'}">
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
						<p class="text-muted">Size: ${document.upload.fileSize} KB
							Format: ${document.upload.fileType }</p>
						<p>
							<a href="#">Preview</a> | <a href="#">Download</a> | <a
								href="${pageContext.request.contextPath}/docs/delete/${document.documentId}">Delete</a>
						</p>
					</div>
				</div>
			</div>
	</c:forEach>

	<!--      <div class="col-md-4">
                  <div class="thumbnail">
                  <br />
                  <img src="/cencolshare/resources/images/word.jpg" class="media-object">
                  <div class="caption">
                    <h3>Project Plan</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua</p>
                    <p class="text-muted">Size: 2.5MB Format: DOCX</p>
                    <p><a href="#">Preview</a> | <a href="#">Download</a></p>
                  </div>
                </div>
            </div>
            <div class="col-md-4">
                  <div class="thumbnail">
                  <br />
                  <img src="/cencolshare/resources/images/ppt.png" class="media-object">
                  <div class="caption">
                    <h3>Kick off Presentation</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua</p>
                    <p class="text-muted">Size: 1 MB Format: PPTX</p>
                    <p><a href="#">Preview</a> | <a href="#">Download</a></p>
                  </div>
                </div>
            </div>
          </div> 

           <div class="row">
            <div class="col-md-4">
                  <div class="thumbnail">
                  <br />
                  <img src="/cencolshare/resources/images/excel.png" class="media-object">
                  <div class="caption">
                    <h3>Project Cost Sheet</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua</p>
                    <p class="text-muted">Size: 2.5MB Format: XLSX</p>
                    <p><a href="#">Preview</a> | <a href="#">Download</a></p>
                  </div>
                </div>
            </div>
            <div class="col-md-4">
                  <div class="thumbnail">
                  <br />
                  <img src="/cencolshare/resources/images/ppt.png" class="media-object">
                  <div class="caption">
                    <h3>Java Presentation</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua</p>
                    <p class="text-muted">Size: 2.5MB Format: PPTX</p>
                    <p><a href="#">Preview</a> | <a href="#">Download</a></p>
                  </div>
                </div>
            </div>
            <div class="col-md-4">
                  <div class="thumbnail">
                  <br />
                  <img src="/cencolshare/resources/images/pdf.jpg" class="media-object">
                  <div class="caption">
                    <h3>Kick off Presentation</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua</p>
                    <p class="text-muted">Size: 1 MB Format: PDF</p>
                    <p><a href="#">Preview</a> | <a href="#">Download</a></p>
                  </div>
                </div>
            </div>
             -->
</div>

</div>
</div>
<%@ include file="../common/footer.jsp"%>