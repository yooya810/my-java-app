# ① ビルド⽤イメージ（Java + Gradle が入っている）
FROM gradle:8.12-jdk21 AS build
# アプリを置く作業フォルダ
WORKDIR /app
# プロジェクトのファイルを全部コピー
COPY . .
# jar ファイルを作る（テストは実⾏しない）
RUN ./gradlew bootJar --no-daemon
# ② 実⾏⽤イメージ（Java 実⾏だけできれば良い）
FROM eclipse-temurin:21-jre
WORKDIR /app
# ビルドで作った jar をコピー
COPY --from=build /app/build/libs/*.jar app.jar
# アプリを起動
ENTRYPOINT ["java", "-jar", "app.jar"]