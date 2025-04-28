# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased] - 2025-04-28

### Added

*   為 Entity 和 Repository 添加了 JavaDoc 和 Swagger Annotations。
*   針對 `UserWeightLogRepository` 撰寫了 DataJpaTest。
*   針對 `UserWeightLogService` 撰寫了單元測試。

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
