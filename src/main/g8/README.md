# i-MD Web Tool

---

###1. install jdk 7
###2. install scala 2.10.2
###3. install thrift 0.9.1
###4. install sbt 0.13.0
###5. install scalate
```bash
git clone https://github.com/ixiongdi/unfiltered-scalate.git  
cd unfiltered-scalate  
sbt
publishLocal
```
###6. sbt run
###7. browser http://localhost:$port$/hello
###8. for dev
```bash
sbt  
~re-start
```
###9. for prod
```bash
sbt  
oneJar  
exit  
<<<<<<< HEAD
java -jar target/scala-2.10/$name$_2.10-1.0-one-jar.jar
```
