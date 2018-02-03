package functional.modular

/** Reads lines and prints cumulative length of all lines so far along with most recent line itself. */
object CumulativeLengthFunctionalModular extends Main[(String, Int)] {

  def run(lines: Iterator[String]): Iterator[(String, Int)] =
    lines.scanLeft(("dummy", 0)) {
      case ((_, n), line) =>
        (line, n + line.length)
    }.drop(1)
}

//val results = Iterator.iterate(Option(("dummy", 0))) {
//case Some((_, n)) =>
//if (lines.hasNext) {
//val line = lines.next
//Option((line, n + line.length))
//} else {
//None
//}
//} drop (1) takeWhile (x => x.isDefined) map (x => x.get)

//  val results = Iterator.iterate((true, ("dummy", 0))) {
//    case (true, (_, n)) =>
//      if (lines.hasNext) {
//        val line = lines.next
//        (true, (line, n + line.length))
//      } else {
//        (false, ("dummy", 0))
//      }
//  } drop (1) takeWhile (x => x._1) map (x => x._2)

// def scanLeft[B](z: B)(op: (B, A) ⇒ B): Iterator[B]

// def iterate[T](start: T)(f: (T) ⇒ T): Iterator[T]

// it.scanLeft(z)(op) == Iterator.iterate((it.hasNext, z)((c, r) => val n = it.next() ; (it.hasNext, n)).takeWhile(_._1).map(_._2)

// https://github.com/scala/scala/blob/v2.12.4/src/library/scala/collection/Iterator.scala#L595

//  val results = lines.scanLeft(("dummy", 0)) {
//    case ((_, n), line) =>
//      (line, n + line.length)
//  }.drop(1)

//  def scanLeft[T, U](it: Iterator[T])(z: U)(op: (U, T) => U): Iterator[U] = Iterator.iterate(z)(r => op(r, it.next())).takeWhile(_ => it.hasNext)

//val results = lines.scanLeft("dummy")((_, l) => l).drop(1)
