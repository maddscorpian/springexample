echo 'Killing existing process'
kill -9 $(lsof -ti:8001)
echo 'Deleting log files'
rm -r nohup.out 
echo 'Remove old files'
rm -r target
echo 'building package'
mvn package
echo 'Starting new instance'
nohup java -jar target/Department-Service-0.0.1-SNAPSHOT.jar &
