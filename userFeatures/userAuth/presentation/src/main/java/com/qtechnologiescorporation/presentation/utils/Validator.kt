package com.qtechnologiescorporation.presentation.utils

data class ValidationError(val message: String)

object Validator {

    fun validateFirstName(firstName: String): ValidationError? {
        if (firstName.isBlank()) return ValidationError("First name cannot be empty")
        if (firstName.length < 3) return ValidationError("First name must be at least 3 characters")
        if (firstName.any { it.isDigit() }) return ValidationError("First name cannot contain digits")
        return null
    }

    fun validateLastName(lastName: String): ValidationError? {
        if (lastName.isBlank()) return ValidationError("Last name cannot be empty")
        if (lastName.length < 3) return ValidationError("Last name must be at least 3 characters")
        if (lastName.any { it.isDigit() }) return ValidationError("Last name cannot contain digits")
        return null
    }


    fun validatePhoneNumber(phone: String): ValidationError? {
        if (phone.isBlank()) return ValidationError("Phone number cannot be empty")
        val phoneRegex = Regex("^[0-9]{9,10}$")
        if (!phoneRegex.matches(phone)) return ValidationError("Enter a valid 9 or 10-digit phone number")
        return null
    }

    fun validateUsername(username: String): ValidationError? {
        if (username.isBlank()) return ValidationError("Username cannot be empty")
        if (username.length < 3) return ValidationError("Username must be at least 3 characters")
        return null
    }

    fun validateName(name: String): ValidationError? {
        if (name.isBlank()) return ValidationError("Name cannot be empty")
        if (name.length < 3) return ValidationError("Name must be at least 3 characters")
        return null
    }

    fun validateEmail(email: String): ValidationError? {
        if (email.isBlank()) return ValidationError("Email cannot be empty")
        if (!email.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))) return ValidationError("Enter a valid email address")
        return null
    }

    fun validatePassword(password: String): ValidationError? {
        if (password.isBlank()) return ValidationError("Password cannot be empty")
        if (password.length < 6) return ValidationError("Password must be at least 6 characters")
        if (!password.any { it.isUpperCase() }) return ValidationError("Password must contain at least one uppercase letter")
        if (!password.any { it.isLowerCase() }) return ValidationError("Password must contain at least one lowercase letter")
        if (!password.any { it.isDigit() || it in "!@#\$%^&*()-_=+[{]}|;:'\",<.>/?" }) return ValidationError("Password must contain a digit or special character")
        return null
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): ValidationError? {
        if (confirmPassword.isBlank()) return ValidationError("Confirm password cannot be empty")
        if (password != confirmPassword) return ValidationError("Passwords do not match")
        return null
    }

    fun validateTermsAccepted(accepted: Boolean): ValidationError? {
        if (!accepted) return ValidationError("You must accept the terms and conditions")
        return null
    }

    fun validateSignInUsername(username: String): ValidationError? {
        if (username.isBlank()) return ValidationError("Username cannot be empty")
        return null
    }

    fun validateSignInPassword(password: String): ValidationError? {
        if (password.isBlank()) return ValidationError("Password cannot be empty")
        return null
    }
}