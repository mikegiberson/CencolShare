<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
          <h1 class="page-header">Upload Document</h1>

<form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/docs/save">
<fieldset>

<!-- Form Name -->

 <input type="hidden" name="groupId" value="${requestScope.document.documentId}">
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="docNameTxt">Document Name</label>  
  <div class="col-md-4">
  <input id="docNameTxt" name="docNameTxt" type="text" placeholder="name" class="form-control input-md" 
  value="${requestScope.document.documentTitle}">
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="docDesTxt">Document Description</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="docDesTxt" name="docDesTxt" 
    value="${requestScope.document.documentDescription}"></textarea>
  </div>
</div>

<!-- File Button --> 
<div class="form-group">
  <label class="col-md-4 control-label" for="fileBtn">File Upload</label>
  <div class="col-md-4">
    <input id="fileBtn" name="fileBtn" class="input-file" type="file">
  </div>
</div>

<!-- Tag Cloud -->
<div class = "form-group">
<label class="col-md-4 control-label">Tags</label>
<div class="col-md-2"  >
<div id="tag-success">
  <input class="form-control" type="text" value="${requestScope.document.tag}" >
  <button   class="btn"  type="button">Add <i class="fa fa-plus"></i></button>

<ul id="tag-cloud">
</ul>
</div>
</div>
</div>


<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="uploadBtn"></label>
  <div class="col-md-8">
    <button id="uploadBtn" class="btn btn-success" type="submit">Upload <i class="fa fa-cloud-upload"></i></button>
   
   <a href="${pageContext.request.contextPath}/docs/list"
					class="btn btn-danger">Cancel <i class="fa fa-times-circle"></i> </a>
   
   <!--   <a href="${pageContext.request.contextPath}/docs/list"><button id="cancelBtn" name="cancelBtn" class="btn btn-danger">Cancel 
    <i class="fa fa-times-circle"></i></button></a></div>-->
  </div>
</div>



</fieldset>
</form>

 <%@ include file="../common/footer.jsp"%>