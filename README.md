# Groovy - tips og triks
Diverse scripts som løser enkle og kompliserte problemer i hverdagen.

## Fil-manipulasjon
Kode for å manipulere tekst-filer. F.eks. legge til prefix/postfix på hver eneste linje, eller fjerne deler av teksten.

```groovy
File result = new File("result.txt")
PrintWriter printWriter = new PrintWriter(result)

File file = new File("input.txt")
file.eachLine() { line ->
    printWriter.println("<prefix> ${line} <postfix>")
}

printWriter.close()
```

Kanskje fjerne enkelte kolonner i en csv-fil? 

```groovy
File result = new File("result.txt")
PrintWriter printWriter = new PrintWriter(result)

File file = new File("input.csv")
file.eachLine() { line ->
	// Splitter hver linje inn i et array ved hver "tab"
	// Ved å legge til -1 beholder man også såkalte "empty"-felt
	def lineAsList = line.split("\t", -1);

	// Beholder annenhver kolonne (modulo 2)
	def resultList = []
	int index = 0
    for (def col : lineAsList) {
        if (index % 2 == 0) {
            resultList << col
        }
        index++
    }

	// Joiner sammen listen til en tekststreng igjen, og legger til et "tab" mellom hvert felt
    printWriter.println(resultList.join("\t"))
}

printWriter.close()
```

Mange muligheter, ett enkelt script.