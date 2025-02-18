package com.example.trabalhofinalmobile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trabalhofinalmobile.model.Activity

@Composable
fun ActivityDetailScreen(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = activity.name, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Text(text = activity.responsible, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Text(text = activity.date, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
        Text(text = activity.description, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))
    }
}