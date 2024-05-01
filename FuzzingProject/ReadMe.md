Этапы работ: 

Были написаны классы - цели фаззинга. Папка FuzzingProject/src/main/java/ru/hse

С помощью команд:

./jazzer --cp=FuzzingProject.jar --agent_path=./jazzer_standalone.jar --target_class=ru.hse.{ClassName}

были запущены данные файлы и найдены некоторые ошибки. 
Результаты работы фаззера можно найти в папке FuzzingProject/src/main/java
