package imperative.modular

import org.scalatest.WordSpec

import scala.collection.mutable.Buffer

/** Provides an output observer that accumulates the results in a buffer one can inspect later. */
trait OutputToBuffer[Result] extends Output[Result] {

  private val buffer = Buffer.empty[Result]

  def getResults: Seq[Result] = buffer.toSeq

  override def doOutput(result: Result) = { buffer += result }
}

class TestLineCount extends WordSpec {

  /** Creates a (mutable!) SUT instance. */
  def createSUT() = new CountLines with OutputToBuffer[(Int, String)]

  "The LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        // create SUT instance for this test case
        val sut = createSUT()
        // exercise SUT
        sut.run(Iterator.empty)
        // check effect on output observer
        assert(sut.getResults.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        // input data for this test case
        val data = Seq("hello", "world", "what", "up")
        // create SUT instance for this test case
        val sut = createSUT()
        // exercise SUT
        sut.run(data.iterator)
        // check effect on output observer
        assert(sut.getResults === (1 to data.length).zip(data))
      }
    }
  }
}