package imperative.modular

import scala.collection.mutable.Buffer

/** Provides an output observer that accumulates the results in a buffer one can inspect later. */
trait OutputToBuffer[Result] extends Output[Result] {

  private val buffer = Buffer.empty[Result]

  def getResults: Seq[Result] = buffer.toSeq

  override def doOutput(result: Result) = { buffer.append(result) }
}


/** A mini-framework for trace-based testing of interactive behavior. */
trait Tracing[I, O] extends Output[O] {

  sealed trait TraceEvent
  case class InputEvent(value: I) extends TraceEvent
  case class OutputEvent(value: O) extends TraceEvent

  val trace = Buffer.empty[TraceEvent]

  /** Instruments the input such that accessing the item appends the corresponding event to the trace. */
  def traced(input: Iterator[I]) = input.map { s => trace.append(InputEvent(s)); s }

  /** Adds the output to the trace. */
  override def doOutput(result: O) = trace.append(OutputEvent(result))
}
