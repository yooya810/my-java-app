# ① ビルド用イメージ（Java + Gradle）
FROM gradle:8.12-jdk21 AS build

WORKDIR /app

# プロジェクトファイルをコピー
COPY . .

# gradlew に実行権限を付与（必要な場合が多い）
RUN chmod +x gradlew

# jar をビルド（テストはスキップ）
RUN ./gradlew bootJar --no-daemon

# ② 実行用イメージ（軽量）
FROM eclipse-temurin:21-jre

WORKDIR /app

# ビルド成果物コピー
COPY --from=build /app/build/libs/*.jar app.jar

# Render が割り当てる PORT を使って Spring Boot を起動
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]
