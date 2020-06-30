# WhereverIWant

https://github.com/EmiCoder/WhereverIWantToGo-frontend

Aplikacja korzysta z 2 api (https://dev.meteostat.net, https://openweathermap.org).
Na potrzeby działania aplikacji lokalnie (dane z meteostat zastąpiłam lokalnie, losowo wygenerownymi danymi). 
Niestety to bezpłatne api zapisywało nie wszyskie dane (zapisało mi niespełna 100), zapewne ma jakieś zabezpieczenia.
Zapisywanie danych z tego api jest w scheduler MeteostatApiRequest.
