<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<input id="fileupload" type="file" name="file"
		data-url="${pageContext.request.contextPath}/upload/do" single>

	${discussion.discussionTopic }
	
	<hr>
	<div class="row">
		<div class="panel-body">
			<c:forEach items="${discussion.comments}" var="c">
				<div class="row">
					<div class="col-xs-2 col-md-1">
						<img src="http://placehold.it/80"
							class="img-circle img-responsive" alt="" />
					</div>
					<div class="col-xs-10 col-md-11">
						<div>
							<div class="mic-info">
								By: <a href="#">${c.user.firstName }</a> on ${c.commentDate}
							</div>
						</div>
						<div class="comment-text">${c.comment}</div>
						<div class="action">
							<button type="button" class="btn btn-danger btn-xs"
								title="Delete">
								<i class="fa fa-trash-o"></i></span> 
							</button>
						</div>
					</div>
				</div>
			</c:forEach>
			<hr>
			<span id="error"></span>
			<textarea class="form-control" name="comment" id="comment"></textarea>
			<br>
			<button class="btn btn-primary" id="addComment">Add Comment</button>
			<hr>
		</div>

	</div>
</div>




	<script type="text/javascript">
		$(document).ready(function() {
			$("#addComment").click(addComment);

			$('#fileupload').fileupload({
				dataType : 'json',
				done : function(e, data) {
					console.log(data.result);
					$("#profilepic").attr("src", data.result.filePath);
					$("#photo").val(data.result.filePath);
				}
			});

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
			$.post("http://localhost:8080/cencolshare/discussion/comment", obj,
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