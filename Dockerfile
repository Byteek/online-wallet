FROM tomcat:latest
COPY target/*.war /usr/local/tomcat/webapps/wallet.war
CMD ["catalina.sh", "run"]