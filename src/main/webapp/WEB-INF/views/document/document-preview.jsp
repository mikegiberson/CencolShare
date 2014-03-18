<%@ include file="..\common\header.jsp"%>
<%@ include file="..\common\sidebar.jsp"%>

<div class="col-sm-10 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<h1>Document Preview</h1>


<iframe style="display:block; border:1px solid #86B404;" width="100%" height="500"
	src="https://docs.google.com/viewer?embedded=true&url=${ docPath }"></iframe>
	
	  <br />
       <ul class="media-list">
        <li class="media">
          <a class="pull-left" href="#">
            <img class="media-object" src="/cencolshare/resources/images/pdf.jpg" alt="...">
          </a>
          <div class="media-body">
            <h4 class="media-heading">2014 Student Satisfaction and Engagement Survey</h4>
            <p>In February, many students will be asked to complete the 2014 Key Performance Indicator Student Satisfaction and Engagement Survey. Key Performance Indicators, or KPIs, are surveys that use a scale , i.e., 1 – 5 or 1 – 10, to help institutions determine how well they are delivering their services.
            <p class="text-muted">Size: 2.5MB Format: PDF</p>
            <p><a href="#">Preview</a> | <a href="#">Download</a></p>
            </p>
          </div>
        </li>
      </ul>
      <br />
</div>
<%@ include file="..\common\footer.jsp"%>