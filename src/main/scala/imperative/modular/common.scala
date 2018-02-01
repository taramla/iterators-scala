package imperative.modular

/** Contract representing a dependency (plug-in point) on an input iterator. */
trait Input {
  def getInput: Iterator[String]
}

/** Contract representing a dependency (plug-in point) on an output method (Observer). */
trait Output[Result] {
  def doOutput(result: Result)
}

/** Provider of an input iterator tied to stdin. */
trait InputFromStdIn extends Input {
  override def getInput = scala.io.Source.stdin.getLines
}

/** Provider of an output observer tied to println/stdout. */
trait OutputToStdOut[Result] extends Output[Result] {
  override def doOutput(result: Result) = println(result)
}
