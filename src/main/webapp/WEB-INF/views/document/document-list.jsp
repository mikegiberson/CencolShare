<%@ include file="..\common\header.jsp"%>
<h1>Document List page</h1>
<table class="table table-striped">
<thead>
<tr>
<th width="5px">Document ID</th>
<th width="25px">Date Uploaded</th>
<th width="150px">Description</th>
<th width="50px">Title</th>
<th width="70px">File URL</th>
<th width="25px"> Tag</th>
</tr>
</thead>

<tbody>
<c:forEach var="document" items="${documentList}">
<tr>
<td>${document.documentId}</td>
<td>${document.dateUploaded}</td>
<td>${document.documentDescription}</td>
<td>${document.documentTitle}</td>
<td>${document.fileUrl}</td>
<td>${document.tag}</td>

</tr>
</c:forEach>
</tbody>


</table>
<%@ include file="..\common\footer.jsp"%>