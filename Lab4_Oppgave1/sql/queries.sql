-- Finne alle varene til bruker med id = 1
SELECT
  i.item,
  u.name
FROM shopping_list.item i
  JOIN shopping_list.shopping_list s
    ON i.sl_id = s.shopping_list_id
  , shopping_list.user u
WHERE u.user_id = s.user_id
      AND u.user_id = 1