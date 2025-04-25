import scala.io.StdIn
//import scala.collection.mutable.ArrayBuffer
//import scala.collection.mutable.Map as MapMut

object EjerciciosFunciones:
    def main(args: Array[String]): Unit =
        var sw = true
        while sw do
            println("")
            println("*********************************************************************")
            println("1. Escribe una función pura que calcule el área de un rectángulo.")
            println("2. Crea una función de orden superior que reciba una lista de enteros y una función, y aplique esa función a cada elemento.")
            println("3. Crea una función que devuelva otra función que sume un número fijo a su argumento.")
            println("4. Dada una lista de palabras, usa map para obtener la longitud de cada palabra.")
            println("0. Salir")
            println("*********************************************************************")
            var opcion = StdIn.readLine()
            opcion match
                case "1" => println(areaRectangulo(4,7))
                case "2" => funcionListaEnteros()
                case "3" => funcionFuncionSuma()
                case "4" => logitudListaPalabras()
                case "0" => sw = false
                case _ => println("Opción inválida")

            def areaRectangulo(base: Int, altura: Int): Int = base * altura


            def funcionListaEnteros(): Unit =
                def modificaLista(listaEnteros: List[Int], f: Int => Int): Unit = for i <- listaEnteros do println((i + " -> " + f(i)) + " ")
                val multiplicaResta: Int => Int = _ * 3 - 3
                modificaLista(List(1,2,3,4,5,6), multiplicaResta)


            def funcionFuncionSuma(): Unit =
                def sumarDos(): Int => Int = (n: Int) => 2 + n
                val sumaNumero = sumarDos()
                println(sumaNumero(8))
                println(sumaNumero(0))



            def logitudListaPalabras(): Unit =
                val listaPalabras = List("Base", "Escolta", "Alero", "Ala-pivot", "Pivot")
                println(listaPalabras.map(_.length))
