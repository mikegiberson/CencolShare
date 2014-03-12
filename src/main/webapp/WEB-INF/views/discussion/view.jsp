<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
${discussion.discussionTopic }
<hr>
<span id="error"></span>
<textarea class="form-control" name="comment" id="comment"></textarea> <br>
<button class="btn btn-primary" id="addComment">Add Comment</button>
<hr>
<c:forEach items="${discussion.comments}" var="c">
<div class="row">
	${c.comment}
	${c.user.firstName }
</div>
</c:forEach>

</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#addComment").click(addComment);
});

function addComment(){
	var comment = $("#comment").val();
	if(comment==="undefined" || comment==="")
		{
			$("#error").html("Please add comment");
			return;
		}
	var obj={
			discussionId: "${discussion.discussionId}",
			comment: comment
	};
	console.log(obj);
	$.post("http://localhost:8080/cencolshare/discussion/comment", obj, onresult);
};

function onresult(result){
	console.log(result);
	if(result.result==="fail"){
		$("#error").html(result.message);
	}
	else if(result.result==="success"){
		window.location.reload();
	}
}
</script>

<%@ include file="../common/footer.jsp"%>