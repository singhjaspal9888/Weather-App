# 🌦️ Weather App – Android (Jetpack Compose)

This project demonstrates my **real-world approach to Android development**, focusing on **clean architecture, scalability, testability, and modern tools** rather than UI complexity.

It is built as a **production-oriented Android application** to reflect how I design, structure, and maintain scalable, maintainable, and testable Android systems using modern best practices.

---

## 🚀 What This Project Shows

* Strong understanding of **modern Android development**
* Ability to write **clean, maintainable, and testable code**
* Experience with **Jetpack Compose, MVVM, DI, Testing, and CI/CD**
* Industry-aligned development practices

---

## 📱 Features

* Displays **current temperature**
* Shows **wind speed**
* Fetches live weather data from REST API
* **State-driven UI** using Jetpack Compose
* Proper handling of **Loading, Success, and Error states**

---

## 🛠️ Tech Stack

### Core Technologies

* Kotlin
* Jetpack Compose
* Material 3

### Architecture

* MVVM (Model–View–ViewModel)
* ViewModel
* Repository pattern

### Asynchronous & State Management

* Kotlin Coroutines
* Flow / State handling

### Networking

* Retrofit
* OkHttp + Logging Interceptor
* Gson Converter

### Dependency Injection

* Hilt (Dagger)

### Location

* Google Play Services – Location API

---

## 🧪 Testing

Testing is treated as a **core part of development**, not an afterthought.

### Tools Used

* JUnit
* Coroutines Test
* MockK
* Turbine (Flow testing)

### What is Tested

* ViewModel business logic
* State emissions (Loading → Success / Error)
* Error handling scenarios

All test cases are passing ✅

---

## ⚙️ Build Configuration & Gradle Setup

* Gradle Version Catalog (`libs.versions.toml`)
* Modern plugin management
* Java 17 compatibility
* Environment-safe configuration using `BuildConfig`

```kotlin
buildConfigField(
    "String",
    "BASE_URL",
    "\"https://api.open-meteo.com/\""
)
```

---

## 🧠 Architecture Overview (MVVM)

* **UI Layer**
  Jetpack Compose observes immutable UI state from ViewModel

* **ViewModel Layer**
  Contains business logic and exposes state to the UI

* **Data Layer**
  Repository fetches data from API using Retrofit

This separation ensures **scalability, testability, and maintainability**.

---

## 🔐 Dependency Injection

Hilt is used to provide:

* Retrofit instance
* API service
* Repository
* ViewModel

Benefits:

* Loose coupling
* Easy mocking for tests
* Cleaner and scalable codebase

---

## 🌐 API Used

**Open-Meteo Weather API**
[https://api.open-meteo.com/](https://api.open-meteo.com/)

Data consumed in this project:

* Current temperature
* Wind speed

---

## 🔄 CI/CD Pipeline

This project includes **CI/CD pipeline integration** to ensure code quality.

The pipeline automatically:

* Builds the project
* Runs unit tests
* Verifies stability on every push and pull request

This reflects a **production-oriented development mindset**.

---

## ▶️ How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/your-username/weather-app-android.git
   ```

2. Open the project in **Android Studio**

3. Sync Gradle

4. Run on emulator or physical device

---

## 🎯 Why This Project?

The project is intentionally **kept simple in features** to emphasize:

* Engineering quality
* Clean architecture
* Proper state management
* Testing mindset

The structure allows easy extension for:

* Forecast screens
* Location-based search
* Offline caching
* Advanced UI

---

## 👤 Author

**Jaspal Singh**
Android Developer
Kotlin | Jetpack Compose | MVVM | Hilt | Retrofit | Testing | CI/CD

---

## ⭐ Development Philosophy

> "I focus on building Android applications with clean architecture, strong fundamentals, and long-term maintainability using modern tools and best practices."
