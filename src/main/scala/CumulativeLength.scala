object CumulativeLength extends App {

  val lines = scala.io.Source.stdin.getLines

  val results = Iterator.iterate {
    Option((0, "dummy"))
  } {
    case Some((n, _)) =>
      if (lines.hasNext) {
        val line = lines.next
        Option((n + line.length, line))
      } else {
        None
      }
  } drop (1) takeWhile (_.isDefined) map (_.get)

  results foreach println
}
