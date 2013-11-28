resolvers += "bigtoast-github" at "http://bigtoast.github.com/repo/"

addSbtPlugin("com.github.bigtoast" % "sbt-thrift" % "0.7")

addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.4.2")

addSbtPlugin("org.scala-sbt.plugins" % "sbt-onejar" % "0.8")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

resolvers += "sbt-plugin-releases" at "http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases"

addSbtPlugin("com.cavorite" % "sbt-avro" % "0.3.2")

resolvers += "spray repo" at "http://repo.spray.io" // not needed for sbt >= 0.12

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.1")

resolvers += Resolver.url(
  "bintray-sbt-plugin-releases",
    url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
      Resolver.ivyStylePatterns)

resolvers += "softprops-maven" at "http://dl.bintray.com/content/softprops/maven"

// addSbtPlugin("me.lessis" % "less-sbt" % "0.2.1")

// addSbtPlugin("me.lessis" % "coffeescripted-sbt" % "0.2.3")

resolvers += Resolver.url("untyped", url("http://ivy.untyped.com"))(Resolver.ivyStylePatterns)

// Add whichever plugins you want to use:

addSbtPlugin("com.untyped" % "sbt-js"       % "0.6")

addSbtPlugin("com.untyped" % "sbt-less"     % "0.6")
