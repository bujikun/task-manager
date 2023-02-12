#!/bin/bash
echo "Executing run.sh"
dos2unix mvnw
./mvnw dependency:resolve && ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005" &
while true; do
  inotifywait -e modify,create,delete,move -r ./src/ ./pom.xml && ./mvnw clean && ./mvnw compile #&& clear
done