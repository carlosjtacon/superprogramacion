package backend
import scala.util.Random

class Tablero(xi:Int,yi:Int,dificulty:Int) {
  val x = xi
  val y = yi
  val content = populate(Nil,x*y)
  def random = Random.nextInt(dificulty)
  
  //Crea un tablero con datos aleatorios
  def populate(l:List[Int],n:Int):List[Int] = n match{
    case 0 => l
    case _ => populate(random::l,n-1)
  }
  
  //Funciones de prueba para aclararme
  //def get_vecinos(x:Int y:Int):List[List[Int]] =

  
  //Funciones de imprimir
  def print = print_aux(content,1)
  def print_aux(l:List[Int],n:Int):Unit ={
    if(l.isEmpty) return
    if((n%8==0) && (n < 64)) {println(l.head); print_aux(l.tail,n+1)}
    else {scala.Predef.print(l.head+" "); print_aux(l.tail,n+1)}
  }  
  

}