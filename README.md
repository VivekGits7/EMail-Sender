# EMail-Sender
📧 Emailing System – Java 17 + Spring Boot  A Spring Boot-based Emailing Application that allows users to send professional emails with attachments (like PDFs, images, etc.) directly from a REST API. Built using Java 17, Spring Boot, and Lombok, this project demonstrates secure email delivery using Gmail SMTP and clean backend architecture.

Setup & Installation

Clone the repository

``git clone https://github.com/VivekGits7/EMail-Sender.git
cd EMail-Sender``

Open in your IDE
Load it as a Maven (or Gradle) project.

Build the project
For Maven:

`mvn clean install`

Or for Gradle:

`./gradlew build`

Run the application
From IDE or via command line:

`mvn spring-boot:run`


The application by default will start on port 8080 (unless overridden in configuration).

Configuration

Configuration is done typically in application.properties or `application.yml`. Key properties include:

``spring.mail.host = smtp.gmail.com  
spring.mail.port = 587  # or 465 for SSL  
spring.mail.username = your_email@gmail.com  
spring.mail.password = your_app_password  
spring.mail.properties.mail.smtp.auth = true  
spring.mail.properties.mail.smtp.starttls.enable = true  
spring.mail.properties.mail.smtp.ssl.trust = smtp.gmail.com  ``

Api: To Send email with attachment POST: `localhost:8080/api/email/send`

``{
  "from": "vivekvish0134@gmail.com",
  "to": "yuvrajlodhi77@gmail.com",
  "subject": "Spring Boot Mail Test",
  "message": "Hi Yuvraj, this is a test email from Spring Boot with PDF attachment!",
  "filePath": "C:/Users/sandeep/Downloads/Send.pdf"
}``

**Sending Emails with Attachments**
The service handles:

Validating input (email format, non-null subject/body)

Building a MimeMessage or MimeMessageHelper

Attaching one or more files

Setting proper content types (text/plain or text/html)

Dispatching via JavaMailSender

If errors arise (e.g. SMTP authentication failure, invalid file), appropriate exception handling ensures meaningful responses.




