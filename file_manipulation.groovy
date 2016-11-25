File result = new File("result.txt")

PrintWriter printWriter = new PrintWriter(result)

File file = new File("input.txt")
file.eachLine() { line ->
    printWriter.println("<prefix> ${line} <postfix>")
}

printWriter.close()