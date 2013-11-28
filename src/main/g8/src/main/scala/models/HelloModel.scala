package $package$.models

import $package$.utils.ConnectDB
import $package$.utils.DataSerializer._

import com.mongodb.casbah.Imports._

object HelloModel extends ConnectDB {

  val collection = mongoClient("$name$")("say")

  import com.gensler.scalavro.types.AvroType
  import com.gensler.scalavro.io.AvroTypeIO
  import scala.util.{Try, Success, Failure}

  case class Person(name: String, age: Int)
  case class SantaList(nice: Seq[Person], naughty: Seq[Person])

  val santaList = SantaList(
    nice = Seq(
      Person("John", 17),
      Person("Eve", 3)
    ),
    naughty = Seq(
      Person("Jane", 25),
      Person("Alice", 65)
    )
  )

  val santaListType = AvroType[SantaList]

  val json = santaListType.io writeJson santaList

  /*
    json.prettyPrint now yields:

    {
      "nice": [{
        "name": "John",
        "age": 17
      }, {
        "name": "Eve",
        "age": 3
      }],
      "naughty": [{
        "name": "Jane",
        "age": 25
      }, {
        "name": "Alice",
        "age": 65
      }]
    }

  */

  santaListType.io.readJson(json) match {
    case Success(readResult) => assert(readResult == santaList) // true
    case Failure(cause)      => // handle failure...
  }

  def say(word: String) = {
    val user = new User("xd", 7, "yellow")
    collection += MongoDBObject("word" -> word)
    collection.findOne(MongoDBObject("word" -> word)) match {
      case Some(o) => o
      case _ => toJSON(new Error("1"))
    }
    json.prettyPrint
    user.toString()
  }
}
