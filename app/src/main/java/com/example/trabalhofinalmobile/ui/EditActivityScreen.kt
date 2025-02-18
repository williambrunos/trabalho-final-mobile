package com.example.trabalhofinalmobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trabalhofinalmobile.model.Activity

@Composable
fun EditActivityScreen(
    activity: Activity,
    modifier: Modifier = Modifier,
    onUpdateActivity: (Activity) -> Unit
) {
    var name by remember { mutableStateOf(activity.name) }
    var responsible by remember { mutableStateOf(activity.responsible) }
    var date by remember { mutableStateOf(activity.date) }
    var description by remember { mutableStateOf(activity.description) }
    var errors by remember { mutableStateOf(emptyList<String>()) }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = responsible,
            onValueChange = { responsible = it },
            label = { Text("Responsible") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date (yyyy-MM-dd)") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val updatedActivity = Activity(activity.id, name, responsible, date, description)
            val validationErrors = updatedActivity.validate()
            if (validationErrors.isEmpty()) {
                onUpdateActivity(updatedActivity)
            } else {
                errors = validationErrors
            }
        }) {
            Text("Atualizar atividade")
        }
        errors.forEach { error ->
            Text(text = error, color = androidx.compose.ui.graphics.Color.Red)
        }
    }
}