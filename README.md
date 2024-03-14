# Setup local

Follow these step to setup for local development

1. Traverse to project folder
2. Configure .env file if we use local database
3. Declare database information/credentials `./src/main/java/cf/laptrinhweb/btl/constant/CSDL.java`
4. Package application with command `mvn clean package`
5. Build docker image for application using `docker build --tag btl/lanka:latest .`
6. Run `docker compose up -d`
7. Visit `localhost:8080`

**_Note:_** _`initial_data.sql` file from root folder contains initial schema & data setup_
