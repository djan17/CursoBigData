import scala.io.StdIn
import play.api.libs.json._

object JsonEjemplo {
  def main(args: Array[String]): Unit = {
    // Solicitar datos al usuario
    print("Introduce tu nombre: ")
    val nombre = StdIn.readLine()

    print("Introduce tus apellidos: ")
    val apellidos = StdIn.readLine()

    print("Introduce tu DNI: ")
    val dni = StdIn.readLine()

    print("Introduce tu edad: ")
    val edad = StdIn.readInt()

    // Crear un objeto JSON con los datos proporcionados
    val json = Json.obj(
      "nombre" -> nombre,
      "apellidos" -> apellidos,
      "dni" -> dni,
      "edad" -> edad
    )

    // Mostrar el JSON en la consola
    println("JSON generado:")
    println(Json.prettyPrint(json))
  }
}