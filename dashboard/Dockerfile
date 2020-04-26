FROM maven:3.6.2-jdk-8

ENV PROJECT_DIR=/opt/project

RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

ADD ./dashboard/pom.xml $PROJECT_DIR
RUN mvn dependency:resolve

ADD ./dashboard/src/ $PROJECT_DIR/src
RUN mvn install

FROM openjdk:8-jdk
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/dashboard* $PROJECT_DIR/
CMD ["java","-jar","/opt/project/dashboard-01.01.01-SNAPSHOT.jar"]