<%@ include file="common/header.jsp"%>
<br /><br />
<div class="container well">

		<div class="row">
			<div class="span9">
				<div class="hero-unit center">
					<h3>
						${message}
					</h3>
					<br />
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur. Excepteur sint occaecat cupidatat non proident,
						sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
					<p>
						<b>Or you could just press this neat little button:</b>
					</p>
					<a href="${pageContext.request.contextPath}/login"
						class="btn btn-large btn-info"><i class="icon-home icon-white"></i>
						Proceed to Login</a>
				</div>
				<br />
			</div>
	</div>
</div>
<%@ include file="common/footer.jsp"%>