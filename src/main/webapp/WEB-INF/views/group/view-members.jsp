<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()"> 
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
		
	<div class="row">
			<div class="col-sm-2 text-center">
				<img class="pull-left " width="120px" height="120px" alt=""
					src="${group.groupImage}">
			</div>
			<div class="col-sm-10">

				<h2 class="text-primary">${group.groupName}</h2>
				<p class="text-info">${group.groupDescription} </p>
				<span
					class="label label-warning">Members: ${members }</span>
			
<span class="pull-right">
<sec:authorize access="isAuthenticated()"> 

	<c:if test="${not (group.user.userId ==loggedInUser.userId)}">
    <c:if test="${check=='1'}">
	<a href="${pageContext.request.contextPath}/group/add/${group.groupId}" class="btn btn-success">
  			<i class="fa fa-thumbs-up"> Join</i></a>
  			</c:if>
  			<c:if test="${check=='0'}">
  			<a href="${pageContext.request.contextPath}/group/remove/${group.groupId}" class="btn btn-danger">
  		<i class="fa fa-thumbs-down"> Leave</i>
  		</a></c:if>
  		</c:if>
</sec:authorize>

			</div>

		</div>
		<hr class="colorgraph" />
		<h2 class="text-warning">Member List</h2>	
		<hr/>
</div>
<c:forEach items="${requestScope.allMembers}" var="allMembers">
<div class="col-sm-8 col-sm-offset-4 col-md-7 col-md-offset-3 main thumbnail">
    <section class="col-xs-12 col-sm-6 col-md-12">
		<article class="search-result row">
			<div class="col-xs-12 col-sm-12 col-md-3">
			<c:if test="${empty allMembers.photo }">
			<a title="Lorem ipsum" class="thumbnail"><img height="100px" width="100px" src="http://healthcarelighthouse.com/wp-content/themes/lighthouse/img/default_user.jpg" /></a>
			</c:if>
			<c:if test="${not empty allMembers.photo }">
				<a title="Lorem ipsum" class="thumbnail"><img height="100px" width="100px" src="${allMembers.photo}" /></a>
			</c:if>
			</div>
			
			<div class="col-xs-12 col-sm-12 col-md-3 thumnail">
				
					
					<span class="pull-right">
					<h3 class="text-info">${ allMembers.firstName} ${ allMembers.lastName}</h3>
					<sec:authorize access="isAuthenticated()"> 
					<a href="${pageContext.request.contextPath}/group/member/group/${allMembers.userId}" class="btn btn-info">
  		<i class="fa fa-list-ul"> List Owned Groups</i>
  		</a>
  		</sec:authorize>
  		</span>
			
			</div>
			
			<span class="clearfix borda"></span>
		</article>	
		
	</section>
</div>
</c:forEach>


<%@ include file="..\common\footer.jsp"%>
		