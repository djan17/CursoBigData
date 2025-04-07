import com.mongodb.client.{MongoClients, MongoCollection, MongoDatabase}
import org.bson.Document
import scala.io.StdIn

object MongoDBCRUD {
  private val client = MongoClients.create("mongodb://localhost:27017")
  private var database: MongoDatabase  = client.getDatabase("biblioteca")
  private var collection: MongoCollection[Document] = database.getCollection("libros")

  case class Libro(titulo: String, isbn: String, autor: String) //Es un tipo especial de clase en Scala diseñada para modelar datos inmutables.

  def main(args: Array[String]): Unit = {
    println("Introduce nombre de la BD")
    val nombreDB = StdIn.readLine()
    println("Introduce nombre de la colección")
    val nombreColl = StdIn.readLine()
    database = client.getDatabase(nombreDB)
    collection = database.getCollection(nombreColl)
    var salir = false
    while (!salir) {
      mostrarMenu()
      StdIn.readLine() match {
        case "0" => iniciarDB()
        case "1" => crearLibro()
        case "2" => listarLibros()
        case "3" => buscarPorISBN()
        case "4" => actualizarLibro()
        case "5" => eliminarLibro()
        case "6" => salir = true
        case _ => println("Opción inválida")
      }
    }
    client.close()
  }

  private def mostrarMenu(): Unit = {
    println("\n=== MENU CRUD LIBROS ===")
    println("0. Inicializar BD")
    println("1. Crear libro")
    println("2. Listar todos los libros")
    println("3. Buscar libro por ISBN")
    println("4. Actualizar libro")
    println("5. Eliminar libro")
    println("6. Salir")
    print("Seleccione opcion: ")
  }

  private def crearLibro(): Unit = {
    val libro = solicitarDatosLibro()
    val doc = new Document()
      .append("titulo", libro.titulo)
      .append("isbn", libro.isbn)
      .append("autor", libro.autor)
    
    collection.insertOne(doc)
    println("\nLibro creado exitosamente!")
  }

  private def listarLibros(): Unit = {
    println("\n=== LISTA DE LIBROS ===")
    val resultados = collection.find().iterator()
    while (resultados.hasNext) {
      mostrarLibro(resultados.next())
    }
  }

  private def buscarPorISBN(): Unit = {
    print("Ingrese ISBN a buscar: ")
    val isbn = StdIn.readLine()
    val filtro = new Document("isbn", isbn)
    val libro = collection.find(filtro).first()
    
    if (libro != null) {
      println("\nLibro encontrado:")
      mostrarLibro(libro)
    } else {
      println("\nLibro no encontrado")
    }
  }

  private def actualizarLibro(): Unit = {
    print("Ingrese ISBN del libro a actualizar: ")
    val isbn = StdIn.readLine()
    val filtro = new Document("isbn", isbn)
    val libroExistente = collection.find(filtro).first()
    
    if (libroExistente != null) {
      val nuevosDatos = solicitarDatosLibro()
      val actualizacion = new Document("$set", new Document()
        .append("titulo", nuevosDatos.titulo)
        .append("autor", nuevosDatos.autor)
        .append("isbn", nuevosDatos.isbn))
      
      collection.updateOne(filtro, actualizacion)
      println("\nLibro actualizado correctamente")
    } else {
      println("\nLibro no encontrado")
    }
  }

  private def eliminarLibro(): Unit = {
    print("Ingrese ISBN del libro a eliminar: ")
    val isbn = StdIn.readLine()
    val filtro = new Document("isbn", isbn)
    val resultado = collection.deleteOne(filtro)
    
    if (resultado.getDeletedCount > 0) {
      println("\nLibro eliminado correctamente")
    } else {
      println("\nLibro no encontrado")
    }
  }

  private def solicitarDatosLibro(): Libro = {
    print("Titulo: ")
    val titulo = StdIn.readLine()
    print("ISBN: ")
    val isbn = StdIn.readLine()
    print("Autor: ")
    val autor = StdIn.readLine()
    
    Libro(titulo, isbn, autor)
  }

  private def mostrarLibro(doc: Document): Unit = {
    println(s"""
      Titulo: ${doc.getString("titulo")}
      ISBN: ${doc.getString("isbn")}
      Autor: ${doc.getString("autor")}
      ---------------------------""")
  }

    private def iniciarDB(): Unit = {
        for i <- 1 to 10 do
            val doc = new Document()
            .append("titulo", "titulo" + i)
            .append("isbn", "000" + i)
            .append("autor", "autor" + i)
            collection.insertOne(doc)
        
    }

}