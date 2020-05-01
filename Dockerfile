FROM alpine:latest
RUN apk update
RUN echo "http://dl-cdn.alpinelinux.org/alpine/edge/testing" >> /etc/apk/repositories
RUN apk add liquibase && apk add openjdk8 && apk add wget && apk add mysql-client
RUN wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.19.tar.gz
RUN tar -xzf mysql-connector-java-8.0.19.tar.gz && rm -rf mysql-connector-java-8.0.19.tar.gz
COPY src/main/resources/database /database
ARG FILE=liquibase.properties
RUN touch ${FILE}
RUN echo -e "driver:com.mysql.cj.jdbc.Driver" >> ${FILE}
RUN echo -e "classpath:/mysql-connector-java-8.0.19/mysql-connector-java-8.0.19.jar" >> ${FILE}
RUN echo -e "url:jdbc:mysql://mysql:3306/test-db" >> ${FILE}
RUN echo -e "username:nicol" >> ${FILE}
RUN echo -e "password:Password1" >> ${FILE}
RUN echo -e "changeLogFile:database/changelogs/master-changelog.yml" >> ${FILE}
CMD ["bin/sh"]
CMD ["liquibase", "update"]
