import upickle.default.{read => uread, write => uwrite, ReadWriter, macroRW} // Importamos macroRW para generar automáticamente el ReadWriter
import os.{read => _, _} // Excluimos el método read de os-lib

// Definimos la clase Usuario
case class Usuario(Nombre: String, Precio: Float, Descripcion: String, Calorias: Int)

// Creamos un objeto companion para Usuario y definimos un ReadWriter implícito
object Usuario {
  implicit val rw: ReadWriter[Usuario] = macroRW
}

object LeerJSON {
  def main(args: Array[String]): Unit = {
    // Ruta del archivo JSON (asegúrate de que esté en la misma carpeta que este programa)
    val rutaArchivo = os.pwd / "usuario.json"

    // Leer el contenido del archivo JSON
    val contenidoJSON = os.read(rutaArchivo)

    // Parsear el contenido del archivo a un objeto Usuario
    val usuario = uread[Usuario](contenidoJSON)

    // Mostrar el objeto Usuario
    println("Datos del Desayuno:")
    println(s"Nombre: ${usuario.Nombre}")
    println(s"Apellidos: ${usuario.Precio}")
    println(s"DNI: ${usuario.Descripcion}")
    println(s"Edad: ${usuario.Calorias}")

    // Mostrar el JSON original
    println("\nContenido del archivo JSON:")
    println(contenidoJSON)
  }
}