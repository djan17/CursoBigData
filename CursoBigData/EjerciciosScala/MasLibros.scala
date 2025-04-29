import com.mongodb.client.{MongoClients, MongoCollection}
import org.bson.Document
import scala.io.Source

case class Libro(titulo: String, isbn: String, autor: String, editorial: String, paginas: String)
case class Autor(id: String, nombre: String, apellido: String)

object CSVaMongo:
  def main(args: Array[String]): Unit =
    val mongoClient = MongoClients.create("mongodb://localhost:27017")
    val database = mongoClient.getDatabase("librosdeCSV")
    val collectionLibros: MongoCollection[Document] = database.getCollection("libros")
    val collectionAutores: MongoCollection[Document] = database.getCollection("autores")
    var ruta = "libros.csv"
    val libros: List[Libro] = Source.fromFile(ruta)
      .getLines()
      .drop(1)
      .map { linea => 
        val Array(titulo,isbn,autor,editorial,paginas) = linea.split(",", 5)
        Libro(titulo.trim, isbn.trim, autor.trim, editorial.trim, paginas.trim)
      }
      .toList

    for i <- libros do
      val doc = new Document()
      .append("Titulo",i.titulo)
      .append("ISBN",i.isbn)
      .append("Autor",i.autor.toInt)
      .append("Editorial",i.editorial)
      .append("Paginas",i.paginas.toInt)
      collectionLibros.insertOne(doc)
      println("Libro insertado")

    ruta = "autores.csv"
    val autores: List[Autor] = Source.fromFile(ruta)
      .getLines()
      .drop(1)
      .map {linea =>
        val Array(id,nombre,apellido) = linea.split(",", 5)
        Autor(id.trim, nombre.trim, apellido.trim)
      }
      .toList

    for i<- autores do
      val doc = new Document()
      .append("ID",i.id.toInt)
      .append("Nombre",i.nombre)
      .append("Apellido",i.apellido)
      collectionAutores.insertOne(doc)
    println("Autor insertado")
    println()
    println("Libro con más páginas:")      
    println(libros.sortWith(_.paginas < _.paginas)(0))
    println("Autor con más libros:")
    println(autores.find(_.id.toInt == (libros.groupBy(_.autor).toSeq.sortBy(_._2.length).last._1.toString().toInt)).get.nombre +
      " " + autores.find(_.id.toInt == (libros.groupBy(_.autor).toSeq.sortBy(_._2.length).last._1.toString().toInt)).get.apellido)

    mongoClient.close()