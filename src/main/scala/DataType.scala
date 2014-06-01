/**
 * Created by abishek on 10/04/14.
 */
sealed trait Value
case class Number(a : BigDecimal) extends Value
case class Bool(a : Boolean) extends Value
case class Name(a : String) extends Value

sealed trait Expression

case class Combinator(a : List[Expression]) extends  Expression

case class valueExpression(a : Value) extends Expression

case class Symbol(a : String) extends  Expression

