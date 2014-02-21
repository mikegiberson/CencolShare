/**
 * Author - Shalin Banjara 
 * Usage - All the jQuery and Ajax function for generating dynamic combo boxes based on user selections
 */

$(document).ready(function() {
	$("#campusCombo").change(function() {
		var campusId = $(this).val();
		var post_url = "/Scheduler/department/getDepartmentCombo/" + campusId;
		if (campusId != null) {
			$.ajax({
				type : "GET",
				url : post_url,
				success : function(result) {
					$("#departmentComboDiv").html(result);
				},
				error : function(xhr, status, error) {
					$("#departmentComboDiv").html(status);
				}
			});
		}
		$("#campusCombo").attr('disabled', 'disabled');
		$("#datepicker").attr('disabled', 'disabled');
		event.preventDefault();
		return false;
	});

	/*
	 * Author - Ruby Verma 
	 * Usage - validating duplicate campus on button click
	 */
	$("#btnSave").click(function() {
		if($('#campusName').val() === "") {
			 alert("Please enter campus name");
			 return;
			}
		else if($('#campusAddress').val() === "") {
			 alert("Please enter campus address");
			 return;
			}
		var obj = {};
		obj.campusName = $('#campusName').val();
		obj.campusAddress = $('#campusAddress').val();
		obj = JSON.stringify(obj);
		$.ajax({
			url : "/Scheduler/campus/validate",
			type : "post",
			data : obj,
			dataType : "json",
			contentType : "application/json",
			success : function(data) {
				if (data == 1)
					alert("Campus already exists!");
				else {
					callSave();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("failure");
			}
		});
	});

});

function onNickNameChange() {
	$("#departmentCombo").attr('disabled', 'disabled');
	$("#campusCombo").attr('disabled', 'disabled');
	var id = $("#departmentCombo").val();
	var date = $("#datepicker").val();

	var myValue = id + ":" + date;
	var post_url = "/Scheduler/departmenttimeslot/gettimeslotcombo/" + myValue;
	$.ajax({
		type : "GET",
		url : post_url,
		success : function(result) {
			$("#timeslotComboDiv").html(result);
		},
		error : function(xhr, status, error) {
			$("#timeslotComboDiv").html(status);
		}
	});
	event.preventDefault();
	return false;
}
function validate() {
	var x = $("#departmentTimeId").val();
	var y = $('#departmentTimeId option').size();
	if (y < 2) {
		alert("Sorry, all the time for selected department for selected date is full or this department does not operate on the date specified.");
		return false;
	}
	if (x == '-1') {
		alert("Please select one available time-slot");
		return false;
	} else {
		return true;
	}
}

/*
 * Author - Ruby Verma 
 * Usage - function to save campus after validation
 */
function callSave() {
	var obj = {};
	obj.campusName = $('#campusName').val();
	obj.campusAddress = $('#campusAddress').val();
	obj = JSON.stringify(obj);
	$.ajax({
        url: "/Scheduler/campus/save",
        type: "post",
        data: obj,
        dataType : "json",
        contentType: "application/json",
        success: function(data){
        	window.location.replace("/Scheduler/campus/view");
         },
      error:function(jqXHR, textStatus, errorThrown) {
           alert("failure");
         }   
   }); 	
};
