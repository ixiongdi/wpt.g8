package $package$.utils

import com.mongodb.casbah.Imports._
import com.top10.redis._
import com.typesafe.config._

abstract class ConnectDB {
  val conf = ConfigFactory.load("config/$name$.conf")
  val mongoClient = MongoClient(conf.getString("mongo.host"), conf.getInt("mongo.port"))
  val redisClient = new SingleRedis(conf.getString("redis.host"), conf.getInt("redis.port"))
}
