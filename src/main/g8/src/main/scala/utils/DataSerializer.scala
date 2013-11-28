package $package$.utils

import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TSimpleJSONProtocol
import org.apache.thrift.TBase
import org.apache.thrift.TDeserializer
import org.apache.thrift.TFieldIdEnum
import org.apache.thrift.TSerializer

object DataSerializer {

  val deserializer = new TDeserializer(new TBinaryProtocol.Factory())
  val serializer = new TSerializer(new TSimpleJSONProtocol.Factory())

  def DBObject2JSON(o: DBObject) = o.toString
  def DBObject2Thrift(o: DBObject, t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum])
    (convertor: String => TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = {
    JSON2Thrift(DBObject2JSON(o), t)(convertor)
  }
  def JSON2DBObject(s: String) = JSON.parse(s).asInstanceOf[DBObject]
  def JSON2Thrift(s: String, t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum])
    (convertor: String => TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = {
    convertor(s)
  }
  def Thrift2DBObject(t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = {
    JSON2DBObject(Thrift2JSON(t))
  }
  def Thrift2JSON(t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = {
    serializer.toString(t)
  }

  def toJSON(o: DBObject) = o.toString
  def toJSON(t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = serializer.toString(t)

  def toThrift(o: DBObject, t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = {
  }

  def toThrift(s: String, t: TBase[_ <: TBase[_, _], _ <: TFieldIdEnum]) = {
  }

}
