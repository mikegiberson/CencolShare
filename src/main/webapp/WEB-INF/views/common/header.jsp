<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Dashboard - CencolShare</title>

    <!-- Bootstrap core CSS -->
	<link href="/cencolshare/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="/cencolshare/resources/css/dashboard.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.ui.widget.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.iframe-transport.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>    

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">CENCOLSHARE</a>
        </div>
        
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="/cencolshare/dashboard">Dashboard</a></li>
            <li><a href="/cencolshare/profile">My Profile</a></li>
            <li><a href="#">Notifications</a></li>
            <sec:authorize access="isAnonymous()">
		    	<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
		    	<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
			</sec:authorize>
            </li>
          </ul>
          <form class="navbar-form navbar-right" method="get" action="${pageContext.request.contextPath}/search">
          <select class="form-control" name="searchType">
	  	      <option value="group">Group</option>
	 		  <option value="document">Document</option>
			  <option value="discussion">Discussion</option>		 
			</select>
            <input type="text" name ="searchInput" class="form-control" placeholder="Search...">
            <button class="btn btn-danger"><i class="fa fa-search"></i> </button>
          </form>
        </div>
      </div>
    </div>
    
