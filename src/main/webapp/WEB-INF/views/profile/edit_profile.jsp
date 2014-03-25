<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
          <h1 class="page-header">My Profile</h1>
            
           <form class="form-horizontal col-sm-10" role="form" method="post" action="${pageContext.request.contextPath}/profile/save"> 
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-4 control-label">First Name</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" name="first_name" value="${user.firstName}" placeholder="Enter your first name">
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-4 control-label">Last Name</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" name="last_name" value="${user.lastName}" placeholder="Enter your last name">
              </div>
            </div>  
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-4 control-label">Occupation</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" value="${user.occupation}" name="occupation" placeholder="Enter occupation">
              </div>
            </div>  
             <div class="form-group">
              <label for="inputPassword3" class="col-sm-4 control-label">Organization</label>
              <div class="col-sm-6">
                <input type="text" class="form-control" value="${user.organization}" name="organization" placeholder="Enter organization">
              </div>
            </div>  
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-4 control-label">Email</label>
              <div class="col-sm-6">
                ${user.email}
              </div>
            </div>  
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-4 control-label">Date Joined</label>
              <div class="col-sm-6">
                ${user.dateJoined}
              </div>
            </div>  
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-4 control-label">Documents</label>
              <div class="col-sm-6">
                26 <a href="docs">View All</a>
              </div>
            </div>  
            <div class="form-group">
              <span class="col-sm-4 control-label"></span>
              <div class="col-sm-6">
                <button type="submit" class="btn btn-success">Save Changes</button>
                <a href="${pageContext.request.contextPath}/profile" class="btn btn-default">Cancel</a> 
              </div>
            </div>
          </form>

      </div>
 
    
 <%@ include file="../common/footer.jsp"%>