
/*
                                                 Wednesday Assignment
    Just want to apologize for this one being so late I had a mix up in class where I was working on the wrong project during 
    the time this was assigned. 

    Create a query which returns all of the invoices which have a listed customer, but not invoices who 
    have no customer listed and not customers who have no invoices listed 
*/

select *
from CUSTOMERS
inner join INVOICE
on INVOICE.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;


/*  Create a query which returns all of the invoices and their customer, not invoices who have no customer listed but 
    include customers which have no invoices listed
*/

select *
from CUSTOMERS
left outer join INVOICE
on INVOICE.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;

------  Create a query which shows each record in the invoice table, along with the name of the customer
select INVOICE_ID, INV_DATE, INVOICE.CUSTOMER_ID, AMOUNT, CUSTOMERS.CUSTOMER_NAME 
from INVOICE
join CUSTOMERS
on INVOICE.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;


------  Create a query which shows the name of each customer and the total amount they have spent
select CUSTOMERS.CUSTOMER_NAME, sum(INVOICE.AMOUNT)
from CUSTOMERS
join INVOICE
on INVOICE.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID group by CUSTOMERS.CUSTOMER_NAME;

------  Create a query which returns the record of the customer who made the most recent purchase
select *
from CUSTOMERS
join INVOICE
on CUSTOMERS.CUSTOMER_ID = INVOICE.CUSTOMER_ID and rownum = 1 order by INV_DATE;


------  Create a query which shows the purchaser of each invoice and the subtotal of each invoice 
-----   if 6% sales tax was applied to the subtotal to get the price of each invoice
select CUSTOMERS.CUSTOMER_NAME, round(INVOICE.AMOUNT/.06)
from INVOICE
join CUSTOMERS
on CUSTOMERS.CUSTOMER_ID = INVOICE.CUSTOMER_ID;

