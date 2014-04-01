import org.scalatest.FunSuite

/**
 * Created by abishek on 01/04/14.
 */
class ParserTest extends FunSuite {
  test("Should convert a given expression into tokens"){
    val expr : String = "(define area (lambda (r) (* 3.141592653 (* r r))))"
    val parser: Parser = new Parser()
    val tokens: List[String] = parser.tokens(expr)
    assert(tokens.length != 0)
  }

  test("Given a set of tokens it should be parsed"){

    val expr : String = "(define area (lambda (r) (* 3.141592653 (* r r))))"
    val parser: Parser = new Parser()
    val tokens: List[String] = parser.tokens(expr)
    parser.parse(tokens)
  }
}
