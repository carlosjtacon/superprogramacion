package backend

object Main extends App{

	val player = new Thread {
		override def run {
			val tab = new Tablero(8,8,7)
			val (ini_clean,_) = tab.clean_table(tab.content,0)
			tab.play(ini_clean,-1,0)
		}
	}
  
  player.start
  //Thread.sleep(5000)
  //player.interrupt()  
}