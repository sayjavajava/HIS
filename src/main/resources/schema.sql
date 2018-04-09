CREATE TABLE IF NOT EXISTS properties(
  id  INTEGER  AUTO_INCREMENT PRIMARY KEY,
  client_id VARCHAR(64),
  client_secret VARCHAR(64),
  auth_server_schem VARCHAR(64)
   );