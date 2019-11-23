package imperative.modular

import org.scalatest.WordSpec

class TestLineCountImperative extends WordSpec {

  /** Creates a (mutable!) SUT instance. */
  def createSUT() = new CountLines with OutputToBuffer[(Int, String)]

  "An imperative LineCounter" when {
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