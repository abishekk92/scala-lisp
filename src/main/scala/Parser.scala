/**
 * Created by abishek on 01/04/14.
 */

import scala.util.parsing.combinator._


object Parser extends JavaTokenParsers{
  val value : Parser[Value] = stringLiteral ^^ (a => Name(a)) | floatingPointNumber ^^ (a => Number(BigDecimal(a)))

  val expression: Parser[Expression] = value ^^ (a => valueExpression(a)) | """[^()\s]+""".r ^^ (a => Symbol(a)) | combinator

  val combinator: Parser[Combinator] = "(" ~> rep(expression) <~ ")" ^^ (a => Combinator(a))

  val program: Parser[List[Expression]] = rep(expression)

  def parse(expressions : String) = parseAll(program, expressions).get.head

}