package com.example.trabalhofinalmobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trabalhofinalmobile.model.Activity

@Composable
fun ActivityDetailScreen(
    activity: Activity,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onEdit: (Activity) -> Unit,
    onDelete: (Activity) -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = activity.name, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Text(text = activity.responsible, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Text(text = activity.date, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Text(text = activity.description, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Tela inicial")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onEdit(activity) }) {
            Text("Editar Task")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onDelete(activity) }) {
            Text("Deletar Task")
        }
    }
}