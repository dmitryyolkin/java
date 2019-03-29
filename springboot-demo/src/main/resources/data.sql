-- Please see for details in PasswordEncoderFactories.createDelegatingPasswordEncoder
-- noop - NoOpPasswordEncoder (no enscryption)
-- bcrypt BCryptPasswordEncoder
-- if one of the prefixes are not specified then IllegalArgumentException with message below will be got
--      There is no PasswordEncoder mapped for the id "null"

-- $2a$10$HSiWpihJlqV/.pWAe2v8vuzt3nKkpK.nt8YaegDawzKG6X559VRjy  is encoded value for 123
insert into Reader (username, password, fullname) values ('dmitry', '{bcrypt}$2a$10$HSiWpihJlqV/.pWAe2v8vuzt3nKkpK.nt8YaegDawzKG6X559VRjy', 'Dmitry');
insert into Reader (username, password, fullname) values ('testUser', '{noop}password', 'Test User');