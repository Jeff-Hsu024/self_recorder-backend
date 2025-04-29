# Self Recorder

This is a simple self recorder project.

## 功能

*   記錄食物與熱量 (新增單位資訊)
*   記錄運動與熱量 (新增單位資訊)
*   記錄使用者記錄食物的時間點 (新增數量與單位資訊，單位為可選)
*   記錄使用者記錄運動的時間點 (新增數量與單位資訊，單位為可選)
*   記錄使用者記錄睡覺與起床時間
*   記錄體重
*   食物類別
*   食物類型

## 使用方式

To use this project, you need to:

1.  Clone the repository.
2.  Build the project using Maven.
3.  Run the project.
4.  Access Swagger UI at `http://localhost:8080/swagger-ui.html` to test the API.

## 開發環境

*   Java 21
*   Spring Boot 3.3.11
*   Maven

## 測試

*   使用 JUnit 5 進行單元測試
*   使用 Mockito 進行 Mock 物件
*   使用 Spring Boot Test 進行整合測試

## 修正測試錯誤

*   修正了 Repository Test 中的參考完整性約束錯誤。

## Added Google OAuth2 Login

*   Added Google OAuth2 login functionality to the project.
*   Updated `pom.xml` to include Spring Security OAuth2 Client dependency.
*   Updated `application.yml` to include Google OAuth2 client ID and secret.
*   Added `CustomOAuth2UserService`, `OAuth2AuthenticationSuccessHandler`, and `OAuth2AuthenticationFailureHandler` classes to handle OAuth2 login.
*   Updated `UserService` to configure Spring Security for OAuth2 login.
*   Updated test cases to provide email values for User entities.
*   Updated `application.yml` to use environment variables for sensitive information.
*   Updated `OAuth2AuthenticationSuccessHandler` to allow customization of the redirect URL.

## JWT Support

*   Added JWT (JSON Web Token) for authentication and authorization.
*   The `JwtProvider` class is responsible for generating and parsing JWT tokens.
*   Updated `pom.xml` to include JJWT dependencies.
*   Added JWT related configurations in `application.yml`.

## Contributing

To contribute to this project, you need to:

1.  Fork the repository.
2.  Create a new branch.
3.  Make your changes.
4.  Submit a pull request.
