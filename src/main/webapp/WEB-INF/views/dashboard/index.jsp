<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1>Dashboard</h1>
	<hr class="colorgraph" />
	
	<div class="well">Lorem Ipsum is simply dummy text of the
		printing and typesetting industry. Lorem Ipsum has been the industry's
		standard dummy text ever since the 1500s, when an unknown printer took
		a galley of type and scrambled it to make a type specimen book.</div>
		
	<div class="row">
		<div class="col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">Total Documents</div>
				<div class="panel-body">
					<h1 class="stats">${stats.documentsCount} Documents</h1>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">Total Groups Joined</div>
				<div class="panel-body">
					<h1 class="stats">${stats.groupsCount} Groups</h1>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">Total Discussions</div>
				<div class="panel-body">
					<h1 class="stats">${stats.discussionsCount} Discussions</h1>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">Groups Owned</div>
				<div class="panel-body">
					<h1 class="stats">${stats.ownedGroupsCount} Owned</h1>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">Used Space</div>
				<div class="panel-body">
					<h1 class="stats">${stats.usedSpace} / 2.0GB</h1>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-info">
				<div class="panel-heading">Favourite Groups</div>
				<div class="panel-body">
					<h1 class="stats">25 Favouries</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="well">Lorem Ipsum is simply dummy text of the
		printing and typesetting industry. Lorem Ipsum has been the industry's
		standard dummy text ever since the 1500s, when an unknown printer took
		a galley of type and scrambled it to make a type specimen book. It has
		survived not only five centuries, but also the leap into electronic
		typesetting, remaining essentially unchanged. It was popularised in
		the 1960s with the release of Letraset sheets containing Lorem Ipsum
		passages, and more recently with desktop publishing software like
		Aldus PageMaker including versions of Lorem Ipsum.</div>
	<p>
	<hr />
	</p>

</div>
</div>
<%@ include file="../common/footer.jsp"%>