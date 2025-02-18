package com.example.trabalhofinalmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trabalhofinalmobile.model.Activity
import com.example.trabalhofinalmobile.ui.*
import com.example.trabalhofinalmobile.ui.theme.TrabalhoFinalMobileTheme

class MainActivity : ComponentActivity() {
    private val activities = mutableStateListOf<Activity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrabalhoFinalMobileTheme {
                var currentScreen by remember { mutableStateOf("list") }
                var selectedActivity by remember { mutableStateOf<Activity?>(null) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            "list" -> {
                                ActivityListScreen(activities, Modifier.weight(1f)) { activity: Activity ->
                                    selectedActivity = activity
                                    currentScreen = "detail"
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = { currentScreen = "add" },
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text("Adicionar atividade")
                                }
                            }
                            "add" -> AddActivityScreen(Modifier.padding(innerPadding)) { activity: Activity ->
                                activities.add(activity)
                                currentScreen = "list"
                            }
                            "detail" -> selectedActivity?.let { activity: Activity ->
                                ActivityDetailScreen(
                                    activity,
                                    Modifier.padding(innerPadding),
                                    onBack = { currentScreen = "list" },
                                    onEdit = { currentScreen = "edit" },
                                    onDelete = {
                                        activities.remove(activity)
                                        currentScreen = "list"
                                    }
                                )
                            }
                            "edit" -> selectedActivity?.let { activity: Activity ->
                                EditActivityScreen(activity, Modifier.padding(innerPadding)) { updatedActivity: Activity ->
                                    val index = activities.indexOfFirst { it.id == updatedActivity.id }
                                    if (index != -1) {
                                        activities[index] = updatedActivity
                                    }
                                    currentScreen = "list"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}