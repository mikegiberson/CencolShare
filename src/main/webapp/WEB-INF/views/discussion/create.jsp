<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1>Create New Discussion</h1>
	<hr class="colorgraph" />
	<div class="row">
		<c:if test="${hasAccess == 'true'}">
		<div class="col-sm-8">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/discussion/save"
				method="POST">
				<input type="hidden" name="group_id" value="${groupId}" />
				<fieldset>
					<!-- Sign Up Form -->
					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="discussionHeading">Heading:</label>
						<div class="controls">
							<input id="heading" name="discussionHeading" class="form-control"
								type="text" placeholder="Please enter a discussion topic"
								class="input-large" required>
						</div>
					</div>

					<!-- Text input-->
					<div class="control-group">
						<label class="control-label" for="userid">Content:</label>
						<div class="controls">
							<textarea class="form-control" name="discussionContents" rows="5"></textarea>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="publish"></label>
						<div class="controls">
							<button id="publish" name="publish" class="btn btn-success">Create
								Discussion</button>
							<a style="padding: 9px" onclick="window.history.back()">Cancel</a>
						</div>
					</div>
				</fieldset>
			</form>
			
		</div>
		<div class="col-sm-4">
			<div class="panel panel-info">
				  <div class="panel-heading">You should know..</div>
				  <div class="panel-body">
				    <ul>
				    	<li>This content will be visible to anyone who is a member of the group</li>
				    	<li>Content you are posting should be individual work or findings, and shouldnot be plagarized</li>
				    	<li>By clicking <span class="label label-success">Create Discussion</span> button, you agree our terms and conditions</li>
				    </ul>
				  </div>
				</div>
		</div>
		</c:if>
		<c:if test="${hasAccess == 'false'}">
			<div class="well">Sorry, you dont have access to create a discussion in this group. Please join the group first.</div>
			<a onclick="window.history.back()">Go Back</a>
		</c:if>
	</div>

</div>
<%@ include file="../common/footer.jsp"%>