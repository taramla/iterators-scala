package functional.modular

import scala.collection.AbstractIterator

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctionalModular extends Main[(String, Int)] {

  // def iterate[T](start: T)(f: (T) ⇒ T): Iterator[T]

  // def scanLeft[B](z: B)(op: (B, A) ⇒ B): Iterator[B]
  // https://github.com/scala/scala/blob/v2.12.4/src/library/scala/collection/Iterator.scala#L595

  def scanLeftUsingIterate[T, U](it: Iterator[T])(z: U)(op: (U, T) => U): Iterator[U] =
    Iterator.iterate(Option(z)) {
      case Some(r) =>
        if (it.hasNext) Option(op(r, it.next())) else None
    } takeWhile (_.isDefined) map (_.get)

  def scanLeftAsIterator[T, U](it: Iterator[T])(z: U)(op: (U, T) => U): Iterator[U] = Iterator(z) ++ new AbstractIterator[U] {
    private var hd: T = _
    private var hdDefined = false
    private var tail = it
    private var elem = z

    def hasNext = hdDefined || tail.hasNext && {
      hd = tail.next()
      hdDefined = true
      hdDefined
    }

    def next() = if (hasNext) {
      hdDefined = false
      elem = op(elem, hd)
      elem
    } else
      Iterator.empty.next()
  }

  def accumulateCount(acc: (String, Int), line: String) = (line, acc._2 + line.length)

  def run(lines: Iterator[String]): Iterator[(String, Int)] =
    scanLeftAsIterator(lines)("dummy", 0)(accumulateCount).drop(1)

  // lines.scanLeft(("dummy", 0))(accumulateCount).drop(1) // fail: delayed by one item
}
