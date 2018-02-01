package imperative.simple

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthImperative extends App {

  var length = 0

  for (line <- scala.io.Source.stdin.getLines) {
    length += line.length
    println((line, length))
  }
}
