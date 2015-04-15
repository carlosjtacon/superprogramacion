package backend
import scala.util.Random

class Tablero(xi:Int,yi:Int,dificulty:Int) {
  val x = xi
  val y = yi
  val content = populate(Nil,x*y)
  val toChar = "ANRVMGB"
  def random = Random.nextInt(dificulty)
  
  //Crea un tablero con datos aleatorios
  def populate(l:List[Int],n:Int):List[Int] = n match{
    case 0 => l
    case _ => populate(random::l,n-1)
  }
  
  def insert(col:Int,pos:Int,l:List[Int]):List[Int] = {
    if(l.isEmpty) Nil
    else if (pos==1) col::l.tail
    else l.head::insert(col,(pos-1),l.tail)
}
  
  //Funciones de prueba para aclararme
  //def get_vecinos(x:Int y:Int):List[List[Int]] =

  //Limpia la tabla para que no haya 3 caras del mismo color seguidas
  def clean_table(l:List[Int]):List[Int] = {
    if (is_clean(l)) {
      return l
    } else {
      return clean_table(l)
    }
  }
  
  //Comprueba si el tablero está limpio
  def is_clean(l:List[Int]):Boolean = {
    return true
  }
  
  //Recibe como parámetros las coordenadas de la cara que mueve y la dirección (se calcularán las coordenadas)
  def move(l:List[Int], x:Int, y:Int, dir:Char) = {
    val origen = (x, y)
    dir match {
      case 'N' => val destino = (x, y-1)
      case 'S' => val destino = (x, y+1)
      case 'E' => val destino = (x+1, y)
      case 'O' => val destino = (x-1, y)
    }
  }
  
  //Método principal recursivo para las jugadas
  def play(l:List[Int]):List[Int] = {
    print
    println("\nCoordenada X: ")
    val x = Console.readInt
    println("Coordenada Y: ")
    val y = Console.readInt
    println("Direccion (N, S, E, O): ")
    val dir = Console.readChar
    println("Coordenadas: " + x + ", " + y + " Dirección: " + dir)
    move(content, x, y, dir)
    clean_table(content)
    play(content)
  }
  
  //Funciones de imprimir
  def print = print_aux(content,1)
  def print_aux(l:List[Int],n:Int):Unit = {
    if(l.isEmpty) return
    if((n%x==0) && (n < x*y)) {println(toChar.charAt(l.head)); print_aux(l.tail,n+1)}
    else {scala.Predef.print(toChar.charAt(l.head)+" "); print_aux(l.tail,n+1)}
  }

}