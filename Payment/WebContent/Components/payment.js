/**
 * 
 */
$(document).ready(function()
{ 
		if ($("#alertSuccess").text().trim() == "") 
		 { 
			$("#alertSuccess").hide(); 
		 } 
		 	$("#alertError").hide(); 
}); 

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) 
{ 
		// Clear alerts---------------------
		 $("#alertSuccess").text(""); 
		 $("#alertSuccess").hide(); 
		 $("#alertError").text(""); 
		 $("#alertError").hide(); 
		 
// Form validation-------------------
var status = validateItemForm(); 
		if (status != true) 
		 { 
			 $("#alertError").text(status); 
			 $("#alertError").show(); 
			 return; 
		 } 
		
		
// If valid------------------------
		var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
		 $.ajax( 
		 { 
		 url : "PaymentAPI", 
		 type : type, 
		 data : $("#formItem").serialize(), 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemSaveComplete(response.responseText, status); 
		 } 
		 });
}); 

function onItemSaveComplete(response, status)
{ 

	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		}
		

		else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		} 
	else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}

	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
		 //$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
	     $("#hidItemIDSave").val($(this).data("Payment_ID"));
		 $("#Benefactor	").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#Payer").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#Amount").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#Account_No").val($(this).closest("tr").find('td:eq(3)').text());
		 $("#Bank").val($(this).closest("tr").find('td:eq(3)').text());
		 
}); 
	// CLIENT-MODEL================================================================
	function validateItemForm() 
	{ 
	// NAME
		if ($("#Benefactor").val().trim() == "") 
		 { 
			return "Benefactor ."; 
		 } 
	// MAIL
		if ($("#Payer").val().trim() == "") 
		 { 
			return "Insert ."; Payer
		 }
	// CODE
		if ($("#projectCode").val().trim() == "") 
		 { 
			return "Insert Amount."; 
		 }
		
	// PROJECT NAME
		if ($("#Account_No").val().trim() == "") 
		 { 
			return "Insert Account_No ."; 
		 }
		
	//Amount-------------------------------
		if ($("#Bank").val().trim() == "") 
		 { 
			return "Insert Bank."; 
		 } 
	// is numerical value

}
	
	//REMOVE
	$(document).on("click", ".btnRemove", function(event)
			{ 
			 $.ajax( 
			 { 
			 url : "PaymentAPI", 
			 type : "DELETE", 
			 data : "Payment_ID=" + $(this).data("Payment_ID"),
			 dataType : "text", 
			 complete : function(response, status) 
			 { 
			 onItemDeleteComplete(response.responseText, status); 
			 } 
		 }); 
});
	
	function onProductDeleteComplete(response, status) {

		if (status == "success") {
			var resultSet = JSON.parse(response);
			if (resultSet.status.trim() == "success") {
				$("#alertSuccess").text("Successfully deleted.");
				$("#alertSuccess").show();
				$("#divItemsGrid").html(resultSet.data);
			}

			else if (resultSet.status.trim() == "error") {
				$("#alertError").text(resultSet.data);
				$("#alertError").show();
			}

		}

		else if (status == "error") {
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		}

		else {
			$("#alertError").text("Unknown error while deleting..");
			$("#alertError").show();

		}

	}

