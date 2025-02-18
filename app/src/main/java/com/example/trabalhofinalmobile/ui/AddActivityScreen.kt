package com.example.trabalhofinalmobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trabalhofinalmobile.model.Activity

@Composable
fun AddActivityScreen(modifier: Modifier = Modifier, onSave: (Activity) -> Unit) {
    var name by remember { mutableStateOf("") }
    var responsible by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Activity Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = responsible,
            onValueChange = { responsible = it },
            label = { Text("Responsible") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val activity = Activity(0, name, responsible, date, description)
            onSave(activity)
        }) {
            Text("Save")
        }
    }
}