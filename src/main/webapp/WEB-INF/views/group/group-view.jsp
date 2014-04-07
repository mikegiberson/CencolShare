<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()">
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">

	<div class="row">
		<div class="col-sm-2 text-center">
			<img class="pull-left " width="100px" height="100px" alt=""
				src="${group.groupImage}">
		</div>
		<div class="col-sm-4">
			<h2>${group.groupName}</h2>
			<p class="text-info">${group.groupDescription}</p>
			<p>
				<span class="label label-warning">Members: ${members }</span>
			</p>
		</div>
		<div class="col-sm-6">

			<span class="pull-right"> <sec:authorize
					access="isAuthenticated()">

					<c:if test="${not (group.user.userId ==loggedInUser.userId)}">
						<c:if test="${check=='1'}">
							<a
								href="${pageContext.request.contextPath}/group/add/${group.groupId}"
								class="btn btn-success"> <i class="fa fa-thumbs-up">
									Join</i></a>
						</c:if>
						<c:if test="${check=='0'}">
							<a
								href="${pageContext.request.contextPath}/group/remove/${group.groupId}"
								class="btn btn-danger"> <i class="fa fa-thumbs-down">
									Leave</i>
							</a>
						</c:if>
					</c:if>
				</sec:authorize> <sec:authorize access="isAuthenticated()">
					<div class="btn-group">
						<a
							href="${pageContext.request.contextPath}/group/members/${group.groupId}"
							class="btn btn-info"> <i class="fa fa-list-ul"></i> Members</i>
						</a> 
						<c:if test="${hasAccess == 'true' }" >
						<a
							href="${pageContext.request.contextPath}/discussion/create/${group.groupId}"
							class="btn btn-success"> <i class="fa fa-plus-square"> Discuss</i>
						</a> 
						<a
							href="${pageContext.request.contextPath}/group/view/${group.groupId}/list"
							class="btn btn-primary"><i class="fa fa-book"></i> Documents</i>
						</a>
						</c:if>
					</div>
		</div>
		</sec:authorize>


	</div>
	<hr class="colorgraph" />

	<div>
		<div class="row">
			<div class="col-sm-8">
			
			<c:if test="${empty groupFeeds}">
			<div class="alert alert-info">Sorry! there is no discussion in this group</div>
			</c:if>

				<c:forEach var="feed" items="${groupFeeds}">
					<ul class="media-list">
						<li class="media"><a class="pull-left" href="#"> <img
								class="media-object" src="${feed.user.photo}" alt="...">
						</a>
							<div class="media-body">
								<h4 class="media-heading">
									<strong><c:out value="${feed.feedTitle}" /></strong>
								</h4>
								<span class="pull-right">
									<c:if test="${feed.deleteAccess == 'true' && feed.feedType == 'DISCUSSION'}">
										<a href="${pageContext.request.contextPath}/discussion/delete/${feed.feedId}/fromGroup">delete</a>
									</c:if>
									<c:if test="${feed.deleteAccess == 'true' && feed.feedType == 'DOCUMENT'}">
										<a href="${pageContext.request.contextPath}/docs/delete/${feed.feedId}/fromGroup" title="delete document not implemented">delete</a>
									</c:if>
								</span>
								<span class="text-muted"><c:out
										value="${feed.dateCreated}" /></span>
								<p>
									<c:out value="${fn:substring(feed.feedDescription, 0, 200)}" />...
								</p>

								<!-- comments -->
								<c:if test="${!empty feed.lastComment}">
									<ul class="media-list well">
										<li class="media"><a class="pull-left" href="#"> <img
												class="media-object" src="${feed.lastComment.user.photo}"
												style="width: 75px; height: 75px;" height="75px"
												width="75px" alt="...">
										</a>
											<div class="media-body">
												<h5 class="media-heading">
													<strong><c:out
															value="${feed.lastComment.user.firstName}" /></strong> wrote:
												</h5>
												<p>
													<c:out value="${feed.lastComment.comment}" />
												</p>
												<span class="text-muted"><c:out
														value="on ${feed.lastComment.commentDate}" /></span>
											</div></li>
									</ul>
								</c:if>
								<!-- comments -->
								<c:if test="${feed.feedType == 'DOCUMENT'}">
									<a href="${pageContext.request.contextPath}/docs/view/${feed.feedId}">Preview Document</a>
								</c:if>
								<c:if test="${feed.feedType == 'DISCUSSION'}">
									<a href="${pageContext.request.contextPath}/discussion/view/${feed.feedId}">Read More</a>
								</c:if>
							</div></li>
					</ul>
					<p>
					<hr />
					</p>
				</c:forEach>

			</div>
			<div class="col-sm-4">
				<div class="panel panel-info">
				  <div class="panel-heading">Group Info</div>
				  <div class="panel-body">
				    <p>Group Name: <br /><strong>${group.groupName}</strong></p>
				    <p>Group Owner: <br /><strong>${group.user.firstName} ${group.user.lastName}</strong></p>
				    <p>Created: <br /><strong>${group.createdDate}</strong></p>
				  </div>
				</div>
				
				<div class="panel panel-info">
				  <div class="panel-heading">Member Info</div>
				  <div class="panel-body">
				    <p>Total: <strong>${members }</strong></p>
				    <p><a href="${pageContext.request.contextPath}/group/members/${group.groupId}">View All Members</a></p>
				  </div>
				</div>
			</div>
		</div>


	</div>
</div>


<%@ include file="..\common\footer.jsp"%>
