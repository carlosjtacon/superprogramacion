package backend
import scala.util.Random

class Tablero(xi:Int,yi:Int,dificulty:Int) {
  val x = xi
  val y = yi
  val content = populate(Nil,x*y)
  val toChar = "ANRVMGB"
  def random = Random.nextInt(dificulty)
  
  def linear_coords(x:Int, y:Int):Int = x * this.x + y
  
  //Crea un tablero con datos aleatorios
  def populate(l:List[Int],n:Int):List[Int] = n match {
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
  
  //Devuelve el entero que representa el color en una posición
  def get_color(l:List[Int], pos:Int):Int = {
    return 0
  }
  
  //Recibe como parámetros las coordenadas de la cara que mueve y la dirección (se calcularán las coordenadas)
  def move(l:List[Int], x:Int, y:Int, dir:Char):List[Int] = {
    val origen = linear_coords(x, y)
    val destino = dir match {
      case 'N' => linear_coords(x, y-1)
      case 'S' => linear_coords(x, y+1)
      case 'E' => linear_coords(x+1, y)
      case 'O' => linear_coords(x-1, y)
      case  _  => 0
    }
    val origenColor = get_color(l, origen)
    val destinoColor = get_color(l, destino)
    return insert(origenColor, destino, insert(destinoColor, origen, l))
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
    val lista_movimiento = move(l, x, y, dir)
    val lista_limpia = clean_table(lista_movimiento)
    play(lista_limpia)
  }
  
  //Funciones de imprimir
  def print = print_aux(content,1)
  def print_aux(l:List[Int],n:Int):Unit = {
    if(l.isEmpty) return
    if((n%x==0) && (n < x*y)) {println(toChar.charAt(l.head)); print_aux(l.tail,n+1)}
    else {scala.Predef.print(toChar.charAt(l.head)+" "); print_aux(l.tail,n+1)}
  }

}