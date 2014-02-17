<%@ include file="..\common\header.jsp"%>

<div class="container">
	<div class="row">
		<form class="form-horizontal">
			<fieldset>
				<!-- Address form -->

				<h2>Create Group</h2>

				<!-- Group-Name input-->
				<div class="control-group">
					<label class="control-label">Group Name</label>
					<div class="controls">
						<input id="group-name" name="Group-name" type="text"
							placeholder="Group Name" class="input-xlarge">
						<p class="help-block"></p>
					</div>
				</div>
				
				<div class="control-group">
					<label class="control-label">Group Description</label>
					<div class="controls">
						<textarea class="col-sm-2 form-control" rows="3"></textarea>
						<p class="help-block"></p>
					</div>
				</div>
				<br>
				
				<div class="control-group">
					<button type="button" class="btn btn-success"> 
					
						Create Group <i class="fa fa-users"></i> 
					</button>
					
				</div>
				
			</fieldset>
		</form>
	</div>
</div>

<%@ include file="..\common\footer.jsp"%>