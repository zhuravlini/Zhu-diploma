## Порядок действия для запуска тестов ##
1. Запустить Docker Desktop
2. Запустить IntelliJ IDEA
3. Клонировать репозиторий через меню IDEA file - new - project from version control используя URL:https://github.com/zhuravlini/Zhu-diploma.git
4. В терминале IDEA набрать команду docker-compose up
5. В терминале IDEA набрать команду java -jar ./artifacts/aqa-shop.jar
6. В терминале IDEA набрать команду ./gradlew clean test
