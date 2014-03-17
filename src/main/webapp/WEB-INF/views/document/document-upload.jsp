<%@ include file="..\common\header.jsp"%>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Upload Document </legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="docNameTxt">Document Name</label>  
  <div class="col-md-4">
  <input id="docNameTxt" name="docNameTxt" type="text" placeholder="name" class="form-control input-md">
    
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="docDesTxt">Document Description</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="docDesTxt" name="docDesTxt"></textarea>
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
  <input class="form-control" type="text" >
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
    <button id="uploadBtn" name="uploadBtn" class="btn btn-success">Upload <i class="fa fa-cloud-upload"></i></button>
    <button id="cancelBtn" name="cancelBtn" class="btn btn-danger">Cancel <i class="fa fa-times-circle"></i></button>
  </div>
</div>



</fieldset>
</form>


<%@ include file="..\common\footer.jsp"%>