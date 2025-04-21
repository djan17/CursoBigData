import sttp.client3._
import sttp.client3.okhttp.OkHttpSyncBackend
//import io.circe._
//import io.circe.parser._
//import io.circe.generic.auto._  // Importación clave para derivación automática
import com.mongodb.client.{MongoClients, MongoCollection, MongoDatabase}
import org.bson.Document
import scala.collection.mutable.ArrayBuffer
import cats.instances.double
import scala.io.StdIn
import play.api.libs.json._


object Mamgateka:
    private val client = MongoClients.create("mongodb://localhost:27017")
    private val database: MongoDatabase = client.getDatabase("mangateka")
    private val collectLibros: MongoCollection[Document] = database.getCollection("libros")  

    class Autor(private val _nombre: String, private val _apellido: String):
        def nombre: String = _nombre
        def apellido: String = _apellido
        //def nombre_=(nombre : String): Unit = _nombre = nombre
        //def apellido_=(apellido : String): Unit = _apellido = apellido

    class Libro(private val _titulo: String, private val _isbn: String, private val _genero: String, private var _autor: Autor):
        def this(titulo: String, isbn: String, genero: String) = this(titulo, isbn, genero, new Autor("",""))
        def titulo: String = _titulo
        def isbn: String = _isbn
        def genero: String = _genero
        def autor: Autor = _autor
        def mostrarDetalles(): Unit =
            println()
            println(s"Título: $titulo")
            println(s"ISBN: $isbn")
            println(s"Genero: $genero")
            println(s"${autor.nombre} - ${autor.apellido}")
            println()
    /*
    case class Autor(
        nombre: String,
        apellido: String
    )
    
    case class Libro(
        titulo: String,
        isbn: String,
        genero: String,
        autor: Autor
    )

    case class ListaPosts(
        lista: ArrayBuffer[Posts]
    )*/

    def main(args: Array[String]): Unit =
        var sw = true
        while sw do
            println("")
            println("*********************************************************************")
            println("1. Insertar libro por teclado")
            println("2. Insertar libro por fichero")        
            println("3. Insertar lista de libros")
            println("0. Salir")
            println("*********************************************************************")
            var opcion = StdIn.readLine()
            opcion match
                case "1" => insertaLibroTeclado()
                case "2" => insertaLibroFichero()
                case "3" => insertaListaLibros()
                case "0" => sw = false
                case _ => println("Opción inválida")

        def insertaLibroTeclado(): Unit =
            println("Inserta el título del libro: ")
            var titulo = StdIn.readLine()
            println("Inserta el ISBN del libro: ")
            var isbn = StdIn.readLine()
            println("Inserta el género del libro: ")
            var genero = StdIn.readLine()
            println("Inserta el nombre del autor: ")
            var nombre = StdIn.readLine()
            println("Inserta el apellido del autor: ")
            var apellido = StdIn.readLine()
            val autor = Json.obj("nombre" -> nombre, "apellidos" -> apellido)
            var docLibro = new Document()
                .append("Titulo", titulo)
                .append("ISBN", isbn)
                .append("Genero", genero)
                .append("Autor", autor)
            collectLibros.insertOne(docLibro)
            println("Libro guardado en la BD")

        def insertaLibroFichero(): Unit =
            println("Página en construcción")

        def insertaListaLibros(): Unit =
            println("Página en construcción")

    /*
        def indiPost(post: Posts): Unit ={
            val doc = new Document()
            .append("USER_ID", post.userId)
            .append("ID", post.id)
            .append("Title", post.title)
            .append("Body", post.body)
            //collection.insertOne(doc)
            println(s"Guardando documento")
        }

        val backend = OkHttpSyncBackend()
        var i = 1
        var sw = true
        while sw do
            val request = basicRequest
            .get(uri"https://jsonplaceholder.typicode.com/posts/")

            val response = request.send(backend)
            
            response.body match {
            case Right(json) =>
                parse(json) match {
                case Right(parsedJson) =>
                    parsedJson.as[ListaPosts] match {
                        case Right(post) =>
                            /*  for i <- parsedJson do
                                indiPost(post)*/
                            println(post.lista(1))
                        case Left(decodingError) =>  // Renombrado para evitar conflicto
                            println(s"Error parseando JSON: $decodingError")
                            sw = false
                    }
                case Left(parsingError) =>
                    println(s"Error en el formato JSON: $parsingError")
                    sw = false
                }
            case Left(requestError) =>
                println(s"Error en la solicitud: $requestError")
                sw = false
            }
            i += 1
        */
        client.close()