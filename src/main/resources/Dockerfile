FROM openjdk:11.0.7
RUN mkdir -p /home
RUN chmod 777 /home
COPY minchecker-0.0.1-SNAPSHOT.jar /home/minchecker-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/minchecker-0.0.1-SNAPSHOT.jar"]