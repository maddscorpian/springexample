echo 'Killing existing process'
kill -9 $(lsof -ti:8761)
echo 'Deleting logs'
rm -r nohup.out 
echo 'Remove old files'
rm -r target
echo 'building package'
mvn package
echo 'Starting new instance'
nohup java -jar target/Service-Registery-0.0.1-SNAPSHOT.jar &
