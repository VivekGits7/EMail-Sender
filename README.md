# 📧 EMail-Sender

**Emailing System – Java 17 + Spring Boot**

A Spring Boot-based Emailing Application that allows users to send professional emails with attachments (like PDFs, images, etc.) directly from a REST API.  
Built using **Java 17**, **Spring Boot**, and **Lombok**, this project demonstrates secure email delivery using **Gmail SMTP** and a clean backend architecture.

---

## 🚀 Features

- Send plain text or HTML emails via REST API  
- Add file attachments (PDFs, images, etc.)  
- Secure Gmail SMTP configuration (TLS/SSL support)  
- Lightweight and production-ready setup  
- Easy-to-use email model with Lombok  
- Centralized error handling and validation  
- Runs on **Spring Boot 3+ / Java 17**

---

## 🛠️ Tech Stack

| Technology | Description |
|-------------|-------------|
| **Java 17** | Programming Language |
| **Spring Boot** | Application Framework |
| **Spring Mail (JavaMailSender)** | Email Service Integration |
| **Lombok** | Boilerplate Code Reduction |
| **Maven** | Build & Dependency Management |

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the repository

```bash
git clone https://github.com/VivekGits7/EMail-Sender.git
cd EMail-Sender
```

### 2️⃣ Open in your IDE
Import the project as a **Maven Project** (or Gradle, if converted).

### 3️⃣ Build the project

For Maven:
```bash
mvn clean install
```

Or for Gradle:
```bash
./gradlew build
```

### 4️⃣ Run the application

From IDE or via terminal:
```bash
mvn spring-boot:run
```

The application by default runs on **http://localhost:8080**

---

## ⚙️ Configuration

Set your Gmail SMTP credentials inside the `application.properties` or `application.yml` file.

```properties
spring.mail.host = smtp.gmail.com  
spring.mail.port = 587  # use 465 for SSL  
spring.mail.username = your_email@gmail.com  
spring.mail.password = your_app_password  
spring.mail.properties.mail.smtp.auth = true  
spring.mail.properties.mail.smtp.starttls.enable = true  
spring.mail.properties.mail.smtp.ssl.trust = smtp.gmail.com  
```

> ⚠️ **Important:**  
> - For Gmail, use an **App Password** (not your actual password).  
> - Keep credentials secret — don’t commit them to GitHub!  
> - You can also use environment variables for security.

---

## 🔗 API Endpoint

### **POST:** `http://localhost:8080/api/email/send`

Send an email (with or without attachment).

#### Example JSON Request:
```json
{
  "from": "vivekvish0134@gmail.com",
  "to": "yuvrajlodhi77@gmail.com",
  "subject": "Spring Boot Mail Test",
  "message": "Hi Yuvraj, this is a test email from Spring Boot with PDF attachment!",
  "filePath": "C:/Users/sandeep/Downloads/Send.pdf"
}
```

---

## 📎 Sending Emails with Attachments

The backend service handles:

- ✅ Validating inputs (email format, non-null subject/body)  
- 📨 Building a `MimeMessage` or `MimeMessageHelper`  
- 📂 Attaching one or more files  
- 🧩 Setting correct content types (text/plain or text/html)  
- 🚀 Dispatching via `JavaMailSender`  

If any error occurs (e.g. SMTP authentication failure, invalid file path), the service gracefully handles exceptions and returns a meaningful error response.

---

## 🧰 Example Email Model (POJO)

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private String from;
    private String to;
    private String subject;
    private String message;
    private String filePath;
}
```

This POJO maps the incoming JSON request directly into a Java object using Lombok annotations.

---

## 🧠 How It Works

1. The REST Controller receives the request body.  
2. The Service Layer builds a MIME email using `JavaMailSender`.  
3. If a `filePath` is provided, the file is attached automatically.  
4. The message is then dispatched securely through Gmail SMTP.  
5. A success or failure response is returned to the client.

---

## 🧾 Sample Success Response

```json
{
  "status": "SUCCESS",
  "message": "Email sent successfully to yuvrajlodhi77@gmail.com"
}
```

---

## 🧩 Future Enhancements

- 🧑‍🤝‍🧑 Support for multiple recipients (CC, BCC)  
- 🧱 HTML Template support (Thymeleaf/Freemarker)  
- 🕓 Schedule emails using Quartz or Spring Scheduler  
- 📈 Email delivery tracking  
- 🔐 OAuth 2.0 Gmail Integration  
- 🌐 UI-based email sender dashboard (React/Next.js)

---

## 🧑‍💻 Contribution Guide

Contributions are welcome! 🚀  
Follow these steps:

1. **Fork** the repository  
2. Create a **feature branch** → `git checkout -b feature/YourFeatureName`  
3. Commit your changes → `git commit -m "Added new feature"`  
4. Push to your branch → `git push origin feature/YourFeatureName`  
5. Open a **Pull Request**  

---

## 🪪 License

This project is open-source and available under the **MIT License**.

---

## 👨‍💻 Author

**Vivek Vishwakarma**  
📍 Jabalpur, Madhya Pradesh, India  
📧 [vivekvish0134@gmail.com](mailto:vivekvish0134@gmail.com)  
🔗 [GitHub – VivekGits7](https://github.com/VivekGits7)

---

⭐ If you like this project, don’t forget to give it a **star** on GitHub! ⭐
