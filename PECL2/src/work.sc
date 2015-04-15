import scala.util.Random

object work {
  //val fila =  List(1,2,3,4,5,6,7,8)
  //val tablero = List(fila,fila,fila,fila,fila,fila,fila,fila)
  
  val chars = "ANRVMGB"                           //> chars  : String = ANRVMGB
	chars.charAt(1)                           //> res0: Char = N
  
 // val rand =  new Random.alphanumeric
  def fila = {
  	Math.random()
  }                                               //> fila: => Double
  
  def insert(col:Int,pos:Int,l:List[Int]):List[Int] = {
    if(l.isEmpty) Nil
    else if (pos==0) col::l.tail
    else l.head::insert(col,(pos-1),l.tail)
  }                                               //> insert: (col: Int, pos: Int, l: List[Int])List[Int]
  insert(1,3,1::2::3::4::Nil)                     //> res1: List[Int] = List(1, 2, 3, 1)
  
  insert(2, 2, insert(3, 1, 1::2::3::Nil))        //> res2: List[Int] = List(1, 3, 2)
	 def get_color(l:List[Int], pos:Int):Int = {
	    if (pos==1) l.head
	    else get_color(l.tail, pos-1)
	  }                                       //> get_color: (l: List[Int], pos: Int)Int
	  get_color(1::2::3::Nil,2)               //> res3: Int = 2
	 
}