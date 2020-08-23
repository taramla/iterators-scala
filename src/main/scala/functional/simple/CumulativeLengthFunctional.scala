package functional.simple

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctional extends App {

  val lines = scala.io.Source.stdin.getLines()

  def accumulateCount(acc: (String, Int), line: String): (String, Int) =
    (line, acc._2 + line.length)

  val results = lines.scanLeft("dummy", 0)(accumulateCount).drop(1)

  results.foreach { r => println(r) }
}
