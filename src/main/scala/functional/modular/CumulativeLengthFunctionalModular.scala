package functional.modular

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctionalModular extends Main[(String, Int)] {

  def run(lines: Iterator[String]): Iterator[(String, Int)] =
    lines.scanLeft(("dummy", 0)) {
      case ((_, n), line) =>
        (line, n + line.length)
    }.drop(1)
}
