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
		action="${pageContext.request.contextPath}/group/view/${groupId}/upload/save">

		<input type="hidden" id="fileUrl" name="fileUrl"
			value="${requestScope.document.fileUrl}">

		<fieldset>

			<!-- Form Name -->

			<input type="hidden" name="documentId"
				value="${requestScope.document.documentId}"> <input
				type="hidden" id="uploadId" name="uploadId"
				value="${requestScope.document.upload.id }">
				<input type="hidden" name="groupId"
				value="${groupId}">
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="docNameTxt">Document
					Name</label>
				<div class="col-md-4">
					<input required="true" id="documentTitle" name="documentTitle"
						type="text" placeholder="name" class="form-control input-md"
						value="${requestScope.document.documentTitle}">

				</div>
			</div>


			<div class="form-group">
				<label class="col-md-4 control-label" for="docDesTxt">Document
					Description</label>
				<div class="col-md-4">
					<textarea class="form-control" id="documentDescription"
						name="documentDescription">${requestScope.document.documentDescription}</textarea>
				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="fileBtn">File
					Upload</label>
				<div class="col-md-4">

					<input id="fileupload" type="file" name="file" data-input="true"
						data-url="${pageContext.request.contextPath}/upload/do" single>
					<div id="uploadId"></div>
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

					<a href="${pageContext.request.contextPath}/group/view/${groupId}"
						class="btn btn-danger">Cancel <i class="fa fa-times-circle"></i>
					</a>



				</div>
			</div>



		</fieldset>
	</form>
	<script>
		$(function() {
			$('#fileupload').fileupload(
					{
						
						dataType : 'json',
						done : function(e, data) {
							console.log(data.result);
							$("div#uploadId").html("<br /><span class='label label-success'>Added " + data.result.fileName + "</span>");
							

						}
					});
			//$('#fileupload').filestyle({input: true});
		});
	</script>

	<%@ include file="../common/footer.jsp"%>