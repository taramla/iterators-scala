package functional.simple

object CumulativeLength extends App {

  val lines = scala.io.Source.stdin.getLines

  val results = Iterator.iterate {
    Option(("dummy", 0))
  } {
    case Some((_, n)) =>
      if (lines.hasNext) {
        val line = lines.next
        Option((line, n + line.length))
      } else {
        None
      }
  } drop (1) takeWhile (_.isDefined) map (_.get)

  results foreach println
}
