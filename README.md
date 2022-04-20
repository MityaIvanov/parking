# parking

Сервис по обслуживанию парковки

![Enities](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/MityaIvanov/parking/master/src/Enities.puml)

Использует:

* [Spring Boot](https://spring.io/projects/spring-boot)
* Flyway (миграции)
* H2 Database

## Проверка

Проверка работы сервиса через swagger инспектор: https://inspector.swagger.io/builder

## Запросы

### Загрузка парковки

### CRUD

Добавить событие

`POST http://localhost:8080/events`

```
{
    "beg_date": "2022-04-14 13:00",
    "car": 4,
    "space": 4
}
```

Добавить машину:

`POST http://localhost:8080/cars`

```
{
"name": "Suzuki",
"phone": "+7928",
"plate": "123"
}
```

Добавить парковочное место:

`POST http://localhost:8080/spaces`

```
{
"number": "10"
}
```
