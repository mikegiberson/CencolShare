<%@ include file="..\common\header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">

	<div class="btn-group pull-right">
		<a href="${pageContext.request.contextPath}/group/joined"
			class="btn btn-info"> <i class="fa fa-list-ul"></i> Joined Groups
		</a> <a href="${pageContext.request.contextPath}/group/create"
			class="btn btn-success"> <i class="fa fa-users"></i> Create Group
		</a>
	</div>
	<span>
		<h1>My Groups</h1>
		<hr class="colorgraph" />
	</span>
	<c:if test="${empty requestScope.groups}">

		<div class="thumbnail text-info alert alert-info">
			<b>Sorry! You have not created any group. </b>
		</div>
	</c:if>
	<c:if test="${!empty requestScope.groups}">
		<c:forEach items="${requestScope.groups}" var="grp">
			<div class="row">

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
						href="${pageContext.request.contextPath}/group/edit/${grp.groupId}"
						class="btn btn-primary"> <i class="fa fa-pencil-square-o"></i>
					</a> 
					<!-- <a
						href="${pageContext.request.contextPath}/group/delete/${grp.groupId}"
						class="btn btn-danger"> <i class="fa fa-trash-o"></i>
					-->
					</a>
				</div>

			</div>
			<hr>
		</c:forEach>
	</c:if>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>