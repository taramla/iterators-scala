package functional.modular

import scala.collection.AbstractIterator

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctionalModular extends Main[(String, Int)] {

  def accumulateCount(acc: (String, Int), line: String): (String, Int) =
    (line, acc._2 + line.length)

  def run(lines: Iterator[String]): Iterator[(String, Int)] =
    lines.scanLeft("dummy", 0)(accumulateCount).drop(1)
}
