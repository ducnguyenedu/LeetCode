/* Write your PL/SQL query statement below */
select e.Name as Employee
from Employee e
         join Employee m
              on (e.ManagerId = m.Id)
where e.salary > m.salary;