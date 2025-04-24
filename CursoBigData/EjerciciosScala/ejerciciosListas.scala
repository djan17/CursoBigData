import scala.io.StdIn
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map as MapMut

object EjerciciosListas:
    def main(args: Array[String]): Unit =
        var sw = true
        while sw do
            println("")
            println("*********************************************************************")
            println("1. Elimina duplicados y cuenta ocurrencias")
            println("2. Encuentra el segundo mayor")
            println("3. Filtra y transforma")
            println("4. Invertir un Mapa")
            println("5. Insertar libro por fichero")
            println("6. Insertar lista de libros")
            println("7. Mostrar lista de autores")
            println("8. Mostrar lista de libros")
            println("0. Salir")
            println("*********************************************************************")
            var opcion = StdIn.readLine()
            opcion match
                case "1" => listaDuplicados()
                case "2" => segundoMayor()
                case "3" => filtraTransforma()
                case "4" => invierteMapa()
                /*case "5" => insertaLibroFichero()
                case "6" => insertaListaLibros()
                case "7" => muestraAutores()
                case "8" => muestraLibros()*/
                case "0" => sw = false
                case _ => println("Opción inválida")

            def listaDuplicados(): Unit =
                var arrayPalabras = ArrayBuffer[String]()
                var sw = true
                while sw do
                    println("Introduce una palabra (0 para acabar) ")
                    var palabra = StdIn.readLine()
                    if palabra == "0" then
                        sw = false
                    else
                        arrayPalabras += palabra

                val palabras = arrayPalabras.toList
                val palabrasdistintas = palabras.distinct
                println(palabrasdistintas)
                palabrasdistintas.map(palabra =>
                    val listaGrupada = palabras.groupBy(_ == palabra)
                    println(s"${palabra.capitalize} ${listaGrupada(true).length} ")
                )

            def segundoMayor(): Unit =
                var arrayNumeros = ArrayBuffer[Int]()
                var sw = true
                while sw do
                    println("Introduce un número (* para acabar) ")
                    var numero = StdIn.readLine()
                    if numero == "*" then
                        sw = false
                    else
                        arrayNumeros += numero.toInt
                val numeros = arrayNumeros.toList
                println(numeros)
                println(encuentraSegundoMayor(numeros))


            def encuentraSegundoMayor(numeros: List[Int]): String =
                val numerosDistintos = numeros.distinct
                var resultado: String = ""
                if numerosDistintos.length > 1 then
                    resultado = "El 2º numero mayor es: " + numerosDistintos.sorted.reverse(1)
                else
                    resultado = "No hay un 2º número mayor"
                resultado

            def filtraTransforma(): Unit =
                var arrayNumeros = ArrayBuffer[Int]()
                var sw = true
                while sw do
                    println("Introduce un número (* para acabar) ")
                    var numero = StdIn.readLine()
                    if numero == "*" then
                        sw = false
                    else
                        arrayNumeros += numero.toInt
                val numeros = arrayNumeros.toList
                val numerosFiltrados = numeros.filter(_ % 3 == 0).filter(_ > 10).map(_ * 2)
                println(numerosFiltrados)


            def invierteMapa(): Unit =
                var mapaGente = Map[String, Int]()
                var mapaInvertido = Map[Int,Set[String]]()
                var sw = true
                while sw do
                    println("Introduce el nombre (0 para acabar) ")
                    var nombre = StdIn.readLine()
                    if nombre == "0" then
                        sw = false
                    else
                        println("Introduce su edad: ")
                        var edad = StdIn.readInt()
                        mapaGente += (nombre -> edad)
                //for (i, j) <- mapaGente do
                //    mapaInvertido += (j -> i)
                println(mapaGente)
                mapaInvertido = mapaGente.groupBy((k,v) => v)

                println(mapaInvertido)












