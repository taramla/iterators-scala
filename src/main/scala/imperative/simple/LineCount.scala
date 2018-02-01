package imperative.simple

/** Reads lines and prints line count along with line itself. */
object LineCountImperative extends App {

  var count = 0

  for (line <- scala.io.Source.stdin.getLines) {
    count += 1
    println((count, line))
  }
}
