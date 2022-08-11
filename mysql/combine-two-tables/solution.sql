# Write your MySQL query statement below
Select
    p.firstname,
    p.lastname,
    a.city,
    a.state
from 
    person p
LEFT JOIN
    Address a
on
    p.personId = a.personId;