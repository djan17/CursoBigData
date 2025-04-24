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
            println("5. Intersección de claves y suma de valores")
            println("6. Palabras únicas en dos textos")
            println("7. Map de frecuencias y filtrado")
            println("0. Salir")
            println("*********************************************************************")
            var opcion = StdIn.readLine()
            opcion match
                case "1" => listaDuplicados()
                case "2" => segundoMayor()
                case "3" => filtraTransforma()
                case "4" => invierteMapa()
                case "5" => clavesValores()
                case "6" => palabrasUnicas()
                case "7" => freqListado()
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
                val mapaGente = Map("Ana" -> 30, "Luis" -> 25, "Eva" -> 30, "Juan" -> 25)
                var mapaInvertido = Map[Int, Map[String, Int]]()
                var mapaFinal = MapMut[Int, Set[String]]()
                mapaInvertido = mapaGente.groupBy((k,v) => v)
                mapaInvertido.foreach((k,v) => (mapaFinal(k) = v.keys.toSet))
                println(mapaFinal)


            def clavesValores(): Unit =
                val m1 = Map("a" -> 1, "b" -> 2, "d" -> 3)
                val m2 = Map("b" -> 5, "c" -> 7, "d" -> 10)
                val m3 = MapMut[String, Int]()
                for (k,v) <- m1 do
                    if m2.contains(k) then
                        m3 += (k -> (v + m2(k)))
                println(m3)


            def palabrasUnicas(): Unit =
                val texto1 = List("sol", "luna", "estrella", "sol", "mar","patata")
                val texto2 = List("mar", "sol", "luna", "luna", "cielo","patata")
                val aux1 = texto1.groupBy((k) => k).filter((i, j) => j.length == 1)
                val aux2 = texto2.groupBy((k) => k).filter((i, j) => j.length == 1)
                val combi = (aux1.keys.toSet & aux2.keys.toSet)
                println(combi)


            def freqListado():Unit = 
                val palabras = List("a", "b", "a", "c", "b", "a", "d")
                val mapaPalabras = palabras.groupBy((k) => k).filter((i, j) => j.length > 1)
                val longPalabras = MapMut[String, Int]()
                mapaPalabras.foreach((k,v) => (longPalabras(k) = v.length))
                println(longPalabras)    
        









