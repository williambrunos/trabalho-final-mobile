package com.example.trabalhofinalmobile.model

data class Activity(
    val id: Int,
    val name: String,
    val responsible: String,
    val date: String,
    val description: String
) {
    fun validate(): List<String> {
        val errors = mutableListOf<String>()
        if (name.length > 500) {
            errors.add("Name cannot be longer than 500 characters")
        }
        if (responsible.length > 100) {
            errors.add("Responsible cannot be longer than 100 characters")
        }
        if (!isValidDate(date)) {
            errors.add("Date must be a valid date")
        }
        return errors
    }

    private fun isValidDate(date: String): Boolean {
        // Implement your date validation logic here
        // For simplicity, let's assume the date format is "yyyy-MM-dd"
        return try {
            val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd")
            dateFormat.isLenient = false
            dateFormat.parse(date)
            true
        } catch (e: Exception) {
            false
        }
    }
}