CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       age INT NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE subscriptions (
                               id BIGSERIAL PRIMARY KEY,
                               service_name VARCHAR(255) NOT NULL,
                               user_id BIGINT NOT NULL,
                               start_date TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                               end_date TIMESTAMP WITHOUT TIME ZONE,
                               CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
                               CONSTRAINT chk_dates CHECK (end_date IS NULL OR end_date >= start_date)
);

CREATE INDEX idx_subscriptions_user_id ON subscriptions(user_id);
CREATE INDEX idx_subscriptions_service_name ON subscriptions(service_name);