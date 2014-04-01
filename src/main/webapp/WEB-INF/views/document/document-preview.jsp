<%@ include file="..\common\header.jsp"%>
<%@ include file="..\common\sidebar.jsp"%>

<div class="col-sm-10 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	<div class="row">
		<div class="col-sm-10">
			<h1>${document.documentTitle}</h1>
		</div>
		<div class="col-sm-2">
			<br />
			<a class="pull-right" style="padding: 9px" onclick="window.history.back()">Go Back</a>
		</div>
	</div>
	
	 
	<iframe style="display: block; border: 1px solid #86B404;" width="100%"
		height="500"
		src="https://docs.google.com/viewer?embedded=true&url=${ docPath }"></iframe>
		</iframe>
	<br />
	<p>${document.documentDescription}</p>
	<p class="muted">Uploaded on: ${document.dateUploaded}</p>
	 <!--
	<iframe style="display: block; border: 1px solid #86B404;" width="100%"
		height="500"
		src="https://docs.google.com/viewer?embedded=true&url=http://www.cl.cam.ac.uk/~lp15/papers/Notes/SE-I.pdf"></iframe>
		</iframe>
	-->
	<hr>
	<div class="container" style="width: 100%">
		<div class="row">
			<div class="panel panel-default widget">
				<div class="panel-heading">
					<h2 class="panel-title">
						<b>Comments</b>
					</h2>
				</div>
				<div class="panel-body">
					<c:forEach items="${comments}" var="c">
						<div class="row">
							<div class="col-xs-2 col-md-1">
								<img src="http://placehold.it/80"
									class="img-circle img-responsive" alt="" />
							</div>
							<div class="col-xs-10 col-md-11">
								<div>
									<div class="mic-info">
										By: <a href="#">${c.firstName }</a> on ${c.commentDate}
									</div>
								</div>
								<div class="comment-text">${c.comment}</div>
								<div class="action">
									<a
										href="${pageContext.request.contextPath}/discussion/deleteComment/${c.commentId}"
										class="btn btn-danger pull-right"> <i
										class="fa fa-trash-o"></i>
									</a>
								</div>
							</div>
						</div>
						<hr>
					</c:forEach>
					<span id="error"></span>
					<textarea class="form-control" name="comment" id="comment"
						placeholder="Write a comment..."></textarea>
					<br>
					<button class="btn btn-primary pull-right" id="addComment">Add
						Comment</button>
				</div>
			</div>
		</div>
	</div>
	<br />
</div>
<%@ include file="..\common\footer.jsp"%>