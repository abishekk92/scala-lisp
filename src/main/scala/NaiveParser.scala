

/**
 * Created by abishek on 07/04/14.
 */
object NaiveParser {

    def tokens(expression : String) : List[String] = {
      expression.replace("(", "( ").replace(")", " )").split(" ").toList
    }



  def parse(collector: List[Expression], tokens : List[String]) : (List[Expression], List[String]) = {
      def convert(token : String) = {
        try{
          valueExpression(Number(BigDecimal(token)))
        }
        catch {
          case _ : Throwable => Symbol(token)
        }
      }
      tokens match {

        case "("  :: t => {
          val (expr, remaining) = parse(List(), t)
          parse(Combinator(expr)::collector, remaining)
        }

        case ")" :: t => (collector.reverse, t)

        case head :: t => parse(convert(head) :: collector, t)

        case List() => (collector.reverse, List())
      }

    }
}
