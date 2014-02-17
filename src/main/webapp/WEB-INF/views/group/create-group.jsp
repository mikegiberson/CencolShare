<%@ include file="..\common\header.jsp"%>

<form class="col-sm-8 form-horizontal" role="form">
  <h2>Create Group</h2>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Group Name</label>
    <div class="col-sm-6">
      <input type="email" class="form-control" id="inputEmail3">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Group Description</label>
    <div class="col-sm-6">
      <textarea class="col-sm-2 form-control" rows="3"></textarea>
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success">Save <i class="fa fa-users"></i></button>
      <a  href="${pageContext.request.contextPath}/group/list" class="btn btn-danger">Cancel <i class="fa fa-caret-left"></i></a>
    </div>
  </div>
</form>

<%@ include file="..\common\footer.jsp"%>