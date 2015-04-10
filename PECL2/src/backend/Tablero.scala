package backend
import scala.util.Random

class Tablero(dificulty:Int) {
  //val dificulty = _dificulty
  def random = Random.nextInt(dificulty)
  //val linear_content = populate(8, 8, 8, 8 l:List[Int])
  val content = random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::
  random::random::random::random::random::random::random::random::Nil
  
  
  
  /*
  def populate(x:Int, y:Int, xi:Int, yi:Int,l:List[Int]):List[Int] = yi match{
    case 0 => if(xi > 0) xi::populate(x,y,xi-1,y,l.tail)
    case _ => xi::populate(x,y,xi,yi-1,l.tail)
  }*/
  
  def fila:List[Int] = {
    random::random::random::random::random::random::random::random::Nil
  }
  
  //Funciones de prueba para aclararme
  //def get_vecinos(x:Int y:Int):List[List[Int]] =

  
  //Insertar en lista:
  //def insertar(l:List,pos:Int,color:Int)
  def print = print_aux(content,1)
  def print_aux(l:List[Int],n:Int):Unit ={
    if(l.isEmpty) return
    if((n%8==0) && (n < 64)) {println(l.head); print_aux(l.tail,n+1)}
    else {scala.Predef.print(l.head+" "); print_aux(l.tail,n+1)}
  }  
  

}