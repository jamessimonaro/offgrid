#Every customer's last rental date

SELECT
	c.first_name AS "First Name", c.last_name AS "Last Name", max(r.rental_date) AS "Last Rental Date"
FROM
	customer c, rental r
WHERE
	c.customer_id = r.customer_id
GROUP BY
	c.customer_id
ORDER BY 
	c.customer_id DESC
;
