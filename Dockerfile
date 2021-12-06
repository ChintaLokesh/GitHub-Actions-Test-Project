FROM zenika/alpine-maven
RUN apk update
RUN apk add curl jq

WORKDIR   /usr/Automation/

COPY ./   /usr/Automation/

ENTRYPOINT mvn clean verify