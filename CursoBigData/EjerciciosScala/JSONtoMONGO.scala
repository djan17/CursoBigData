import sttp.client3._
import sttp.client3.okhttp.OkHttpSyncBackend
import io.circe._
import io.circe.parser._
import io.circe.generic.auto._  // Importación clave para derivación automática
import com.mongodb.client.{MongoClients, MongoCollection, MongoDatabase}
import org.bson.Document
import scala.collection.mutable.ArrayBuffer


object MongoDBCRUD {
  private val client = MongoClients.create("mongodb://localhost:27017")
  private val database: MongoDatabase = client.getDatabase("blog")
  private val collection: MongoCollection[Document] = database.getCollection("posts")

  
  case class Posts(
    userId: Int,
    id: Int,
    title: String,
    body: String
  )

  case class ListaPosts(
    lista: ArrayBuffer[Posts]
  )

  def main(args: Array[String]): Unit = {
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
    
    backend.close()
  }
}