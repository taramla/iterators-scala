package imperative.modular

import org.scalatest.WordSpec

class TestLineCount extends WordSpec {

  "The LineCounter" when {
    "given an empty iterator" should {
      "produce an empty output" in {
        trait InputFromEmptyIterator extends Input {
          override val getInput = Iterator.empty
        }
        object SUT extends CountLines with OutputToBuffer[(Int, String)] with InputFromEmptyIterator
        SUT.main(Array.empty)
        assert(SUT.getResults.isEmpty)
      }
    }

    "given a nonempty iterator" should {
      "produce the correct nonempty output" in {
        val data = Seq("hello", "world", "what", "up")
        trait InputFromNonemptyIterator extends Input {
          override val getInput = data.iterator
        }
        object SUT extends CountLines with OutputToBuffer[(Int, String)] with InputFromNonemptyIterator
        SUT.main(Array.empty)
        assert(SUT.getResults === (1 to data.length).zip(data))
      }
    }
  }
}