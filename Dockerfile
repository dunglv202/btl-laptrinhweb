# Install Tomcat & openjdk 8 (openjdk has java and javac)
FROM tomcat:8.5.99-jdk17-corretto

# Copy source files to tomcat folder structure
COPY ./target/btl.war /usr/local/tomcat/webapps/ROOT.war

# Serve Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]