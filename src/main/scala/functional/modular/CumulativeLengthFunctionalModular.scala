package functional.modular

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctionalModular extends Main[(String, Int)] {

  def run(lines: Iterator[String]): Iterator[(String, Int)] =
    Iterator.iterate(Option(("dummy", 0))) {
      case Some((_, n)) =>
        if (lines.hasNext) {
          val line = lines.next
          Option((line, n + line.length))
        } else {
          None
        }
    } drop (1) takeWhile (x => x.isDefined) map (x => x.get)
}
