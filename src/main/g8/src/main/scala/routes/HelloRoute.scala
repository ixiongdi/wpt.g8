package $package$.routes

import $package$.utils.BaseRoute
import $package$.controllers.HelloController

import unfiltered.netty._
import unfiltered.netty.request._
import unfiltered.request._
import unfiltered.response._
import unfiltered.scalate._
import unfiltered.netty.websockets.{_ => Pass}

object HelloRoute extends BaseRoute {

  var sockets = new scala.collection.mutable.ListBuffer[WebSocket]()
  val websockets = unfiltered.netty.websockets.Planify {
    case Path("/websocket") => {
      case Open(s) => sockets += s
      case Message(s, Text(str)) => sockets foreach(_.send(str.reverse))
      case Close(s) => sockets -= s
      case Error(s, e) => println("error %s" format e.getMessage)
    }
  }

  val display = async.Planify {
    case req@GET(Path("/")) => req.respond(view)
    case req@GET(Path("/ping")) => req.respond(ResponseString("pong"))
    case req@GET(Path("/hello")) => req.respond(HtmlContent ~> Scalate(req, "hello.ssp"))
    case req@GET(Path(Seg("hello":: "say" :: word :: Nil))) =>
      req.respond(JsonContent ~> ResponseString(HelloController.say(word)))
    case _ => Pass
  }

  val view = Html(
    <html>
      <body>
       <a href="/ping">ping</a>
       <a href="/hello">helo</a>
       <a href="/hello/say/love">say</a>
      </body>
    </html>
  )
}
