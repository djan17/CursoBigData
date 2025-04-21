import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer

class Autor(private var _nombre: String, private var _nacionalidad: String):
  def nombre: String = _nombre
  def nacionalidad: String = _nacionalidad
  def nombre_=(nombre : String): Unit = _nombre = nombre
  def nacionalidad_=(nacionalidad : String): Unit = _nacionalidad = nacionalidad

class Libro(private val _titulo: String, private val _isbn: String, private var _autor: Autor):
  def this(titulo: String, isbn: String) = this(titulo, isbn, new Autor("",""))
  def titulo: String = _titulo
  def isbn: String = _isbn
  def autor: Autor = _autor
  def mostrarDetalles(): Unit =
    println()
    println(s"Título: $titulo")
    println(s"ISBN: $isbn")
    println(s"${autor.nombre} - ${autor.nacionalidad}")
    println()


object LibreriAPP:
  def main(args: Array[String]): Unit =
    val Autores = ArrayBuffer[Autor]()
    val Biblioteca = ArrayBuffer[Libro]()
    var autor = new Autor("Akira Toriyama", "Japonesa")
    Autores += autor
    autor = new Autor("Osamu Tezuka", "Japonesa")
    Autores += autor
    autor = new Autor("Rumiko Takahashi", "Japonesa")
    Autores += autor
    autor = new Autor("Masamune Shiro", "Japonesa")
    Autores += autor
    var libro = new Libro("Ghost in the shell","232541254788")
    Biblioteca += libro
    libro = new Libro("Maison Ikkoku","25884582248")
    Biblioteca += libro
    libro = new Libro("El arbol que da sombra","232541254788")
    Biblioteca += libro
    libro = new Libro("Dr. Slump","78954212548")
    Biblioteca += libro
    var j = Autores.length
    for
        i <- Biblioteca
        if (j>0)
    do
        j -= 1
        i.autor.nombre = Autores(j).nombre
        i.autor.nacionalidad = Autores(j).nacionalidad

    println("||||||||||||||||||   Mangateka   ||||||||||||||||||")
    println()
    for i <- Biblioteca do i.mostrarDetalles()
    println()
    println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
