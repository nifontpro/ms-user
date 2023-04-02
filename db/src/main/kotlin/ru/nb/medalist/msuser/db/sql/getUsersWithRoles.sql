select u.email, u.firstname, d.name
from users.user_data u
         inner join users.user_role r on u.id = r.user_id
         inner join users.role_data d on d.id = r.role_id