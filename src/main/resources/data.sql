SELECT INTO permissions (permission_name) VALUES (CREATE);
SELECT INTO permissions (permission_name) VALUES (FIND);
SELECT INTO permissions (permission_name) VALUES (UPDATE);
SELECT INTO permissions (permission_name) VALUES (DELETE);
SELECT INTO users (name, password, permissions, users_privilege) VALUES ('admin', 'admin123', '1''2''3''4', 'ADMIN');
