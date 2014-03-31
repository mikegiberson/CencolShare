<%@ include file="..\common\header.jsp"%>
<%@ include file="..\common\sidebar.jsp"%>

<div class="col-sm-10 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1>Document Preview</h1>

	 
	<iframe style="display: block; border: 1px solid #86B404;" width="100%"
		height="500"
		src="https://docs.google.com/viewer?embedded=true&url=${ docPath }"></iframe>
		></iframe>
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
	<ul class="media-list">
		<li class="media"><a class="pull-left" href="#"> <img
				class="media-object" src="/cencolshare/resources/images/pdf.jpg"
				alt="...">
		</a>
			<div class="media-body">
				<h4 class="media-heading">2014 Student Satisfaction and
					Engagement Survey</h4>
				<p>In February, many students will be asked to complete the 2014
					Key Performance Indicator Student Satisfaction and Engagement
					Survey. Key Performance Indicators, or KPIs, are surveys that use a
					scale , i.e., 1 – 5 or 1 – 10, to help institutions determine
					how well they are delivering their services.
				<p class="text-muted">Size: 2.5MB Format: PDF</p>
				<p>
					<a href="#">Preview</a> | <a href="#">Download</a>
				</p>
				</p>
			</div></li>
	</ul>
	<br />
</div>
<%@ include file="..\common\footer.jsp"%>