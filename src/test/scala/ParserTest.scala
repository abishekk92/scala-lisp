import org.scalatest.FunSuite

/**
 * Created by abishek on 01/04/14.
 */
class ParserTest extends FunSuite {

  test("Should parse"){
    val expr : String = "(define area (lambda (r) (* 3.141592653 (* r r))))"
    val result = Parser.parse(expr)
    val expectedResult= Combinator(List(Symbol("define"), Symbol("area"), Combinator(List(Symbol("lambda"), Combinator(List(Symbol("r"))), Combinator(List(Symbol("*"), valueExpression(Number(3.141592653)), Combinator(List(Symbol("*"), Symbol("r"), Symbol("r")))))))))
    assert(result == expectedResult)

  }

}
