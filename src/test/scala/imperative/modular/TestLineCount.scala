package imperative.modular

import org.scalatest.WordSpec

class TestLineCount extends WordSpec {

  def createSUT(items: String*) =
    new InputFromIterator(items: _*) with CountLines with OutputToBuffer[(Int, String)]

  "The LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        // create SUT instance with empty input
        val SUT = createSUT()
        // exercise SUT
        SUT.main(Array.empty)
        // check effect on output observer
        assert(SUT.getResults.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        // create SUT instance with desired nonemtpy input
        val SUT = createSUT("hello", "world", "what", "up")
        // exercise SUT
        SUT.main(Array.empty)
        // check effect on output observer
        assert(SUT.getResults === (1 to SUT.getData.length).zip(SUT.getData))
      }
    }
  }
}