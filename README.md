## Порядок действий для запуска тестов ##
1. Запустить Docker Desktop
2. Запустить IntelliJ IDEA
3. Клонировать репозиторий через меню IDEA file - new - project from version control используя URL: https://github.com/zhuravlini/Zhu-diploma.git
4. В терминале IDEA набрать команду docker-compose up
5. В терминале IDEA набрать команду java -jar ./artifacts/aqa-shop.jar
6. Запустить тесты командой gradlew clean test
7. Открыть отчет о прохождении тестов командой gradlew allureServe




### [Отчет по итогам прохождения автотестов](https://github.com/zhuravlini/Zhu-diploma/blob/main/Report.md) ###
### [Отчет по итогам автоматизации](https://github.com/zhuravlini/Zhu-diploma/blob/main/Summary.md) ###
