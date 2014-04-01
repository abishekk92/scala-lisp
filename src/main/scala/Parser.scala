/**
 * Created by abishek on 01/04/14.
 */
class Parser {

  def tokens(expression : String) : List[String] = {
    expression.replace("(", "( ").replace(")", " ) ").split(" ").toList
  }

  def parse(tokens : List[String]) = {
    for (token <- tokens){
      println(token)
    }
  }
}

