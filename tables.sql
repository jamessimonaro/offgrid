# film name, category, and language for every film.

SELECT f.title, c.name, l.name
FROM film f, category c, film_category fc, language l
WHERE f.film_id = fc.film_id AND fc.category_id = c.category_id AND f.language_id = l.language_id
;