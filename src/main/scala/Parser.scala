/**
 * Created by abishek on 01/04/14.
 */

import scala.util.parsing.combinator._


object Parser extends JavaTokenParsers{
  val value : Parser[Any] = stringLiteral ^^ (a => a) | floatingPointNumber ^^ (BigDecimal(_))

  val expression: Parser[Any] = value ^^ (a => a) | """[^()\s]+""".r ^^ (a => a) | function

  val function: Parser[List[Any]] = "(" ~> rep(expression) <~ ")" ^^ (a => a)

  val program: Parser[List[Any]] = rep(expression)

  def parse(expressions : String) = parseAll(program, expressions).get.head

}