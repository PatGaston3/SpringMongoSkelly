# Spring Boot Skeleton Initializer
by [Patrick Gaston](https://github.com/PatGaston3) 

This is a skeleton initializer project for Spring Boot, providing a foundation for building applications. It includes essential technologies such as Java 17, Spring Boot 3, Spring Security 6, MongoDB, and Swagger.

## Features

- **Authentication**: The project comes with preconfigured authentication functionality. It allows you to create users and authenticate them based on the registered format.
- **Common Response Format**: A standardized response format is included to ensure consistency in the application's responses.
- **Dynamic Error Handling**: The project incorporates dynamic error handling with standardized error codes. This allows for consistent and meaningful error messages across the application.

## Technologies Used

- Java 17: The latest version of the Java programming language.
- Spring Boot 3: A framework for quickly building Spring-based applications.
- Spring Security 6: Provides security features such as authentication and authorization.
- MongoDB: A NoSQL database for storing application data.
- Swagger: A tool for generating interactive API documentation.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository: `git clone https://github.com/PatGaston3/SpringMongoSkelly.git`

2. Update the code:
    - Replace any occurrence of `<TODO>` in the codebase with specific values relevant to your application.
    - Customize the functionality and features to meet your application's requirements.

3. Configure the necessary properties for MongoDB connection:
    - Open the `application.yaml` file located in the project's root directory.
    - Update the MongoDB connection settings (`spring.data.mongodb.*`) according to your MongoDB setup.

4. Build and run the project using your preferred build tool or IDE.
    - If you're using Maven, run `mvn spring-boot:run` in the project's root directory.
    - If you're using Gradle, run `./gradlew bootRun` in the project's root directory.

5. Refer to the documentation for further guidance on utilizing the authentication and response format features.

## Response Format

The project follows a standardized response format to ensure consistency in the application's responses. The response format consists of two main types: "Success" and "Error".

#### Success Response

In a successful scenario, the response will have the following structure:

```json
{
  "status": "SUCCESS",
  "data": {
    "id": "1",
    "name": "John Doe"
  }
}
```

- "status" (string): Represents the status of the response. In a success scenario, the value will be set to "SUCCESS".
- "data" (object): Contains the actual data or payload of the response. This can vary depending on the specific API or functionality being utilized. In the example above, the "data" object includes an "id" and a "name".

####  Error Response
In case of an error, the response will have the following structure:

 ```json
 {
 "status": "ERROR",
 "error": {
     "code": "AUERR001",
     "message": "Invalid email/password."
 }
 }
 ```

- "status" (string): Indicates the status of the response. In an error scenario, the value will be set to "ERROR".
- "error" (object): Contains information about the error encountered.
  - "code" (string): Represents an error code specific to the encountered error. This allows for easy identification and categorization of errors. In the example above, the error code is set to "AUERR001".
  - "message" (string): Provides a human-readable error message describing the encountered issue. This message helps in understanding the error and can be displayed to users or used for debugging purposes. In the example above, the error message is set to "Invalid email/password.".


The standardized response format ensures that both success and error responses follow a consistent structure across different API endpoints and functionalities within the application. This makes it easier for clients and developers to understand and process the responses.

## Access Swagger UI:
   - Start the application.
   - Open your web browser and go to `http://localhost:8080/swagger-ui.html`.
   - This will open the Swagger UI interface, where you can explore and interact with the API documentation.

## Contributing/Feedback

Contributions are welcome! If you encounter any issues or have suggestions for improvement, please open an issue or submit a pull request or just let me know!
