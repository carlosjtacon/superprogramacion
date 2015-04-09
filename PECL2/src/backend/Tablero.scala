package backend
import scala.util.Random

class Tablero(dificulty:Int) {
  //val dificulty = _dificulty
  val content = fila::fila::fila::fila::fila::fila::fila::fila::Nil
  def random = Random.nextInt(dificulty)
  
  def fila:List[Int] = {
    random::random::random::random::random::random::random::random::Nil
  }
  
  //Funciones de imprimir
  def print = print_aux(content)
  def print_aux(l:List[List[Int]]):Unit = {
    if (!l.isEmpty) {
      println(print_sub_list(l.head))
      print_aux(l.tail)  
    }    
  }
  def print_sub_list(l:List[Int]):String = {
    if(l.size == 1) l.head.toString()
    else l.head.toString + " " +print_sub_list(l.tail)
  }
}