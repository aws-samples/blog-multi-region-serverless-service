
var messageHistory = "";

(function call_service() {

	$.ajax({
		url: helloworldMultiregionendpoint+'v1/helloworld/',
		dataType: "json",
		cache: false,
		success: function(data) {
			messageHistory+="<p>"+data['message']+"</p>";
			$('#client_result').html(messageHistory);
		},
		complete: function() {
			// Schedule the next request when the current one's complete
			setTimeout(call_service, 10000);
		},
		error: function(xhr, status, error) {
			$('#client_result').html('ERROR: '+status);
		}
	});

})();