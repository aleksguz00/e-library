# Электронная библиотека

CRUD электронная библиотека на Spring MVC, JDBC API и с простеньким Frontend на шаблонизаторе Thymeleaf

## Инструкция по сборке проекта

1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/aleksguz00/e-library

2. Перейти в директорию проекта:
   ```bash
    cd

3. В папке resources создать файл database.properties для конфига БД и заполнить его по образцу файла database.properties.origin

4. Собрать проект:
   ```bash
   mvn clean package

5. Поднять docker-контейнер с БД
   ```bash
   docker-compose up -d

6. Запустить проект
- Либо из IDE
- Либо через команды запуска Tomcat:

  - скопировать .war файл в папку webapps Tomcat
      ```bash
      cp /path/to/your/project/target/your-app.war /path/to/tomcat/webapps/
    
  - Перейти в папку bin Tomcat и запустить сервер 
      ```bash 
      cd /path/to/tomcat/bin
      ./catalina.sh start

## Тестирование

Тестировать удобнее через frontend. Есть 2 главных эндпоинты - /people и /books
