package imperative.modular

import org.scalatest.WordSpec

class TestLineCount extends WordSpec {

  "The LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        object SUT extends InputFromIterator() with CountLines with OutputToBuffer[(Int, String)]
        SUT.main(Array.empty)
        assert(SUT.getResults.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        object SUT extends InputFromIterator("hello", "world", "what", "up") with CountLines with OutputToBuffer[(Int, String)]
        SUT.main(Array.empty)
        assert(SUT.getResults === (1 to SUT.getData.length).zip(SUT.getData))
      }
    }
  }
}