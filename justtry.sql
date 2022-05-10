SELECT * FROM banking.loanrepayments;
Select loan_TimeStamp, loans.loan_Id, loan_type, loan_term_mths, loan_amount, If(ISNULL(outstanding)=1, loan_amount, outstanding)
from banking.loans Left Join banking.loanrepayments 
on loans.loan_Id = loanrepayments.loan_Id
where loans.cust_Id = 3;