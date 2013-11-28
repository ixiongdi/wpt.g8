import ScalateKeys._

com.github.retronym.SbtOneJar.oneJarSettings

org.scalastyle.sbt.ScalastylePlugin.Settings

seq(scalateSettings:_*)

seq(sbtavro.SbtAvro.avroSettings : _*)

seq(Revolver.settings: _*)

// seq(lessSettings:_*)

// seq(coffeeSettings: _*)

seq(jsSettings : _*)

seq(lessSettings : _*)

// Scalate Precompilation and Bindings
scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
  Seq(
    TemplateConfig(
      base / "scala" / "views",
      Seq(),
      Seq(),
      Some("")
    )
  )
}

name := "$name$"

version := "1.0"

scalaVersion := "2.10.2"

(stringType in avroConfig) := "String"

seq(com.github.bigtoast.sbtthrift.ThriftPlugin.thriftSettings: _*)

(sourceDirectories in (Compile, JsKeys.js)) <<=
  (sourceDirectory in Compile) {
    srcDir =>
      Seq(
        srcDir / "js",
        srcDir / "coffee"
      )
  }

(sourceDirectories in (Compile, LessKeys.less)) <<=
  (sourceDirectory in Compile) {
    srcDir =>
      Seq(
        srcDir / "css",
        srcDir / "less"
      )
  }

(Keys.compile in Compile) <<= Keys.compile in Compile dependsOn (JsKeys.js in Compile)

(Keys.compile in Compile) <<= Keys.compile in Compile dependsOn (LessKeys.less in Compile)

(resourceManaged in (Compile, JsKeys.js)) <<= (sourceDirectory in Compile)(_ / "resources" / "public" / "js")

(resourceManaged in (Compile, LessKeys.less)) <<= (sourceDirectory in Compile)(_ / "resources" / "public" / "css")


resolvers ++= Seq(
  "OSChina Maven Repo" at "http://maven.oschina.net/content/groups/public/",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "com.top10" %% "scala-redis-client" % "1.16.0",
  "com.twitter" %% "util-core" % "6.4.0",
  "com.typesafe" % "config" % "1.0.2",
  "net.databinder" %% "unfiltered-json4s" % "0.7.0",
  "net.databinder" %% "unfiltered-netty-uploads" % "0.7.0",
  "net.databinder" %% "unfiltered-netty-websockets" % "0.7.0",
  "net.databinder" %% "unfiltered-scalate" % "0.7.0",
  "net.debasishg" %% "redisclient" % "2.11",
  "org.apache.thrift" % "libthrift" % "0.9.1",
  "org.mongodb" %% "casbah" % "2.6.3",
  "org.webjars" % "bootstrap" % "3.0.1",
  "com.gensler" %% "scalavro" % "0.6.0"
)
