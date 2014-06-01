import org.scalatest.FunSuite

/**
 * Created by abishek on 10/04/14.
 */
class NaiveParserTest extends FunSuite {
  test("Should convert the given expression into tokens") {

    val expr: String = "(define area (lambda (r) (* 3.141592653 (* r r))))"
    val tokens: List[String] = NaiveParser.tokens(expr)
    val expectedResult = List("(", "define", "area", "(", "lambda", "(", "r", ")", "(", "*", "3.141592653", "(", "*", "r", "r", ")", ")", ")", ")")
    assert(tokens === expectedResult)
  }

  test("Should parse the given tokens into Scala Types"){

    val tokens = List("(", "define", "area", "(", "lambda", "(", "r", ")", "(", "*", "3.141592653", "(", "*", "r", "r", ")", ")", ")", ")")
    val (result::t , _) = NaiveParser.parse(List(), tokens)
    val expectedResult = Combinator(List(Symbol("define"), Symbol("area"),
                                    Combinator(List(Symbol("lambda"), Combinator(List(Symbol("r"))),
                                    Combinator(List(Symbol("*"), valueExpression(Number(3.141592653)),
                                    Combinator(List(Symbol("*"), Symbol("r"), Symbol("r")))))))))
    assert(result === expectedResult)
  }
}
