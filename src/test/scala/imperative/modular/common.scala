package imperative.modular

import scala.collection.mutable.Buffer

abstract class InputFromIterator(items: String*) extends Input {
  val getData: Seq[String] = items
  def getInput = items.iterator
}

trait OutputToBuffer[Result] extends Output[Result] {
  private val buffer = Buffer.empty[Result]
  def getResults: Seq[Result] = buffer.toSeq
  override def doOutput(result: Result) = buffer += result
}
