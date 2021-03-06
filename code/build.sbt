organization := "com.feth"

name := "play-authenticate"

scalaVersion := "2.11.1"

crossScalaVersions := Seq("2.10.4", "2.11.1")

javacOptions ++= {
  if (System.getProperty("rt.path") != null)  Seq("-source", "1.6", "-target", "1.6", "-bootclasspath", System.getProperty("rt.path"))
  else                                        Seq()
}

version := "0.6.5-SNAPSHOT"

publishTo <<= (version) { version: String =>
  if (version.trim.endsWith("SNAPSHOT")) Some(Resolver.file("file",  new File( "../repo/snapshots" )))
  else                                   Some(Resolver.file("file",  new File( "../repo/releases" )))
}

libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.3.4",
  "com.feth" %% "play-easymail" % "0.6.4-SNAPSHOT",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "commons-lang" % "commons-lang" % "2.6",
  javaCore,
  cache,
  javaWs
)

resolvers ++= Seq(
  "Apache" at "http://repo1.maven.org/maven2/",
  "jBCrypt Repository" at "http://repo1.maven.org/maven2/org/",
  "play-easymail (release)" at "http://joscha.github.io/play-easymail/repo/releases/",
  "play-easymail (snapshot)" at "http://joscha.github.io/play-easymail/repo/snapshots/"
)

publishArtifact in packageDoc := false

lazy val root = (project in file(".")).enablePlugins(PlayJava)
