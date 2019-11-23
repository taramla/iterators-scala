package functional.modular

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctionalModular extends App {

  runWithStdIO(run)

  def accumulateCount(acc: (String, Int), line: String): (String, Int) =
    (line, acc._2 + line.length)

  def run(lines: Iterator[String]): Iterator[(String, Int)] =
    lines.scanLeft("dummy", 0)(accumulateCount).drop(1)
}
