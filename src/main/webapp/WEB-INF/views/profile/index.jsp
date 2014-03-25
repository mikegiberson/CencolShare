<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1 class="page-header">My Profile</h1>

	<div class="container">
		<div class="row">
			<div class="col-sm-offset-2 col-sm-4 col-md-4 user-details">
				<div class="user-image">
					<img
						src="${pageContext.request.contextPath}/resources/images/default.png"
						width="100" height="100" alt="${user.firstName} ${user.lastName}"
						title="${user.firstName} ${user.lastName}" class="img-circle">
				</div>
				<div class="user-info-block">
					<div class="user-heading">
						<h3>${user.firstName}${user.lastName}</h3>
						<span class="help-block">Toronto, Canada</span>
					</div>
					<div class="user-heading">
						<p>
							<span class="glyphicon glyphicon-envelope"></span> ${user.email}</span>
						</p>
						<p>
							<span class="glyphicon glyphicon-envelope"></span> ${user.occupation}</span>
						</p>
						<p>
							<span class="glyphicon glyphicon-briefcase"></span> ${user.organization}</span>
						</p>
						<p>
							<span class="glyphicon glyphicon-time"></span> Joined on
							${user.dateJoined}</span>
						</p>
						<p>
							<a href="${pageContext.request.contextPath}/profile/edit">Edit
								profile</a>
						</p>
						
						<a href="${pageContext.request.contextPath}/profile/changepassword">Change password</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jsp"%>