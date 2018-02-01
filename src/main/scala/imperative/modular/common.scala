package imperative.modular

trait Input {
  def getInput: Iterator[String]
}

trait Output[Result] {
  def doOutput(result: Result)
}

trait InputFromStdIn extends Input {
  override def getInput = scala.io.Source.stdin.getLines
}

trait OutputToStdOut[Result] extends Output[Result] {
  override def doOutput(result: Result) = println(result)
}
