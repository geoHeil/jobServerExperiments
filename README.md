# Experiments with spark job server

  - install scala & sbt
  - create a jar file using `sbt assembly`
  
Based on [https://github.com/spark-jobserver/spark-jobserver/blob/master/job-server-extras/src/spark.jobserver/SqlTestJob.scala](https://github.com/spark-jobserver/spark-jobserver/blob/master/job-server-extras/src/spark.jobserver/SqlTestJob.scala)
  
**Execute on  spark-jobserver**

  - this requires a running instance of the server. Execute the `docker-compose.yml` file
  - upload the Jar
  
  ```
  curl --data-binary @target/scala-2.10/jobServerFun-assembly-0.0.1.SNAPSHOT.jar 192.168.99.100:8091/jars/fun
  ```
  
  - to run a one-off job from this jar (Ad-hoc Mode - Single, Unrelated Jobs, Transient Context).
  - The Jobs require the SQL context. As far as I understand it sql context needs to be initialized first.
      
        ```
        curl -d "" '192.168.99.100:8091/contexts/sql-context?context-factory=spark.jobserver.context.SQLContextFactory'
  
        ```
      - you should see the context named sql-context in the section Contexts on the jobserver
  - to run the application execute the following statements. Add `&sync=true` to directly receive the results
  - here is a (failed) approach to get the sql context to work
  
    ```
    WORKS (but no sql context) curl -d "input.string = a b c a b see" "192.168.99.100:8091/jobs?appName=fun&classPath=fun.WordCountExample&sync=true"
    FAILS (sql context) curl -d "sql = \"select * from addresses limit 10\"" "192.168.99.100:8091/jobs?appName=fun&classPath=fun.SqlLoaderJob&context=sql-context&sync=true"
    ```
 
 # Problems
 
 
