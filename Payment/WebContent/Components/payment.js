$.getJSON("http://localhost:8081/ServicePayment/ServicePayment/PaymentService", function(userData){
        var responseObj = JSON.parse(JSON.stringify(userData));

        $.each(responseObj,function(i,payment){
          appendToPaymentTable(payment);
      });

});

function appendToPaymentTable(payment) {
    
    $("#paymentTable > tbody:last-child").append(`
          <tr id="user-${payment.id}">
              <td class="userData" name="id">${payment.id}</td>
              '<td class="userData" name="Benefactor">${payment.Benefactor}</td>
              '<td class="userData" name="Payer">${payment.Payer}</td>
              '<td class="userData" name="Amount">${payment.Amount}</td>
              '<td class="userData" name="Account_No">${payment.Account_No}</td>
              '<td class="userData" name="Account_No">${payment.Bank}</td>
              '<td align="center">
                  <button class="btn btn-success form-control" onClick="editPayment(${payment.id})" data-toggle="modal" data-target="#myModal")">EDIT</button>
              </td>
              <td align="center">
                  <button class="btn btn-danger form-control" onClick="deletePayment(${payment.id})">DELETE</button>
              </td>
          </tr>
      `)
};


function editPayment(id) {
    $.getJSON("http://localhost:8081/ServicePayment/ServicePayment/PaymentService", function(userData){
          var responseObj = JSON.parse(JSON.stringify(userData));
          responseObj.forEach(function(payment, i) {
            if (payment.id == id) {
              $(".modal-body").empty().append(`
                        <form id="updatePayment" action="">
                            <label for="Benefactor">Benefactor</label>
                            <input class="form-control" type="text" name="Benefactor" value="${payment.Benefactor}"/>
                            <label for="Payer">Payer</label>
                            <input class="form-control" type="text" name="Payer" value="${payment.Payer}"/>
                            <label for="Amount">Amount</label>
                            <input class="form-control" type="text" name="Amount" value="${payment.Amount}"/>
                            <label for="Account_No">Account_No</label>
                            <input class="form-control" type="text" name="Account_No" value="${payment.Account_No}"/>
              `);
              $(".modal-footer").empty().append(`
                            <button type="button" type="submit" class="btn btn-primary" data-dismiss="modal" onClick="updatePayment(${id})">Save changes</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </form>
              `);
            }
          });
    });
      
}

function updatePayment(id) {
    var payment2 = {};
    payment2.id = id;

    $("#updatePayment").children("input").each(function(){
      payment2[$(this).attr("name")] = $(this).val();
    })
    console.log(payment2);

    $.ajax({
      async:true,
      type:"PUT",
      url:"http://localhost:8081/ServicePayment/ServicePayment/PaymentService",
      data:JSON.stringify({ payment2 }),
      contentType: 'application/json',
      success:function(){
        alert("success")
      }
    });
}

function deletePayment(id){
  $.ajax({
    type:"DELETE",
    url:"http://localhost:8081/ServicePayment/ServicePayment/PaymentService",
    data:`<paymentData><Payment_ID>${id}</Payment_ID></paymentData>`,
    contentType: 'text/xml',
  });
}