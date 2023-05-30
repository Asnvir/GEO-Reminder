
# Android-GEO-reminder

Android-GEO-reminder is an Android application that allows users to create location-based reminders. The app utilizes clean architecture principles, Kotlin programming language, Firebase Realtime Database, Dagger Hilt dependency injection, and a background service for tracking live location.


## Features
- Create reminders based on geographic locations
- Set custom radius for each reminder
- Receive notifications when entering or leaving a specified location
- Edit or delete existing reminders
- View a list of all created reminders
- Map view to visualize the reminders and current location
- Track live location in the background using a service

## Architecture
The project follows the clean architecture principles, which promotes separation of concerns and testability. Here is an overview of the architecture components:

- **Presentation Layer**: Contains the UI components such as Activities, Fragments, and ViewModels. It communicates with the Domain layer and uses Dagger Hilt for dependency injection.

- **Domain Layer**: Contains the business logic and use cases of the application. It defines the interfaces for interacting with the data layer.

- **Data Layer**: Handles data operations and communicates with external data sources. It includes Firebase Realtime Database as the data source and implements the interfaces defined in the domain layer.

- **Background Service**: The app utilizes a background service to track the live location of the user. This service runs in the background and continuously updates the location, even when the app is not actively used.

- **Dependency Injection**: Dagger Hilt is used for dependency injection throughout the application. It provides a clean and efficient way to manage dependencies and promotes modularity.

## Libraries Used

- **Kotlin**: The primary programming language used for the project.
- **Firebase Realtime Database**: A cloud-hosted NoSQL database by Firebase, used to store and synchronize data in real-time.
- **Dagger Hilt**: A dependency injection library for Android and Kotlin, used for managing dependencies and promoting modularity.
- **Google Play Services Location**: A library provided by Google Play Services that provides location APIs for Android applications.
- **AndroidX**: A set of libraries to support modern Android development.
