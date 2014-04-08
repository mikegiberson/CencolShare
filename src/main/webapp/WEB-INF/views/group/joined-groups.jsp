<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">


	<span>
		<h1>Joined Groups</h1>
		<hr class="colorgraph" />
	</span>
<c:if test="${empty requestScope.joinedgroups}">
   
   <div class="thumbnail text-info alert alert-info"><b>Sorry! You have not joined any group. </b></div>
</c:if>
<c:if test="${!empty requestScope.joinedgroups}">
	<c:forEach items="${requestScope.joinedgroups}" var="grp">
		<div class="row ">

			<div class="col-sm-2 text-center">
				<a
					href="${pageContext.request.contextPath}/group/view/${grp.groupId}"><img
					class="pull-left " width="120px" height="120px" alt=""
					src="${grp.groupImage}"></a>
			</div>
			<div class="col-sm-10">

				<h2 class="text-primary">
					<a
						href="${pageContext.request.contextPath}/group/view/${grp.groupId}">${grp.groupName}</a>
				</h2>
				<p class="text-info">${grp.groupDescription}</p>
				<span class="label label-warning">Members: ${grp.member}</span> <span
					class="pull-right"> <a
					href="${pageContext.request.contextPath}/group/remove/${grp.groupId}?fromJoined=true"
					class="btn btn-danger"> <i class="fa fa-thumbs-down"> Leave</i>
				</a>&nbsp <a href="${pageContext.request.contextPath}/group/view/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> View</i>
  		</a>
			</div>

		</div>
		<hr>
	</c:forEach>
	</c:if>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>