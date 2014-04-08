<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<c:url value="/login" var="loginUrl"/>

<!DOCTYPE html>

<html lang=en>

<head>

<meta charset=utf-8>

<meta http-equiv=X-UA-Compatible content="IE=edge">

<meta name=viewport content="width=device-width, initial-scale=1">

<title>CencolShare</title>

<link href=images/favicon.ico rel=icon type=image/x-icon />

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" />

<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" />

<link
	href="${pageContext.request.contextPath}/resources/css/montserrat_font.css"
	rel="stylesheet" type="text/css" />

<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel=stylesheet type=text/css>

<!--[if lt IE 9]>

<script src=https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js>
</script>

<script src=https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js>
</script>

<![endif]-->

</head>

<body>

	<div id=page>

		<div class="site-navbar navbar navbar-fixed-top" role=navigation>

			<div class=container>

				<div class=navbar-header>

					<button type=button class=navbar-toggle data-toggle=collapse
						data-target=.navbar-collapse>

						<span class=sr-only> Toggle navigation </span> <span
							class=icon-bar> </span> <span class=icon-bar> </span> <span
							class=icon-bar> </span>

					</button>

					<a class=navbar-brand href=index.html> <img
						src="${pageContext.request.contextPath}/resources/images/logo.png"
						alt="Logo">
					</a>

				</div>

				<div class="navbar-collapse collapse">

					<ul class="nav navbar-nav navbar-right">

						<li class=active><a href=#main> Home </a></li>

						<li><a href=#about> About </a></li>

						<li><a href=#services> Services </a></li>

						<li><a href=#portfolio> Portfolio </a></li>

						<li><a href=#team> Team </a></li>

						<li><a href=#login> Login </a></li>

						<li><a href=#contact> Contact </a></li>

					</ul>

				</div>

			</div>

		</div>

		<main id=main class=site-main>

		<div id=carousel-example-captions class="carousel slide"
			data-ride=carousel>

			<ol class="carousel-indicators wow fadeInUp">

				<li data-target=#carousel-example-captions data-slide-to=0 class>
				</li>

				<li data-target=#carousel-example-captions data-slide-to=1 class>
				</li>

				<li data-target=#carousel-example-captions data-slide-to=2
					class=active></li>

			</ol>

			<div class=carousel-inner>

				<div class=item>

					<img class="wow pulse" data-wow-duration="3s" alt="1"
						src="${pageContext.request.contextPath}/resources/images/bg-1.jpg"
						alt="bg-1">

					<div class=carousel-caption>

						<h3 class="wow bounceInLeft" data-wow-duration=2s>File Sharing Made Simple</h3>

						<span class="wow bounceInRight" data-wow-duration=2s> Nulla
							vitae elit libero, a pharetra augue mollis interdum. </span>

					</div>

				</div>

				<div class=item>

					<img class="wow pulse" data-wow-duration="3s" alt="2"
						src="${pageContext.request.contextPath}/resources/images/bg-2.jpg"
						alt="bg-2">

					<div class=carousel-caption>

						<h3 class="wow bounceInLeft" data-wow-duration=2s>Create groups and discussions</h3>

						<span class="wow bounceInRight" data-wow-duration=2s> Lorem
							ipsum dolor sit amet, consectetur adipiscing elit. </span>

					</div>

				</div>

				<div class="item active">

					<img class="wow pulse" data-wow-duration="3s" alt="3"
						src="${pageContext.request.contextPath}/resources/images/bg-3.jpg"
						alt=bg-3>

					<div class=carousel-caption>

						<h3 class="wow bounceInLeft" data-wow-duration=2s>Document sharing is now easy</h3>

						<span class="wow bounceInRight" data-wow-duration=2s>
							Praesent commodo cursus magna, vel scelerisque nisl consectetur.
						</span>

					</div>

				</div>

			</div>

			<a class="left carousel-control" href=#carousel-example-captions
				data-slide=prev> <span class="fa fa-chevron-left"> </span>

			</a> <a class="right carousel-control" href=#carousel-example-captions
				data-slide=next> <span class="fa fa-chevron-right"> </span>

			</a>

		</div>

		<section id=about>

			<div class=container>

				<div class=row>

					<div class=col-md-12>

						<h3>About</h3>

					</div>

					<div class="col-md-6 col-sm-6 wow bounceInLeft">

						<p>Lorem ipsum dolor sit amet, ne qui animal regione
							adversarium, ferri nonumes signiferumque qui no, errem doming
							persecuti pro at. At sit suavitate consectetuer. Ad nec vide
							tincidunt. An esse docendi his, pro eius dicta dicit id. Qui an
							ludus albucius delectus, nec in meis corpora, dolorum nusquam
							torquatos quo ex.</p>

						<p>Ad quot facilisis conceptam pro. Per omnis movet ei. Vis
							tation euismod cu, cu quod dolorem mediocritatem qui, qui
							suscipit vulputate eloquentiam in. His malis simul percipitur id.
							In nam graece nostrum deserunt, eos sonet omittam expetenda ei.
							Ei sed paulo nonumes petentium.</p>

					</div>

					<div class="col-md-6 col-sm-6 wow bounceInRight">

						<p>Mazim hendrerit at mei. Mei no nibh quaeque deserunt, ea
							veniam doctus adipisci quo. Feugiat reprehendunt ad nec. Delenit
							denique his et. Te verear accusamus pro, cum indoctum consequat
							dissentiunt ut, ex sumo labore eos. Propriae posidonium
							definitionem has te, ignota delectus apeirian te pri. Ne per
							autem periculis consequuntur.</p>

						<p class=icon-about>

							<a href=#> <i class="fa fa-weibo"> </i>
							</a> <a href=#> <i class="fa fa-facebook-square"> </i>
							</a> <a href=#> <i class="fa fa-twitter-square"> </i>
							</a> <a href=#> <i class="fa fa-google-plus-square"> </i>
							</a> <a href=#> <i class="fa fa-pinterest-square"> </i>
							</a> <a href=#> <i class="fa fa-linkedin"> </i>
							</a>

						</p>

					</div>

				</div>

			</div>

		</section>

		<section id=services>

			<div class=container>

				<div class=row>

					<div class=col-md-12>

						<h3>Our Services</h3>

					</div>

					<div class="col-md-4 col-sm-4 wow bounceInLeft">

						<p>
							<span> <i class="fa fa-desktop"> </i>
							</span>
						</p>

						<h4>User Interface</h4>

						<p>Lorem ipsum dolor sit amet, ne qui animal regione
							adversarium, ferri nonumes signiferumque qui no, errem doming
							persecuti pro at.</p>

					</div>

					<div class="col-md-4 col-sm-4 wow bounceInUp">

						<p>
							<span> <i class="fa fa-mobile"> </i>
							</span>
						</p>

						<h4>Mobile Aplications</h4>

						<p>Mazim hendrerit at mei. Mei no nibh quaeque deserunt, ea
							veniam doctus adipisci quo. Feugiat reprehendunt ad nec. Delenit
							denique his et.</p>

					</div>

					<div class="col-md-4 col-sm-4 wow bounceInRight">

						<p>
							<span> <i class="fa fa-thumbs-up"> </i>
							</span>
						</p>

						<h4>Corporate Branding</h4>

						<p>Mazim hendrerit at mei. Mei no nibh quaeque deserunt, ea
							veniam doctus adipisci quo. Feugiat reprehendunt ad nec. Delenit
							denique his et.</p>

					</div>

				</div>

			</div>

		</section>

		<section id=portfolio>

			<div class=container>

				<div class=row>

					<div class=col-md-12>

						<h3>Portfolio</h3>

					</div>

					<div class="col-md-4 col-sm-4 wow bounceInLeft">

						<div class=imgport data-toggle=modal data-target=#modal-login>

							<span class="wow fadeInDown"> view </span> <img
								src="${pageContext.request.contextPath}/resources/images/1.jpg"
								alt=1>

						</div>

						<h4>Portfolio 1</h4>

						<p>Published on Jan 17, 2014</p>

					</div>

					<div class="col-md-4 col-sm-4 wow bounceInUp">

						<div class=imgport data-toggle=modal data-target=#modal-login>

							<span class="wow fadeInDown"> view </span> <img
								src="${pageContext.request.contextPath}/resources/images/2.jpg"
								alt=2>

						</div>

						<h4>Portfolio 2</h4>

						<p>Published on Jan 18, 2014</p>

					</div>

					<div class="col-md-4 col-sm-4 wow bounceInRight">

						<div class=imgport data-toggle=modal data-target=#modal-login>

							<span class="wow fadeInDown"> view </span> <img
								src="${pageContext.request.contextPath}/resources/images/3.jpg"
								alt=3>

						</div>

						<h4>Portfolio 3</h4>

						<p>Published on Jan 19, 2014</p>

					</div>

				</div>

			</div>

		</section>

		<section id=team>

			<div class=container>

				<div class=row>

					<div class=col-md-12>

						<h3>Solid Team</h3>

					</div>

					<div class="col-md-3 col-sm-3 wow bounceInLeft">

						<div class=imgteam>

							<ul class="wow fadeInUp">

								<li><a href=#> <i class="fa fa-linkedin"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-facebook-square"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-twitter-square"> </i>
								</a></li>

							</ul>

							<img height="350px" width="50px"
								src="${pageContext.request.contextPath}/resources/images/Lovu.jpg"
								alt=p1>

						</div>

						<h4>Lovu Dhiraj Sharma</h4>

						<p>CEO</p>

					</div>

					<div class="col-md-3 col-sm-3 wow bounceInLeft">

						<div class=imgteam>

							<ul class="wow fadeInUp">

								<li><a href=#> <i class="fa fa-linkedin"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-facebook-square"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-twitter-square"> </i>
								</a></li>

							</ul>

							<img height="350px" width="50px"
								src="${pageContext.request.contextPath}/resources/images/Ruby.jpg"
								alt=p2>

						</div>

						<h4>Ruby Verma</h4>

						<p>Developer</p>

					</div>

					<div class="col-md-3 col-sm-3 wow bounceInRight">

						<div class=imgteam>

							<ul class="wow fadeInUp">

								<li><a href=#> <i class="fa fa-linkedin"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-facebook-square"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-twitter-square"> </i>
								</a></li>

							</ul>

							<img height="350px" width="50px"
								src="${pageContext.request.contextPath}/resources/images/Sonny.jpg"
								alt=p3>

						</div>

						<h4>Sonny K Raju</h4>

						<p>Senior Developer</p>

					</div>

					<div class="col-md-3 col-sm-3 wow bounceInRight">

						<div class=imgteam>

							<ul class="wow fadeInUp">

								<li><a href=#> <i class="fa fa-linkedin"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-facebook-square"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-twitter-square"> </i>
								</a></li>

							</ul>

							<img height="350px" width="50px"
								src="${pageContext.request.contextPath}/resources/images/p4.jpg"
								alt=p4>

						</div>

						<h4>Tram Do</h4>

						<p>Developer</p>

					</div>
					
										<div class="col-md-3 col-sm-3 wow bounceInRight">

						<div class=imgteam>

							<ul class="wow fadeInUp">

								<li><a href=#> <i class="fa fa-linkedin"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-facebook-square"> </i>
								</a></li>

								<li><a href=#> <i class="fa fa-twitter-square"> </i>
								</a></li>

							</ul>

							<img height="350px" width="50px"
								src="${pageContext.request.contextPath}/resources/images/p3.jpg"
								alt=p3>

						</div>

						<h4>Mike Giberson</h4>

						<p>Project Manager</p>

					</div>

				</div>

			</div>

		</section>

		<section id=login>

			<div class=container>
			<br /><br />
				<div class=row>

					<div class=col-md-12></div>

					<div class="col-md-6 col-sm-6 wow bounceInLeft">

						<!-- login form (start) -->
						<form action="${loginUrl}" method="post" role="form">
							<h2>
								Please sign in <small>To access your account</small>
							</h2>
							<hr />
							<div class="col-xs-12 col-sm-10 col-md-10">
								<c:if test="${param.error != null}">
									<p>Invalid username and password, or your account is
										disabled.</p>
								</c:if>
								<c:if test="${param.logout != null}">
									<p>You have been logged out.</p>
								</c:if>

								<p>
									<label for="username">Username</label> <input type="text"
										id="username" name="username" class="form-control" required="true" />
								</p>
								<p>
									<label for="password">Password</label> <input type="password"
										id="password" name="password" class="form-control" required="true"  />
								</p>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<button class="btn btn-primary" type="submit" class="btn">Log
									in</button>
								<a class="btn btn-link" data-toggle="modal"
									data-target="#forgetPasswordModal">Forgot Password</a>
							</div>
						</form>
						<!-- login form (end) -->
					</div>

					<div class="col-md-6 col-sm-6 wow bounceInRight">

						<!-- Register (start) -->

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
											class="form-control" placeholder="First Name" tabindex="1"
											required="true">
									</div>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="last_name" id="last_name"
											class="form-control" placeholder="Last Name" tabindex="2"
											required="true">
									</div>
								</div>
							</div>
							<div class="form-group">
								<input type="text" name="occupation" id="occupation"
									class="form-control"
									placeholder="Occupation (Student/Designation)" tabindex="3"
									required="true">
							</div>
							<div class="form-group">
								<input type="text" name="organization" id="organization"
									class="form-control" placeholder="Oragnization" tabindex="3"
									required="true">
							</div>
							<div class="form-group">
								<input type="email" name="email" id="email" class="form-control"
									placeholder="Email Address" tabindex="4" required="true">
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password" id="password"
											class="form-control" placeholder="Password" tabindex="5"
											required="true">
									</div>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control"
											placeholder="Confirm Password" tabindex="6" required="true">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12">
									By clicking <strong class="label label-primary">Register</strong>,
									you agree to the <a href="#" data-toggle="modal"
										data-target="#t_and_c_m">Terms and Conditions</a> set out by
									this site, including our Cookie Use.
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

						<!-- Register (end) -->

					</div>

				</div>

			</div>

		</section>

		<section id=contact>

			<div class=container>

				<div class=row>

					<div class=col-md-12>

						<h3>Contact</h3>

					</div>

				</div>

			</div>

			<div class=fluid-wrapper>

				<iframe
					src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d2880.4056037682453!2d-79.228155!3d43.785196!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89d4d0f21c3f9703%3A0xdb64a8accc26643d!2s941!5e0!3m2!1sen!2sca!4v1396838228823"
					width="600" height="350" frameborder="0" style="border: 0"></iframe>
			</div>

			<div class=container>

				<div class=row>

					<div class="col-md-4 col-sm-4 wow bounceInLeft">

						<br>

						<p class=mail>

							<i class="fa fa-map-marker"> </i> &nbsp; 941 Progress Ave, Toronto
						</p>

						<p class=mail>

							<i class="fa fa-phone-square"> </i> &nbsp; +1 647-786-2335
						</p>

					</div>

					<div class="col-md-8 col-sm-8 wow bounceInRight">

						<form role=form class=frm method=post action=contactus.php>

							<div class=col-md-6>

								<div class=form-group>

									<label for=Name> Name * </label> <input type=text
										class=form-control name=Name id=Name placeholder="Enter name">

								</div>

							</div>

							<div class=col-md-6>

								<div class=form-group>

									<label for=Email> Email * </label> <input type=email
										class=form-control Name=Email id=Email
										placeholder="Enter email">

								</div>

							</div>

							<div class=col-md-12>

								<div class=form-group>

									<label for=Message> Messages * </label>

									<textarea name=Message id=Message class=form-control rows=3
										placeholder="Enter messages">
                      </textarea>

								</div>

								<input type=submit name=submit value="Send Message"
									class="btn btn-primary btn-lg btn-block btn-biru" />

							</div>

						</form>

					</div>

				</div>

			</div>

		</section>

		</main>

		<footer>
			Copyright &copy; 2014 CencolShare <br> 

		</footer>

	</div>

	<div class="scroll-to-top affix" data-spy=affix data-offset-top=200>
		<a href=#page class=smooth-scroll> <i class="fa fa-arrow-up">
		</i>
		</a>
	</div>

	<div class="modal fade" id=modal-login tabindex=-1 role=dialog
		aria-labelledby=myModalLabel aria-hidden=true>

		<div class="modal-dialog modal-portfolio">

			<div class=modal-content>

				<button type=button class=close data-dismiss=modal aria-hidden=true>
					&times;</button>

				<div class=modal-body>

					<div id=carousel-example-generic class="carousel slide"
						data-ride=carousel>

						<ol class=carousel-indicators>

							<li data-target=#carousel-example-generic data-slide-to=0
								class=active></li>

							<li data-target=#carousel-example-generic data-slide-to=1></li>

							<li data-target=#carousel-example-generic data-slide-to=2></li>

						</ol>

						<div class=carousel-inner>

							<div class=item>

								<img
									src="${pageContext.request.contextPath}/resources/images/portfolio.jpg"
									alt=Portfolio1>

							</div>

							<div class=item>

								<img
									src="${pageContext.request.contextPath}/resources/images/portfolio2.jpg"
									alt=Portfolio2>

							</div>

							<div class="item active">

								<img
									src="${pageContext.request.contextPath}/resources/images/portfolio3.jpg"
									alt=Portfolio3>

							</div>

						</div>

						<a class="left carousel-control" href=#carousel-example-generic
							data-slide=prev> <span class="fa fa-chevron-left"> </span>

						</a> <a class="right carousel-control" href=#carousel-example-generic
							data-slide=next> <span class="fa fa-chevron-right"> </span>

						</a>

					</div>

				</div>

			</div>

		</div>

	</div>

	<script src="${pageContext.request.contextPath}/resources/js/jquery.js">
		
	</script>

	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js">
		
	</script>

	<script>
		new WOW().init();
	</script>

</body>

</html>