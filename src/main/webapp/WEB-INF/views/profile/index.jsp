<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1>My Profile</h1>
	<hr class="colorgraph" />

	<div class="container">
    <div class="row">
        <div class="col-sm-2 col-md-2">
           <img
						src="${user.photo}"
						width="150" alt="${user.firstName} ${user.lastName}"
						title="${user.firstName} ${user.lastName}" class="img-responsive">
        </div>
        <div class="col-sm-4 col-md-4">
            <blockquote>
                <h2 class="text text-primary">${user.firstName} ${user.lastName}</h2> <medium class="text text-info"><cite title="Source Title">${user.city}, ${user.provience} (${user.country})  <i class="fa fa-map-marker"></i></cite></medium>
            </blockquote>
            <h3 class="text text-info"> <i class="fa fa-envelope-o"></i>  ${user.email}
                <br
                /> <br /><i class="fa fa-suitcase"></i> ${user.occupation}, ${user.organization}
                <br /><br /> <i class="fa fa-plus"></i> Joined on ${user.dateJoined}
                <br/><br />
                <i class="fa fa-adn"></i> ${user.about}</h3>
                <br/><br /> <a  class="btn btn-warning" href="${pageContext.request.contextPath}/profile/edit">Edit
								profile</a>
								
								<a class="btn btn-primary" href="${pageContext.request.contextPath}/profile/changepassword">Change password</a>
        </div>
       
</div>
</div>

<%@ include file="../common/footer.jsp"%>