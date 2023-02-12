#get the image of the maven-JDK version
FROM maven
#Update and upgrade packages
RUN apt-get update && apt-get -y upgrade
#install inotify-tools to help monitor code changes
#install dos2unix to to workaround to normalize the line endings in files created in
#Windows and make them able to run inside the unix-based container.
#netcat is needed by wait-for.sh
RUN apt-get install -y inotify-tools dos2unix
#path of the working directory
WORKDIR /app
#copy the maven wrappers and pom.xl into the working directory
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
#run maven to fetch dependency
#RUN mvn dependency:go-offline
#copy source code into image
COPY src ./src
#copy the run script, for live reloading during dev
COPY run.sh ./
#run the spring boot app
#CMD ["./mvnw","spring-boot:run"]
#start the application
#CMD mvn spring-boot:run app will be started by run.sh
EXPOSE 8080
