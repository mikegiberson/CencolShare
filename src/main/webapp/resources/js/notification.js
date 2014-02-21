/*
Author - Shalin Banjara
Usage - Generating a dynamic popup for sending notification to a particular student in a queue
 */

function sendNotification(id,first,last) {
	var userId = id;
	var firstName = first;
	var lastName = last;
	var param = userId + ":" + firstName + ":" + lastName; 

	var post_url = "/Scheduler/generaluser/create/notification/" + param;
	$.ajax({
          type: "GET", 
          url: post_url,
          success: function(result) {
            $("#notificationPopupDiv").html(result);
          },
          error: function(xhr, status, error){
        	  $("#notificationPopupDiv").html(status);
          }
      }); 
      event.preventDefault();
      return false;
}