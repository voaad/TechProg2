# Технологии Программирования
## Приходько Владислав Олегович ББИ237. Техническое задание №2.
[![Build Status](https://github.com/voaad/TechProg2/actions/workflows/main.yml/badge.svg)](https://github.com/voaad/TechProg2/actions)
### Для запуска тестов из веб-интерфейса GitHub, необходимо перейти во вкладку Actions, выбрать нужный процесс и нажать Re-run all jobs. Тесты запускаются автоматически при любом новом коммите в репозиторий этого проекта.
Этот проект использует Maven. В директории src есть директории main и test. В первой находится файл Main.java, в котором написан проверяемый код, а также файл PerformanceChart.java, который использует библиотеку JFreeChart, которую требуется [скачать](https://github.com/jfree/jfreechart) и подключить самостоятельно. В папке же test, в свою очередь находится файл с кодом тестов. Мной дополнительно был написан тест корректности входных данных. В коде есть комментарии, чтобы было понятно что где тестируется.

Еще есть 6 txt-файлов. Они были созданы путем написания кода на Python. Те, которые "minmaxtest..." отвечают за проверку поиска минимума и максимума, а те, которые "summultest..." отвечают за проверку вычислений суммы и произведения. Так пришлось сделать, потому что при большом количестве чисел в произведении получаются какие-то огромные дикие значения, которые проверять весьма затруднительно. Но тесты все равно проходятся, поскольку в случае получения слишком больших значений, программа выдает в консоль сообщение "Too big".

В файле "График скорости чтения" находится скриншот окна, выдаваемого при запуске PerformanceChart.java из директории src/main. Он показывает производительность функции считывания чисел из кода. Числа считывались из файла minmaxtest1kk.txt, где их миллион.

<center><img src="https://github.com/voaad/TechProg2/blob/main/График%20скорости%20чтения.png?raw=true" alt="График скорости чтения чисел" width="777"/></center>

Также CI-система (я решил не умничать и выбрал GitHub Actions) интегрирована в Telegram. С помощью BotFather я создал бота, который шлет мне уведомления, когда происходят коммиты в этот репозиторий.

<center><img src="https://github.com/voaad/TechProg2/blob/main/Снимок%20экрана%202024-05-07%20в%2003.08.40.png?raw=true" alt="Михаил Шиномонтаж" width="333"/></center>
