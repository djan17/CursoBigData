import scala.io.StdIn


class Coche(private val _marca: String, private val _modelo: String, private var _velocidadActual: Int) {

  def this(marca: String, modelo: String) = this(marca, modelo, 0)

  def marca: String = _marca
  def modelo: String = _modelo
  def velocidadActual: Int = _velocidadActual

  def velocidadActual_=(cambioVelocidad: Int): Unit = {
    _velocidadActual += cambioVelocidad
    if (_velocidadActual <= 0) then
      _velocidadActual = 0
      println("Estás parado")
    else if (_velocidadActual >= 180) then
        _velocidadActual = 180
        println("El motor ya no puede ir más deprisa")
  }

  def acelerar(): Unit = this.velocidadActual= 10
  def frenar(): Unit = this.velocidadActual= -10
  def mostrarVelocidad(): Unit = println("Vas a " + this._velocidadActual + " km/h")
}

object CocheApp {
  def main(args: Array[String]): Unit = {

    val coche = new Coche("Lambo", "Mambo")
    var opc = "1"
    println("======= Conduciendo tu " + coche.marca + " " + coche.modelo + "por la autopista =======")
    println("1. Acelerar")
    println("2. Frenar")
    println("3. Aparcar")
    while opc != "3" do
        opc = StdIn.readLine()
        opc match
          case "1" => coche.acelerar()
          case "2" => coche.frenar()
          case "3" => println("Saliendo")
          case _ => println("Opción incorrecta")
        coche.mostrarVelocidad()
    if (coche.velocidadActual>0) then
        println("Reduciendo la velocidad a 0 y...")
    println("Aparcando el " + coche.marca)

    }
}
