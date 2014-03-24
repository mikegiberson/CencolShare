<%@ include file="../common/header.jsp"%>
<div class="container">
<div class="col-sm-12">
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/profile/save" method="post">
  <div class="form-group">
    <h1>User Profile</h1>
    <hr>	
  <div class="form-group">
    <label for="title" class="col-sm-2 control-label">First Name</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.firstName}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="description" class="col-sm-2 control-label">Last Name</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.lastName}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="location_name" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.email}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">About</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.about}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">Address</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.address}</label>
    </div>
  </div>  
  <div class="form-group">
    <label for="city" class="col-sm-2 control-label">City</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.city}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="state" class="col-sm-2 control-label">State/Province</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.provience}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="country" class="col-sm-2 control-label">Country</label>
    <div class="col-sm-4">
      <label for="title" class="control-label">${user.country}</label>
    </div>
  </div>
  <div class="form-group">
    <label for="map" class="col-sm-2 control-label">Photo</label>
    <div class="col-sm-4">
      <img id="profilepic" alt="" src="${user.photo}" width="200">
    </div>
  </div>
</form>
</div>
</div>

<%@ include file="../common/footer.jsp"%>
