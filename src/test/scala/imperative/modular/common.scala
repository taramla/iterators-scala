package imperative.modular

import scala.collection.mutable.Buffer

/** Provider of an input iterator tied to a specific sequence of strings. */
abstract class InputFromIterator(items: String*) extends Input {
  val getData: Seq[String] = items
  def getInput = items.iterator
}

/** Provider of an output observer that accumulates the results in a buffer one can inspect later. */
trait OutputToBuffer[Result] extends Output[Result] {
  private val buffer = Buffer.empty[Result]
  def getResults: Seq[Result] = buffer.toSeq
  override def doOutput(result: Result) = buffer += result
}
