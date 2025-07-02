# 🔐 Password Validator / Generator

A simple Java project for validating user passwords against common security standards, including:

- Minimum and maximum length
- Presence of numbers
- Uppercase and lowercase letters
- Special characters
- Avoidance of weak or common passwords

---

## 📁 Project Structure

- Main.java | Console interface to enter and validate passwords
- PasswordValidator.java | Core validation logic with rule-based checks
- ExceptionMessages.java | Centralized error messages for consistent responses
- PasswordValidatorTest.java | unit tests using JUnit 5
- generatePassword() | Generate a strong password
---



## 🛠️ Features

### 🔍 Password Validation

You can input a password via the console, and the system will validate it against all security rules.

### 🔐 Password Generation

You can also generate a **random, strong, and valid password** using the `generatePassword()` method.

---

## ✅ Validation Rules

A password is considered **valid** if it meets all of the following:

- Length between **8 and 16 characters**
- Contains **at least one digit**
- Contains **at least one uppercase letter**
- Contains **at least one lowercase letter**
- Contains **at least one special character**
- Is **not** one of the following common passwords:
    - `Password`
    - `Password123`
    - `Password1!`
    - `12345678`

---