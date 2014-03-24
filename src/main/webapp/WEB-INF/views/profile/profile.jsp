<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/userprofile/save" method="post">
	<input type="hidden" name="userId" value="${user.userId}">
	<input type="hidden" name="fromAdmin" value="${fromAdmin}">
	<input type="hidden" id="photo" name="photo" value="${user.photo}">
  <div class="form-group">
    <h1>Update Profile</h1>
    <hr>	
  <div class="form-group">
    <label for="title" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="fname" placeholder="First Name" value="${user.firstName}" name="firstName" required="true">
    </div>
  </div>
  <div class="form-group">
    <label for="description" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="lname" placeholder="Last Name" value="${user.lastName}" name="lastName" required="true">
    </div>
  </div>
  <div class="form-group">
    <label for="location_name" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-4">
      <input type="email" class="form-control" id="email" placeholder="Email" value="${user.email}" name="email" required="true">
    </div>
  </div>
  
  <c:if test="${loggedInUser.role.toString().equals(\"ADMIN\")}">
	  <div class="form-group">
	    <label for="description" class="col-sm-2 control-label">Enabled</label>
	    <div class="col-sm-4">
	        <c:choose>
	        	<c:when test="${user.enabled}">
	        		<input type="radio" value="Y" name="userenabled" checked> Yes
      				<input type="radio" value="N" name="userenabled"> No
	        	</c:when>
	        	<c:otherwise>
					<input type="radio" value="Y" name="userenabled"> Yes
					<input type="radio" value="N" name="userenabled" checked> No
	        	</c:otherwise>
	        </c:choose>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="location_name" class="col-sm-2 control-label">Role</label>
	    <div class="col-sm-4">
	        <c:choose>
	        	<c:when test="${user.role.toString().equals(\"USER\")}">
			      <input type="radio" value="0" name="userrole" checked> User
			      <input type="radio" value="2" name="userrole"> Manager
	        	</c:when>
	        	<c:otherwise>
			      <input type="radio" value="0" name="userrole"> User
			      <input type="radio" value="2" name="userrole" checked> Manager
	        	</c:otherwise>
	        </c:choose>
	    </div>
	  </div>  	
  </c:if>
  
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">About</label>
    <div class="col-sm-4">
      <textarea class="form-control" id="about" placeholder="About" name="about">${user.about}</textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">Address</label>
    <div class="col-sm-4">
      <textarea class="form-control" id="address" placeholder="Address" name="address">${user.address}</textarea>
    </div>
  </div>  
  <div class="form-group">
    <label for="city" class="col-sm-2 control-label">City</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="city" placeholder="City" value="${user.city}" name="city">
    </div>
  </div>
  <div class="form-group">
    <label for="state" class="col-sm-2 control-label">State/Province</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="state" placeholder="State/Province" value="${user.provience}" name="provience">
    </div>
  </div>
  <div class="form-group">
    <label for="country" class="col-sm-2 control-label">Country</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="country" placeholder="Country" value="${user.country}" name="country">
    </div>
  </div>
  <div class="form-group">
    <label for="map" class="col-sm-2 control-label">Photo</label>
    <div class="col-sm-4">
      <img id="profilepic" alt="" src="${user.photo}" width="200">
      <input id="fileupload" type="file" name="file" data-url="${pageContext.request.contextPath}/upload/do" single>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-6">
      <button class="btn btn-success" id="btnSuccess"><i class="fa fa-floppy-o"></i> Save</button>
    </div>
  </div>
</form>
</div>
</div>

<script>
	$(function() {
		$('#fileupload').fileupload({
			dataType : 'json',
			done : function(e, data) {
				console.log(data.result);
				$("#profilepic").attr("src", '${pageContext.request.contextPath}/upload/fetch/' + data.result.id);
				$("#photo").val('http://localhost:8080${pageContext.request.contextPath}/upload/fetch/'+data.result.id);
			}
		});
	});
</script>

<%@ include file="../common/footer.jsp"%>