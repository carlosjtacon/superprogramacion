package backend
  
object Main extends App{
    val tab = new Tablero(8,8,7)
    val ini_clean = tab.clean_table(tab.content)
    tab.play(ini_clean)
}