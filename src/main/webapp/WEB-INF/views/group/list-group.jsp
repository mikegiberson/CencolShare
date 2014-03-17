<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<a href="${pageContext.request.contextPath}/group/create"
		class="btn btn-success pull-right"> <i class="fa fa-users"></i>
		Create new Group
	</a>
	<h1>
		<b>Group</b>
	</h1>

	<hr class="colorgraph" />
	<c:forEach items="${requestScope.groups}" var="grp">
		<div class="row">
			<div class="col-sm-2 text-center">
				<img class="pull-left " width="120px" height="120px" alt=""
					src="${grp.groupImage}">
			</div>
			<div class="col-sm-10">

				<h2 class="text-primary">${grp.groupName}</h2>
				<p class="text-info">${grp.groupDescription} </p>
				<span
					class="label label-warning">Members:1222</span>
				<span class="pull-right"> <a
					href="${pageContext.request.contextPath}/group/edit/${grp.groupId}"
					class="btn btn-primary"> <i class="fa fa-pencil-square-o"></i>
				</a> <a
					href="${pageContext.request.contextPath}/group/delete/${grp.groupId}"
					class="btn btn-danger"> <i class="fa fa-trash-o"></i>
				</a>
			</div>

		</div>
		<hr>
	</c:forEach>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>