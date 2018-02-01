package imperative.simple

object CumulativeLengthImperative extends App {

  var length = 0

  for (line <- scala.io.Source.stdin.getLines) {
    length += line.length
    println((line, length))
  }
}
