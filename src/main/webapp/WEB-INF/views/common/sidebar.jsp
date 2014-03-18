<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="${dashboardActive }"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="${groupActive }"><a href="${pageContext.request.contextPath}/group/list">Groups</a></li>
            <li class="${discussionActive }"><a href="${pageContext.request.contextPath}/discussion/list">Discussions</a></li>
            <li class="${docsActive }"><a href="${pageContext.request.contextPath}/docs/list">My Docs</a></li>
            <li class="${profileActive }"><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
          </ul>
        </div>