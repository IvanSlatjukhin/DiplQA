## Дипломный проект по профессии "Тестировщик".

1. Запустить Docker Desktop

2. Открыть проект в IntelliJ IDEA

3. Cклонировать репозиторий

4. В терминале IntelliJ IDEA выполнить команду `docker-compose up`, дождаться подъема контейнеров.

5. В терминале IntelliJ IDEA выполнить команду для запуска приложения:
- для MySQL:
  `java -jar artifacts/aqa-shop.jar "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app"`

- для Postgres:
  `java -jar artifacts/aqa-shop.jar "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app"`

  В браузере сервис будет доступен по адресу http://localhost:8080/.

5. В терминале IntelliJ IDEA выполнить команду для прогона автотестов: 

- для MySQL:
  ` java -jar artifacts/aqa-shop.jar "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app"`
- для Postgres:
  `java -jar artifacts/aqa-shop.jar "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app"`

6. В терминале IntelliJ IDEA выполнить команду для получения отчета:
   `.\gradlew allureServe `

**После завершения прогона автотестов и получения отчета:**
- Завершить обработку отчета сочетанием клавиш `CTRL + C`, в терминале нажать клавишу `Y`, нажать `Enter`.
- Закрыть приложение сочитанием клавиш `CTRL + C` в терминале запуска.
- Остановить работу контейнеров командой `docker-compose down`.