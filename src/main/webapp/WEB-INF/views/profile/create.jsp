<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/save" method="post">
	<input type="hidden" id="photo" name="photo">
  <div class="form-group">
    <h1>Create User</h1>
    <hr>	
  <div class="form-group">
    <label for="title" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="fname" placeholder="First Name" name="firstName" required="true">
    </div>
  </div>
  <div class="form-group">
    <label for="description" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="lname" placeholder="Last Name" name="lastName" required="true">
    </div>
  </div>
  <div class="form-group">
    <label for="location_name" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-4">
      <input type="email" class="form-control" id="email" placeholder="Email" name="email" required="true">
    </div>
  </div>
  
   <div class="form-group">
    <label for="location_name" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-4">
      <input type="password" class="form-control" id="password" placeholder="Password" name="password" required="true">
    </div>
  </div>
  
  <c:if test="${loggedInUser.role.toString().equals(\"ADMIN\")}">
	  <div class="form-group">
	    <label for="description" class="col-sm-2 control-label">Enabled</label>
	    <div class="col-sm-4">
       		<input type="radio" value="Y" name="userenabled" checked> Yes
			<input type="radio" value="N" name="userenabled"> No
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="location_name" class="col-sm-2 control-label">Role</label>
	    <div class="col-sm-4">
	      <input type="radio" value="0" name="userrole" checked> User
	      <input type="radio" value="2" name="userrole"> Manager
	    </div>
	  </div>  	
  </c:if>
  
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">About</label>
    <div class="col-sm-4">
      <textarea class="form-control" id="about" placeholder="About" name="about"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">Address</label>
    <div class="col-sm-4">
      <textarea class="form-control" id="address" placeholder="Address" name="address"></textarea>
    </div>
  </div>  
  <div class="form-group">
    <label for="city" class="col-sm-2 control-label">City</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="city" placeholder="City" name="city">
    </div>
  </div>
  <div class="form-group">
    <label for="state" class="col-sm-2 control-label">State/Province</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="state" placeholder="State/Province" name="provience">
    </div>
  </div>
  <div class="form-group">
    <label for="country" class="col-sm-2 control-label">Country</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="country" placeholder="Country" name="country">
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
      <a href="${pageContext.request.contextPath}/user"
					class="btn btn-default">Cancel</a>
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
				$("#photo").val('${baseURL}/upload/fetch/'+data.result.id);
			}
		});
	});
</script>

<%@ include file="../common/footer.jsp"%>