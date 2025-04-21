import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

class Direccion(private var _calle: String, private var _ciudad: String, private var _codigoPostal: String):
  def calle: String = _calle
  def ciudad: String = _ciudad
  def codigoPostal: String = _codigoPostal
  def calle_=(calle : String): Unit = _calle = calle
  def ciudad_=(ciudad : String): Unit = _ciudad = ciudad
  def codigoPostal_=(codigoPostal : String): Unit = _codigoPostal = codigoPostal

class Persona(private val _nombre: String, private val _edad: Int, private var _direccion: Direccion):
  def this(nombre: String, edad: Int) = this(nombre, edad, new Direccion("","",""))
  def nombre: String = _nombre
  def edad: Int = _edad
  def direccion: Direccion = _direccion
  def mostrar(): Unit =
    println()
    println(s"Nombre: $nombre")
    println(s"Edad: $edad")
    println(s"Dirección: ${direccion.calle}")
    println(s"${direccion.codigoPostal} - ${direccion.ciudad}")
    println()


object PersonitaApp:
  def main(args: Array[String]): Unit =
    val Agenda = ArrayBuffer[Persona]()
    var persona = new Persona("Heriberto Lai", 69)
    persona.direccion.calle = "Calle La Palmas, 2"
    persona.direccion.ciudad = "Villar de Chinchilla"
    persona.direccion.codigoPostal = "56712"
    Agenda += persona
    persona = new Persona("Carlota Caña", 40)
      persona.direccion.calle = "Carretera Imanta, km 123"
    persona.direccion.ciudad = "Robledal de la Jara"
    persona.direccion.codigoPostal = "14852"
    Agenda += persona
    persona = new Persona("Ramón Igote", 33)
    persona.direccion.calle = "Avenida de Vuelta, 43"
    persona.direccion.ciudad = "Catarara de Rioseco"
    persona.direccion.codigoPostal = "98524"
    Agenda += persona
    persona = new Persona("Paula Mentable", 28)
    persona.direccion.calle = "Camino de la Perdición, 666"
    persona.direccion.ciudad = "Torrealta de Montebajo"
    persona.direccion.codigoPostal = "25864"
    Agenda += persona

    println("||||||||||||||||||   LISTA DE GENTE A LA QUE ACOSO EN SU CASA   ||||||||||||||||||")
    println()
    for i <- Agenda do i.mostrar()
    println()
    println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
