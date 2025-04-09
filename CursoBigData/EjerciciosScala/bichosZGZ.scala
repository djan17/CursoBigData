import upickle.default.{read => uread, write => uwrite, ReadWriter, macroRW} // Importamos macroRW para generar automáticamente el ReadWriter
import os.{read => _, _} // Excluimos el método read de os-lib
import com.mongodb.client.{MongoClients, MongoCollection}
import org.bson.Document

case class Bicho(
        id: Int,
        title: String,
        especie: String,
        raza: String,
        sexo: String,
        peligroso: String,
        fechaNacimiento: String,
        capa: String,
        tamagno: String,
        foto: String,
        lugar: String,
        disponibilidad: String,
        identificadoIngreso: String,
        microchip: String,
        pasaporteISO: String,
        pasaporteNum: String,
        rabia: String,
        fechaRabia: String,
        esterilizado: String,
        enCMPA: String,
        creationDate: String,
        lastUpdated: String
)   

object Bicho {
  implicit val rw: ReadWriter[Bicho] = macroRW
}

object MongoExample {
  def main(args: Array[String]): Unit = {
    val mongoClient = MongoClients.create("mongodb://localhost:27017")
    val database = mongoClient.getDatabase("bichosZGZ")
    val collection: MongoCollection[Document] = database.getCollection("bichos")
    val rutaArchivo = os.pwd / "anims.json"
    val contenidoJSON = os.read(rutaArchivo)
    val bichejo = uread[Bicho](contenidoJSON)
    val bichodoc = new Document("id", bichejo.id)
      .append("title", bichejo.title)
      .append("especie", bichejo.especie)
      .append("raza", bichejo.raza)
      .append("sexo", bichejo.sexo)
      .append("peligroso", bichejo.peligroso)
      .append("fechaNacimiento", bichejo.fechaNacimiento)
      .append("capa", bichejo.capa)
      .append("tamagno", bichejo.tamagno)
      .append("foto", bichejo.foto)
      .append("lugar", bichejo.lugar)
      .append("disponibilidad", bichejo.disponibilidad)
      .append("identificadoIngreso", bichejo.identificadoIngreso)
      .append("microchip", bichejo.microchip)
      .append("pasaporteISO", bichejo.pasaporteISO)
      .append("pasaporteNum", bichejo.pasaporteNum)
      .append("rabia", bichejo.rabia)
      .append("fechaRabia", bichejo.fechaRabia)
      .append("esterilizado", bichejo.esterilizado)
      .append("enCMPA", bichejo.enCMPA)
      .append("creationDate", bichejo.creationDate)
      .append("lastUpdated",bichejo.lastUpdated)
    collection.insertOne(bichodoc)

 
    // Cerrar cliente
    mongoClient.close()
  }
}