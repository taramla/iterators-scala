package imperative.simple

object LineCount extends App {

  var count = 0

  for (line <- scala.io.Source.stdin.getLines) {
    count += 1
    println((count, line))
  }
}
