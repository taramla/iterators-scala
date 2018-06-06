package imperative.simple

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthImperative extends App {

  var length = 0
  println(length)

  var line = scala.io.StdIn.readLine()
  while (line != null) {
    length += line.length
    println(length)
    line = scala.io.StdIn.readLine()
  }
}
