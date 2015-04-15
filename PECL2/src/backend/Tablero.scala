package backend
import scala.util.Random

class Tablero(xi:Int,yi:Int,dificulty:Int) {
  val x = xi
  val y = yi
  val content = populate(Nil,x*y)
  val toChar = "ANRVMGB"
  def random = Random.nextInt(dificulty)
  
  def linear_coords(x:Int, y:Int):Int = y * this.x + x
  
  //Crea un tablero con datos aleatorios
  def populate(l:List[Int],n:Int):List[Int] = n match {
    case 0 => l
    case _ => populate(random::l,n-1)
  }
  
  //Inserta el color col en la posicion lineal pos de la lista l
  def insert(col:Int,pos:Int,l:List[Int]):List[Int] = {
    if(l.isEmpty) Nil
    else if (pos==0) col::l.tail
    else l.head::insert(col,(pos-1),l.tail)
  }

  //Limpia la tabla para que no haya 3 caras del mismo color seguidas
  def clean_table(l:List[Int]):List[Int] = {
    if (is_clean(l,0,1)) {
      return l
    } else {
      return clean_table(l)
    }
  }
  
  //Comprueba si el tablero está limpio
  def is_clean(l:List[Int], init:Int, c:Int):Boolean = {
    if (c==3) return false 
    //vertical
    if(get_color(l,init) == (get_color(l,next_vertical(init)))) { 
      if(is_clean(l, next_vertical(init), c+1)) {
        //horizontal
        if(get_color(l,init) == (get_color(l,next_horizontal(init)))) {
          if (is_clean(l, next_horizontal(init), c+1)) {
            return true
          } else return false
        } else is_clean(l, next_horizontal(init), 1)
        return true
      } else return false
    } else is_clean(l, next_vertical(init), 1)
  }
  
//  Comprueba si hay filas de al menos 3 seguidos en las columnas
  def check_vertical = {
    
  }
  
  //  Comprueba si hay filas de al menos 3 seguidos en las columnas
  def check_horizontal = {
    
  }
  
  //Devuelve la siguiente posicion lineal vertical a una dada, -1 si es la última
  def next_vertical(pos:Int):Int = {
    if(pos >= (this.x * (this.y-1))) (-1) //se ha terminado la columna
    else pos + this.x
  }
  
  //Devuelve la siguiente posicion lineal horizontal a una dada, -1 si es la última
  def next_horizontal(pos:Int):Int = {
    if(((pos+1) % this.x).equals(0)) (-1) //se ha terminado la fila
    else pos+1
  }
  
  //Devuelve el entero que representa el color en una posición
  def get_color(l:List[Int], pos:Int):Int = {
    if (pos==0) l.head
    else get_color(l.tail, pos-1)
  }
  
  //Recibe como parámetros las coordenadas de la cara que mueve y la dirección (se calcularán las coordenadas)
  def move(l:List[Int], x:Int, y:Int, dir:Char):List[Int] = {
    val origen = linear_coords(x, y)
    val destino = dir match {
      case 'N' => linear_coords(x, y-1)
      case 'S' => linear_coords(x, y+1)
      case 'E' => linear_coords(x+1, y)
      case 'O' => linear_coords(x-1, y)
    }
    val origenColor = get_color(l, origen)
    println(">>> Origen: " + origen)
    println(">>> Color Origen: " + toChar.charAt(origenColor))
    val destinoColor = get_color(l, destino)
    println(">>> Destino: " + destino)
    println(">>> Color Destino: " + toChar.charAt(destinoColor))
    return insert(origenColor, destino, insert(destinoColor, origen, l))
  }
  
  //Método principal recursivo para las jugadas
  def play(l:List[Int]):List[Int] = {
    println("Tablero: ")
    print_aux(l,1)
    println("\nCoordenada X: ")
    val x = Console.readInt
    println("Coordenada Y: ")
    val y = Console.readInt
    println("Direccion (N, S, E, O): ")
    val dir = Console.readChar
    println(">>> Coordenadas: " + x + ", " + y + " Dirección: " + dir)
    val lista_movimiento = move(l, x, y, dir)
    //si no se puede limpiar nada la jugada no es válida, 
    //por lo que llamamos al método play con su mismo valor de entrada
    if(is_clean(lista_movimiento,0,1)) {println(">>> Jugada no válida !!!");play(l)}
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