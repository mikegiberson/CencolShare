<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
<form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/group/save">
  <h2>Create Group</h2>
 <input type="hidden" name="groupId" value="${requestScope.group.groupId}">
  <div class="form-group">
    <label class="col-sm-2 control-label" >Group Name</label>
    <div class="col-sm-6">
      <input required="true" type="text" class="form-control" name="groupName" value="${requestScope.group.groupName}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Group Description</label>
    <div class="col-sm-6">
      <textarea required="true" class="col-sm-2 form-control" rows="4" name="groupDescription">${requestScope.group.groupDescription}</textarea>
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" ><i class="fa fa-users"></i> Save</button>
      <a  href="${pageContext.request.contextPath}/group/list" class="btn btn-danger"><i class="fa fa-times"></i> Cancel</a>
    </div>
  </div>
</form>
</div>
<%@ include file="..\common\footer.jsp"%>