<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
    		<img class="profileimg" src="${loggedInUser.photo}" width="190px" /> 
    		<hr /> 	
          <ul class="nav nav-sidebar">
            <li class="${dashboardActive }"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="${groupActive }"><a href="${pageContext.request.contextPath}/group/list">My Groups</a></li>
            <li class="${discussionActive }"><a href="${pageContext.request.contextPath}/discussion/list">My Discussions</a></li>
            <li class="${docsActive }"><a href="${pageContext.request.contextPath}/docs/list">My Docs</a></li>
            <li class="${profileActive }"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
			<c:if test="${loggedInUser.role.toString().equals(\"ADMIN\")}">
	  			<li class="${userActive}"><a id="btnUsers" href="${pageContext.request.contextPath}/user">Users</a></li>
	  		</c:if>            
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
          </ul>
        </div>