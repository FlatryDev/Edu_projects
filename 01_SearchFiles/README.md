# Рекурсивный обход папки на Java 
**`МОЙ КОД`**

## Реализовано с использованием fork-join.

Консольная программа вывода самых больших файлов в заданной папке. 
JAR-файл запускается из командной строки с двуммя параметрами: первый - путь к папке, в которой нужно искать самые большие файлы; второй - указывается размер файла в мегабайтах, выше которого файл считается большим.

**Пример запуска программы из командной строки с параметрами:**
`java -jar SearchFiles.jar C:\Windows\ 100 `

В этой команде указано, что программа, упакованная в файл SearchFiles.jar, должна искать файлы более 100 мегабайт в папке C:\Windows\ и её подпапках.

Программа выводит в консоль список файлов, найденных в указанной папке и её подпапках, в порядке убывания размера с указанием полного пути и размера в мегабайтах. 



**Пример вывода результата**

* C:\Windows\SoftwareDistribution\DataStore\DataStore.edb - 1952,06 Mb
* C:\Windows\Microsoft.NET\Framework64\v4.0.30319\SetupCache\v4.6.01055\NetFx_Full.mzz - 207,03 Mb
* C:\Windows\Logs\CBS\CBS.log - 187,55 Mb
* C:\Windows\winsxs\ManifestCache\4a05f513c62b957a_blobs.bin - 140,02 Mb