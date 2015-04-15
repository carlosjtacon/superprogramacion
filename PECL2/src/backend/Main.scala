package backend
  
object Main extends App{
    val tab = new Tablero(8,8,7)
    tab.play(tab.content)
}