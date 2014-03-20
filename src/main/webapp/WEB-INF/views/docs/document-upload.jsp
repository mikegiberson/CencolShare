<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	
	<c:choose>
			<c:when test="${requestScope.document.documentId > 0}">
				<h1 class="page-header">Edit Document</h1>
			</c:when>
			<c:otherwise>
				<h1 class="page-header">Upload Document</h1>
			</c:otherwise>
		</c:choose>

	<form class="form-horizontal" role="form" method="post"
		action="${pageContext.request.contextPath}/docs/save">
		<fieldset>

			<!-- Form Name -->

			<input type="hidden" name="documentId"
				value="${requestScope.document.documentId}"> <input
				type="hidden" name="uploadId"
				value="${requestScope.upload.uploadId }">

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="docNameTxt">Document
					Name</label>
				<div class="col-md-4">
					<input required="true" id="docNameTxt" name="docNameTxt" type="text"
						placeholder="name" class="form-control input-md"
						value="${requestScope.document.documentTitle}">

				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="docDesTxt">Document
					Description</label>
				<div class="col-md-4">
					<textarea class="form-control" id="docDesTxt" name="docDesTxt"
						value="${requestScope.document.documentDescription}"></textarea>
				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="fileBtn">File
					Upload</label>
				<div class="col-md-4">
					<!--    <input id="fileBtn" name="fileBtn" class="input-file" type="file" 
					   data-url="${pageContext.request.contextPath}/upload/do" single> 
			 		<input type="file" id="fileupload"  name="file" class="input-file"
						data-url="${pageContext.request.contextPath}/upload/do" single>-->
						 <input id="fileupload" name="file" class="input-file" type="file" 
						 data-url="${pageContext.request.contextPath}/upload/do" single>
				</div>
			</div>

			<!-- Tag Cloud -->
			<div class="form-group">
				<label class="col-md-4 control-label">Tags</label>
				<div class="col-md-2">
					<div id="tag-success">
						<input class="form-control" type="text" name="tag"
							value="${requestScope.document.tag}">
						<!-- <button   class="btn"  type="button">Add <i class="fa fa-plus"></i></button>-->

						<ul id="tag-cloud">
						</ul>
					</div>
				</div>
			</div>


			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="uploadBtn"></label>
				<div class="col-md-8">
					<button id="uploadBtn" class="btn btn-success" type="submit">
					<c:choose>
					<c:when test="${requestScope.document.documentId > 0}">
				Save
			</c:when>
			<c:otherwise>
				Upload
			</c:otherwise>
		</c:choose>
						 <i class="fa fa-cloud-upload"></i>
					</button>

					<a href="${pageContext.request.contextPath}/docs/list"
						class="btn btn-danger">Cancel <i class="fa fa-times-circle"></i>
					</a>

					<!--   <a href="${pageContext.request.contextPath}/docs/list"><button id="cancelBtn" name="cancelBtn" class="btn btn-danger">Cancel 
    <i class="fa fa-times-circle"></i></button></a></div>-->
				</div>
			</div>



		</fieldset>
	</form>
	<script>
		$(function() {
			$('#fileupload').fileupload({
				dataType : 'json',
				done : function(e, data) {
					console.log(data.result);
					$("#profilepic").attr("src", data.result.filePath);
					$("#photo").val(data.result.filePath);
				}
			});
		});
	</script>

	<%@ include file="../common/footer.jsp"%>