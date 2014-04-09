import org.scalatest.FunSuite

/**
 * Created by abishek on 01/04/14.
 */
class ParserTest extends FunSuite {

  test("Should parse"){
    val expr : String = "(define area (lambda (r) (* 3.141592653 (* r r))))"
    val result = Parser.parse(expr).asInstanceOf[List[Any]]
    val expectedResult= List("define", "area", List("lambda", List("r"), List("*", 3.141592653, List("*", "r", "r"))))
    assert(result.length == expectedResult.length)
  }

}
