import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object RecogeDatos {
  def main(args: Array[String]): Unit = {
    val Datos = ArrayBuffer[String]() 

    print("Introduce el nombre: ")
    val Nombre = StdIn.readLine()
    Datos += Nombre
    print("Introduce los apellidos: ")
    val Apellidos = StdIn.readLine()
    Datos += Apellidos
    print("Introduce el email: ")
    val Mail = StdIn.readLine()
    Datos += Mail
    print("Introduce la dirección: ")
    val Direcc = StdIn.readLine()
    Datos += Direcc
    println("Datos introducidos: " + Datos.mkString(" - "))

  }
}