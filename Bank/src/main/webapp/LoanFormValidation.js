/**
 * 
 */
var errorElement = document.getElementById('error');
var form = document.getElementById('applyLoan');
var password = document.getElementById('password');
var salary = document.getElementById('salary');
var loanType = document.getElementById('loantype');
var loanAmount = document.getElementById('loanamount');




form.addEventListener('submit', (event) => { 
  let errMessages = []
  errMessages.push(passwordcheck)
  if(password.value != passwordcheck){
    errMessages.push('Your password is'+passwordcheck);
  }
  // if(loanAmount > maxLoan){
  //   errMessages.push('Loan amount cannot exceed 12 times monthly income')
  // }
  if (errMessages.length > 1  ){
      event.preventDefault();
      errorElement.innerText = errMessages.join(', ');
  }

})

// salary.addEventListener('change',()=>{
//   let maxLoan = salary.value*12;
//   document.getElementById('loanamount').setAttribute('max','maxLoan');
// });

loanType.addEventListener('change',()=>{
  if (loanType.value =='Pers1' ){
    document.getElementById('interest')
  }

});





