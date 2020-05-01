#1. Which customers are in a different city than their sales representative?

SELECT c.customerNumber,c.customerName from csci3901.customers as c
JOIN csci3901.employees as e on c.salesRepEmployeeNumber = e.employeeNumber
where c.city <> (select ofc.city from csci3901.offices as ofc where e.officeCode = ofc.officeCode);

#2. Which orders included sales that are below the manufacturer’s suggested retail price(MSRP)?

select o.orderNumber,od.priceEach as Sale ,p.MSRP FROM  csci3901.orders as o
INNER JOIN csci3901.orderdetails as od on o.orderNumber = od.orderNumber
INNER JOIN csci3901.products as p on od.productCode = p.productCode
where od.priceEach < p.MSRP
group by od.orderNumber;

#3. List the top 5 products for 2004 with the highest average mark-up percentage per order.Include the mark-up. The mark-up is the ratio of (sale price – cost) and cost.

SELECT p.productCode,p.productName, avg(((od.priceEach - p.buyPrice)/p.buyPrice)*100) as AverageMarkup FROM csci3901.orderdetails as od
INNER JOIN csci3901.products as p on od.productCode = p.productCode
INNER JOIN csci3901.orders as o on o.orderNumber = od.orderNumber
where o.orderDate like '2004%'
group by od.productCode
order by AverageMarkup DESC
limit 5 ;

#4. List the top 3 employees with the greatest average diversity of products in their orders.

select  a.emp , a.fName,a.sName, avg(a.avgdiv) as AverageDiversity from 
(SELECT e.employeeNumber as emp, e.firstName as fName, e.lastName as sName,  count(distinct(od.productCode)) as avgdiv FROM csci3901.employees as e
Inner Join csci3901.customers as c on c.salesRepEmployeeNumber = e.employeeNumber
Inner join csci3901.orders as o on o.customerNumber = c.customerNumber
Inner join csci3901.orderdetails as od on od.orderNumber = o.orderNumber
group by od.orderNumber
order by avgdiv desc
) a  group by a.emp order by AverageDiversity desc limit 3;

#5. What is the average time needed to ship orders from each office in 2005, relative to the order date?
 
Select ofc.officeCode,ofc.city,avg(DATEDIFF(o.shippedDate, o.orderDate)) as Shipping_Time from csci3901.orders as o
INNER JOIN csci3901.customers as c on o.customerNumber = c.customerNumber
INNER JOIN csci3901.employees as e on c.salesRepEmployeeNumber = e.employeeNumber
INNER JOIN csci3901.offices as ofc on e.officeCode = ofc.officeCode
where o.orderDate like "2005%"
group by ofc.city
order by ofc.officeCode asc;
