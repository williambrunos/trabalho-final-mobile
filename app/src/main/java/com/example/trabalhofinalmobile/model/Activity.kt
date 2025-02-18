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
        if (name.isBlank()) {
            errors.add("Name is required")
        } else if (name.length > 500) {
            errors.add("Name cannot be longer than 500 characters")
        }
        if (responsible.isBlank()) {
            errors.add("Responsible is required")
        } else if (responsible.length > 100) {
            errors.add("Responsible cannot be longer than 100 characters")
        }
        if (date.isBlank()) {
            errors.add("Date is required")
        } else if (!isValidDate(date)) {
            errors.add("Date must be a valid date")
        }
        if (description.isBlank()) {
            errors.add("Description is required")
        }
        return errors
    }

    private fun isValidDate(date: String): Boolean {
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