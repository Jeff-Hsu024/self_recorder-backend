# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased] - 2025-04-28

### Added

*   為 Entity 和 Repository 添加了 JavaDoc 和 Swagger Annotations。
*   針對所有 Repository 撰寫了 DataJpaTest。
*   針對所有 Service 撰寫了單元測試，並確保 `getAllUserLogs` 方法只回傳特定使用者的資料。

### Changed

*   Modified Food entity to include unit information.
*   Modified UserFoodLog entity to include quantity and unit information (unit is optional).
*   Modified Exercise entity to include unit information.
*   Modified UserExerciseLog entity to include quantity and unit information (unit is optional).

### Added

*   Initial release.
*   Added Food, Exercise, UserFoodLog, UserExerciseLog, and UserSleepLog entities.
*   Added repositories for all entities.
*   Added Swagger configuration.
*   Updated UserSleepLog to record sleep and wake up times.
*   Added createUser, foodCategory, and foodType fields to Food entity.
*   Added WeightRecord entity.
*   Created FoodCategory and FoodType entities.
*   Modified Food entity to use FoodCategory and FoodCategory entities.

### Fixed

*   修正了 Repository Test 中的參考完整性約束錯誤。

## [Unreleased]

### Added
- Added Google OAuth2 login functionality to the project.
  - Updated `pom.xml` to include Spring Security OAuth2 Client dependency.
  - Updated `application.yml` to include Google OAuth2 client ID and secret.
  - Added `CustomOAuth2UserService`, `OAuth2AuthenticationSuccessHandler`, and `OAuth2AuthenticationFailureHandler` classes to handle OAuth2 login.
  - Updated `UserService` to configure Spring Security for OAuth2 login.
  - Updated test cases to provide email values for User entities.
  - Updated `application.yml` to use environment variables for sensitive information.
  - Updated `OAuth2AuthenticationSuccessHandler` to allow customization of the redirect URL.

### Features
- Added JWT support for authentication and authorization.

### Changed
- Added `javax.crypto.SecretKey` import to `JwtProvider.java`.

### Added
- Added Javadoc to all entities, repositories, and services.
- Added unit tests to all repositories and services.
