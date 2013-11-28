package $package$

import $package$.routes._

import com.typesafe.config._

object WeiXinServer {
  def main(args: Array[String]): Unit = {
    val urls = getClass().getClassLoader().getResources("META-INF/resources/webjars/")
    val us = scala.collection.mutable.Set[java.net.URL]()
    while (urls.hasMoreElements) {
      us += urls.nextElement
    }

    val conf = ConfigFactory.load("config/$name$.conf")
    var server = unfiltered.netty.Http(conf.getInt("http.port"))
    server = server.resources(getClass().getResource("/static/"))
    for (u <- us) {
      server = server.resources(u)
    }
    server = server.plan(HelloRoute.display)
    server.run()
  }
}
