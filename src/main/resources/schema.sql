--テーブルが存在したら削除する
--DROP TABLE IF EXISTS coping_strategy;
--DROP TABLE IF EXISTS users;

--usersテーブルの作成
CREATE TABLE IF NOT EXISTS users(
	user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
	user_name VARCHAR(255) NOT NULL UNIQUE,
	pass VARCHAR(255) NOT NULL,
	mail VARCHAR(255) --未実装
);
--copingテーブルの作成

CREATE TABLE IF NOT EXISTS coping_strategy (
    coping_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- PostgreSQL では SERIAL の代わりに IDENTITY
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description text,
    category VARCHAR(100),
    execution_count INT DEFAULT 0, -- 実行回数を記録
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- インデックスを別途作成
CREATE INDEX IF NOT EXISTS idx_user_id ON coping_strategy (user_id);
CREATE INDEX IF NOT EXISTS idx_category ON coping_strategy (category);

--exeテーブルの作成
CREATE TABLE IF NOT EXISTS execution_record(
    execution_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    coping_id BIGINT NOT NULL,
    execution_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    count INT DEFAULT 0,
    FOREIGN KEY (coping_id) REFERENCES coping_strategy(coping_id) ON DELETE CASCADE
);