<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1 class="page-header">Create New Discussion</h1>
	<div class="tab-pane" id="signup">
		<form class="form-horizontal" action="${pageContext.request.contextPath}/discussion/save" method="POST" >
			<input type="hidden" name="group_id" value="${groupId}" />
			<fieldset>
				<!-- Sign Up Form -->
				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="discussionHeading">Heading:</label>
					<div class="controls">
						<input id="heading" name="discussionHeading" class="form-control" type="text"
							placeholder="Please enter a discussion topic" class="input-large" required>
					</div>
				</div>

				<!-- Text input-->
				<div class="control-group">
					<label class="control-label" for="userid">Content:</label>
					<div class="controls">
						<textarea class="form-control" name="discussionContents" rows="3"></textarea>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="publish"></label>
					<div class="controls">
						<button id="publish" name="publish"
							class="btn btn-success">Post Discussion</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>

</div>
<%@ include file="../common/footer.jsp"%>