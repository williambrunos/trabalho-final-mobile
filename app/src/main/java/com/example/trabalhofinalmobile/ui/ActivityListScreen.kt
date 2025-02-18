package com.example.trabalhofinalmobile.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.trabalhofinalmobile.model.Activity

@Composable
fun ActivityListScreen(
    activities: List<Activity>,
    modifier: Modifier = Modifier,
    onActivityClick: (Activity) -> Unit
) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(activities) { activity ->
            ActivityListItem(activity, onActivityClick)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ActivityListItem(
    activity: Activity,
    onActivityClick: (Activity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onActivityClick(activity) },
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Column {
                Text(text = activity.name)
                if (activity.isCompleted) {
                    Text(text = "Concluída", color = Color.Green)
                }
            }
        }
    }
}