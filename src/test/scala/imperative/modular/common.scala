package imperative.modular

import scala.collection.mutable.Buffer

trait OutputToBuffer[Result] extends Output[Result] {
  private val buffer = Buffer.empty[Result]
  def getResults: Seq[Result] = buffer.toSeq
  override def doOutput(result: Result) = buffer += result
}
