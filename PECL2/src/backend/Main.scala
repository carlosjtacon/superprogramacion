package backend

import frontend.AppGUI

object Main extends App{

	def generar_parametros:(Int,Int) = {
			print("Quieres jugar a tiempo o movimientos? [t|m]: ")
			val respuesta = io.StdIn.readChar
      println
			generar_parametros(respuesta)
	}

	def generar_parametros(r:Char):(Int,Int) = r match {
	  case 't' => 
      print("Cuanto tiempo quieres jugar? (segundos): ")
      val time = io.StdIn.readInt
      (time,-1)
    case 'm' =>
      print("Cuantos movimientos quieres tener?: ")
      val mov = io.StdIn.readInt
      (0,mov)
    case _ =>
      print("No te entiendo, quieres jugar a tiempo o movimientos? [t|m]: ")
      val r = io.StdIn.readChar
      generar_parametros(r)
	}
  
  def get_dificultad:Int = {
    print("elige dificultad [f|m|d]: ")
    val i = io.StdIn.readChar
    i match {
      case 'f' => 3
      case 'm' => 5
      case 'd' => 7
      case _ => print("no te entiendo, ");get_dificultad
    }
  }
  
  val dif = get_dificultad
  val (time,mov) = generar_parametros

	val player = new Thread {
		override def run {
			val tab = new Tablero(8,8,dif)
      println("Preparación del tablero inicial: ")
      println("\nTablero: ")
      tab.print_aux(tab.content,1)
			val (ini_clean,_) = tab.clean_table(tab.content,0)
			val puntos = tab.play(ini_clean,mov,0)
      println("\nFin del juego, puntuacion total: "+puntos)
		}
	}
  player.start
  
  if (time > 0){
    Thread.sleep(time*1000)
    player.interrupt()
  }	
}

