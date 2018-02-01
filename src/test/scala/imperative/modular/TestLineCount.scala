package imperative.modular

import org.scalatest.WordSpec

class TestLineCount extends WordSpec {

  "The LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        // create SUT instance with empty input
        object SUT extends InputFromIterator() with CountLines with OutputToBuffer[(Int, String)]
        // exercise SUT
        SUT.main(Array.empty)
        // check effect on output observer
        assert(SUT.getResults.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        // create SUT instance with desired nonemtpy input
        object SUT extends InputFromIterator("hello", "world", "what", "up") with CountLines with OutputToBuffer[(Int, String)]
        // exercise SUT
        SUT.main(Array.empty)
        // check effect on output observer
        assert(SUT.getResults === (1 to SUT.getData.length).zip(SUT.getData))
      }
    }
  }
}