<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	
	<h1>${discussion.discussionTopic }</h1>
	${discussion.discussionContent }

	${error }
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
								<img src="${c.photo}"
									class="img-responsive" alt="" />
							</div>
							<div class="col-xs-10 col-md-11">
								<div>
									<div class="mic-info">
										By: ${c.firstName } ${c.lastName} on ${c.commentDate}
									</div>
								</div>
								<div class="comment-text">${c.comment}</div>
								<div class="action">
									<a href="${pageContext.request.contextPath}/discussion/deleteComment/${c.commentId}"
										class="btn btn-danger pull-right"> <i class="fa fa-trash-o"></i>
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
					<a class="btn btn-primary pull-right" id="addComment">Add
						Comment</a>
					<a class="pull-right" style="padding:9px" onclick="window.history.back()">Cancel</a>
				</div>
			</div>
		</div>
	</div>

</div>




<script type="text/javascript">
	$(document).ready(function() {
		$("#addComment").click(addComment);


	});

	function addComment() {
		var comment = $("#comment").val();
		if (comment === "undefined" || comment === "") {
			$("#error").html("Please add comment");
			return;
		}
		var obj = {
			discussionId : "${discussion.discussionId}",
			comment : comment
		};
		console.log(obj);
		$.post("${baseURL}/discussion/comment", obj,
				onresult);
	};

	function onresult(result) {
		console.log(result);
		if (result.result === "fail") {
			$("#error").html(result.message);
		} else if (result.result === "success") {
			window.location.reload();
		}
	}
</script>

<%@ include file="../common/footer.jsp"%>