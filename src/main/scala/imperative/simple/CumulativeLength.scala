package imperative.simple

object CumulativeLength extends App {

  var length = 0

  for (line <- scala.io.Source.stdin.getLines) {
    length += line.length
    println((line, length))
  }
}
