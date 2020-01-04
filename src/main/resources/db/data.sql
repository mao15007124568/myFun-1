INSERT INTO `trouble` (id, content, title, tag_id, creator) VALUES ('1', 'root', '1234', '10', '12');
INSERT INTO `comment` (id, title, recipient, creator, trouble_id, is_share, content) VALUES ('1', 'qwer', '1234', '18', '23', true ,'asdf');

COMMIT;