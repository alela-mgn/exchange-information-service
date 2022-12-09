## Exchange Information Service
## Установка
- Клонируйте репозиторий
  `git clone https://github.com/alela-mgn/exchange-information-service.git`
- выполните команду
  `mvn clean install`
- выполните sql скрипт
  `CREATE DATABASE exchange_information_db; GRANT ALL ON DATABASE exchange_information_db TO eis; CREATE USER eis WITH PASSWORD 'eis';`
