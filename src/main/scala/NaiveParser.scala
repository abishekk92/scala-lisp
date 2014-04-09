/**
 * Created by abishek on 07/04/14.
 */
object NaiveParser {

    def tokens(expression : String) : List[String] = {
      expression.replace("(", "( ").replace(")", " )").split(" ").toList
    }


    def parse(collector: List[Any], tokens : List[Any]) : (List[Any], List[Any]) = {

      tokens match {

        case "("  :: t => {
          val (expr, remaining) = parse(List(), t)
          parse(expr::collector.asInstanceOf[List[Any]], remaining)
        }

        case ")" :: t => (collector.reverse, t)

        case head :: t => parse(head :: collector, t)

        case List() => (collector.reverse, List())
      }

    }
}
