package backend
  
object Main extends App{
    val tab = new Tablero(8,8,7)
    tab.clean_table(tab.content)
    tab.play(tab.content)
}