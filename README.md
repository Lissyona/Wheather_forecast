![Tests](https://github.com/Lissyona/Wheather_forecast/actions/workflows/maven-test.yml/badge.svg?branch=main)

![Tests](https://github.com/Lissyona/Wheather_forecast/actions/workflows/maven-test.yml/badge.svg?branch=dev)
# Wheather forecast

## Описание

Сервис который по запросу пользователя, считывает погоду в данный момент времени в выбранном городе и переводит ее в грудусы Фаренгейта или Цельсия.


## Использование

После запуска программы в консоль выводится сообщение: "Input city" - где вписывается город на английском языке, далее выводится  сообщение "Convert to Fahrenheit(Fahr) or Celsius(C) ?" - пользователь выбирает нужную ему единицу измерения температуры и далее выводится результат.

## Запуск с помощью Docker

docker build -t wheather .
docker run -it  wheather:latest