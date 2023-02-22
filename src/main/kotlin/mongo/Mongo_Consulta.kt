package mongo

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.bson.Document
import java.util.logging.Level
import java.util.logging.LogManager

fun main(){
    LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE)

    val con = MongoClient(MongoClientURI("mongodb://ad:ieselcaminas@89.36.214.106/?authSource=test"))
    val bd = con.getDatabase("test")

    val ordenar = Document()
    ordenar.put("precio", -1)

    val comunidades = bd.getCollection("EstadisticaInternet").find().sort(ordenar)

    for (comunidad in comunidades)
        System.out.println(comunidad.get("Nom").toString() + "      " + comunidad.get("InternetDiari") + " " + comunidad.get("Comprat3Mesos"))

    con.close()
}