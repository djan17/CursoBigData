import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

class Motor(private val _tipo: String, private var _potencia: Int):
  def tipo: String = _tipo
  def potencia: Int = _potencia
  def potencia_=(nuevaPotencia: Int): Unit = _potencia = nuevaPotencia
  def aumentarPotencia(cambio: Int): Unit = _potencia += cambio


class Coche(private val _marca: String, private val _modelo: String, private var _motor: Motor):
  def marca: String = _marca
  def modelo: String = _modelo
  def motor: Motor = _motor
  def mostrar(): Unit = println(s"$marca $modelo con un motor de ${motor.potencia} dromedarios")


object Coche2App:
  def main(args: Array[String]): Unit =
    val Escuderia = ArrayBuffer[Coche]()
    var coche = new Coche("Lambo", "Mambo", new Motor("Combustión", 320))
    Escuderia += coche
    coche = new Coche("Ferrero", "Testagrossa", new Motor("Combustión", 400))
    Escuderia += coche
    coche = new Coche("Opel", "E-Corsa", new Motor("Eléctrico", 150))
    Escuderia += coche
    println("||||||||||||||||||   EL GARAGE DEL NOVIAYUSO   ||||||||||||||||||")
    println()
    for i <- Escuderia do
      i.mostrar()
    println()
    println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
