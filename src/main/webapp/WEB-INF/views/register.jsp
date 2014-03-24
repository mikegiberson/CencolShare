<%@ include file="common/header.jsp"%>
<div class="container">

	<div class="row">
		<div
			class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<c:if test="${errors != null}">
				<div class="alert alert-danger">${errors}</div>
			</c:if>

			<form role="form" method="post"
				action="${pageContext.request.contextPath}/create">
				<h2>
					Please Sign Up <small>It's free and always will be.</small>
				</h2>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="text" name="first_name" id="first_name"
								class="form-control input-lg" placeholder="First Name"
								tabindex="1" required="true">
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="text" name="last_name" id="last_name"
								class="form-control input-lg" placeholder="Last Name"
								tabindex="2" required="true">
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" name="occupation" id="occupation"
						class="form-control input-lg" placeholder="Occupation (Student/Designation)"
						tabindex="3" required="true">
				</div>
				<div class="form-group">
					<input type="text" name="organization" id="organization"
						class="form-control input-lg" placeholder="Oragnization"
						tabindex="3" required="true">
				</div>
				<div class="form-group">
					<input type="email" name="email" id="email"
						class="form-control input-lg" placeholder="Email Address"
						tabindex="4" required="true">
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-lg" placeholder="Password"
								tabindex="5" required="true">
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<input type="password" name="password_confirmation"
								id="password_confirmation" class="form-control input-lg"
								placeholder="Confirm Password" tabindex="6" required="true">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12">
						By clicking <strong class="label label-primary">Register</strong>,
						you agree to the <a href="#" data-toggle="modal"
							data-target="#t_and_c_m">Terms and Conditions</a> set out by this
						site, including our Cookie Use.
					</div>
				</div>

				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-12 col-md-6 col-sm-offset-3">
						<input type="submit" value="Register"
							class="btn btn-primary btn-block btn-lg" tabindex="7">
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Modal -->
</div>
<%@ include file="common/footer.jsp"%>