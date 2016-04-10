name := "jobServerFun"
organization := "at.ac.tuwien.ase2016.rebeat.prototype.DrillDownArtist02"
version := "0.0.1.SNAPSHOT"

//chosen to match the current job-server docker image
scalaVersion := "2.10.5"

scalacOptions ++= Seq("-deprecation")

//chosen to match the current job-server docker image
lazy val spark = "1.5.2"

resolvers += "Job Server Bintray" at "https://dl.bintray.com/spark-jobserver/maven"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % spark % "provided",
  "org.apache.spark" %% "spark-sql" % spark % "provided",
  "com.stratio.datasource" %% "spark-mongodb" % "0.11.1",
  "spark.jobserver" %% "job-server-api" % "0.6.1" % "provided",
  "spark.jobserver" %% "job-server-extras" % "0.6.1" % "provided",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
