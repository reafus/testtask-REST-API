-- USERS

INSERT INTO users (name, age, email)
VALUES
    ('Иван Иванов', 25, 'ivan@example.com'),
    ('Мария Петрова', 31, 'maria@example.com'),
    ('Джон Доу', 22, 'john@example.com'),
    ('Анна Смирнова', 28, 'anna@example.com');

-- SUBSCRIPTIONS

INSERT INTO subscriptions (service_name, user_id, end_date)
VALUES
    ('YouTube Premium', 1, '2025-12-31 23:59:59'),
    ('VK Музыка', 1, '2025-10-01 23:59:59'),
    ('Яндекс.Плюс', 2, '2025-11-15 23:59:59'),
    ('Netflix', 3, '2025-12-31 23:59:59'),
    ('YouTube Premium', 2, '2025-12-31 23:59:59'),
    ('Netflix', 1, '2025-12-31 23:59:59'),
    ('VK Музыка', 3, '2025-10-01 23:59:59'),
    ('YouTube Premium', 4, '2025-12-31 23:59:59');