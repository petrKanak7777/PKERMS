create table file (
    file_id uuid DEFAULT gen_random_uuid(),
    user_id uuid NULL,
    name VARCHAR NOT NULL,
    PRIMARY KEY (file_id)
);

INSERT INTO file ( user_id, name )
VALUES
    ('940be04d-f0a4-4408-b120-93e2e400f72c', 'File0'),
    ('00b48cba-ce22-4975-b961-d7dade3bcd90', 'File1')