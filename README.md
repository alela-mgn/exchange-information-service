## Exchange Information Service
## Описание
CRUD приложение, которое позволяет импортировать ценные бумаги и историю ценных бумаг в формате xml. Сохранение информации
происходит в базу данных.

***
## Системные требования
Установленные:
- Java 11
- Apache Maven
- PostgreSql 14
***
## Установка
- Клонируйте репозиторий
  `git clone https://github.com/alela-mgn/exchange-information-service.git`
- выполните команду
  `mvn clean install`
- выполните sql скрипт
  `CREATE DATABASE exchange_information_db; CREATE USER eis WITH PASSWORD 'eis'; GRANT ALL ON DATABASE exchange_information_db TO eis;`
***
## Запуск программы
- Выполните команду
  ` java -jar target/ExchangeInformation-0.0.1-SNAPSHOT.jar`
***
Import Securities
---
Endpoint Import:
```
POST /api/import/securities
```
Импортировать файл с ценными бумагами можно по следующей ссылке:
http://localhost:8080/api/import/securities
***
Import Histories
---
Endpoint Import:
```
POST /api/import/histories
```
Импортировать файл с историей о ценных бумагах можно по следующей ссылке:
http://localhost:8080/api/import/histories
***
CRUD Securities
---
Endpoint :
```
GET /api/security
```
Получить все ценные бумаги можно по следующей ссылке:
http://localhost:8080/api/securities

Endpoint Delete:
```
GET /api/security/delete/{id}
```
Удалить ценную бумагу можно по следующей ссылке:
http://localhost:8080/api/securities/delete/{id}

Endpoint Get:
```
GET /api/security/get/{id}
```
Получить ценную бумагу можно по id можно по следующей ссылке:
http://localhost:8080/api/securities/get/{id}

Endpoint Update:
```
PUT /api/security/update/{id}
```
Обновить ценную бумагу можно по следующей ссылке:
http://localhost:8080/api/securities/update/{id}

Endpoint Save:
```
POST /api/security/create
```
Сохранить ценную бумагу можно по следующей ссылке:
http://localhost:8080/api/securities/create
***

CRUD Histories
---
Endpoint:
```
GET /api/histories
```
Получить всю историю по ценным бумагам можно по следующей ссылке:
http://localhost:8080/api/histories

Endpoint Get:
```
GET /api/histories/get/{id}
```
Получить историю ценной бумаги можно по следующей ссылке:
http://localhost:8080/api/histories/get/{id}

Endpoint Delete:
```
GET /api/histories/delete/{id}
```
Удалить историю о ценной бумаге можно по следующей ссылке:
http://localhost:8080/api/histories/delete/{id}

Endpoint Update:
```
PUT/api/histories/update/{id}
```
Обновить историю о ценной бумаге можно по следующей ссылке:
http://localhost:8080/api/histories/update/{id}

Endpoint Create:
```
POST /api/histories/create
```
Сохранить историю о ценной бумаге можно по следующей ссылке:
http://localhost:8080/api/histories/create

Endpoint Detailed-info:
```
GET /api/histories/detailed-info
```
Получить сведенные данные можно по следующей ссылке:
http://localhost:8080/api/histories/detailed-info
***
