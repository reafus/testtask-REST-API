Testtask for WebRise

## Инструкция по запуску
Запустите команду для сборки
```bash
    docker-compose up --build
```

# API эндпоинты: 
http://localhost:8080

Топ популярных подписок:

|  Метод  |        URL         |    Описание     | Тело Запроса | Ответ(JSON)|
|:-------:|:------------------:|:---------------:|:------------:| :---------:
|   GET   | /subscriptions/top | Получить топ-3 популярных сервисов  |      -       |  Список из 3 подписок

Пользователи:

|Метод|	URL|	Описание|	Тело запроса (JSON)|	Ответ (JSON)|
|:-------:|:-------:|:-------:|:-------:|:-------:|
|POST|	/users|	Создать пользователя|	{ "name": "Иван", "age": 25, "email": "ivan@example.com" }|	Пользователь (UserResponse)
|GET|	/users/{id}|	Получить пользователя по ID|	-	|Пользователь (UserResponse)
|PUT|	/users/{id}|	Обновить пользователя по ID|	{ "name": "Иван", "age": 26, "email": "ivan_new@example.com" }|	Обновленный пользователь
|DELETE|	/users/{id}|	Удалить пользователя по ID|	-	|HTTP 204 No Content

Подписки пользователя:

|Метод|	URL|	Описание|	Тело запроса (JSON)|	Ответ (JSON)|
|:-------:|:-------:|:-------:|:-------:|:-------:|
|POST|	/users/{userId}/subscriptions|	Добавить подписку пользователю|	{ "serviceName": "YouTube Premium", "endDate": "2025-12-31T23:59:59" }|	Подписка (SubscriptionResponse)
|GET|	/users/{userId}/subscriptions|	Получить все подписки пользователя|	-|	Список подписок
|DELETE|	/users/{userId}/subscriptions/{subscriptionId}|	Удалить подписку пользователя|	-	|HTTP 204 No Content

