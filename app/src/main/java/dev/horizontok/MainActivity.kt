package dev.horizontok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val Night = Color(0xFF0B0E0C)
private val Panel = Color(0xFF171D18)
private val Accent = Color(0xFF9CFF62)
private val Muted = Color(0xFF9AA69B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HorizonTokApp() }
    }
}

@Composable
private fun HorizonTokApp() {
    var selectedTab by remember { mutableStateOf("Для вас") }
    MaterialTheme(colorScheme = darkColorScheme(
        background = Night, surface = Panel, primary = Accent, onPrimary = Color.Black
    )) {
        Scaffold(
            containerColor = Night,
            topBar = {
                Row(
                    Modifier.fillMaxWidth().background(Night).padding(horizontal = 18.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("HorizonTok", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)
                    Text("NATIVE · ANDROID", color = Muted, style = MaterialTheme.typography.labelSmall)
                }
            },
            bottomBar = {
                NavigationBar(containerColor = Panel) {
                    listOf("Лента", "Поиск", "Профиль").forEach { label ->
                        NavigationBarItem(
                            selected = selectedTab == label,
                            onClick = { selectedTab = label },
                            icon = { Text(when(label) { "Лента" -> "⌂"; "Поиск" -> "⌕"; else -> "◉" }) },
                            label = { Text(label) }
                        )
                    }
                }
            }
        ) { padding ->
            Column(
                Modifier.fillMaxSize().padding(padding).background(Night).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    listOf("Для вас", "Подписки").forEach { tab ->
                        TextButton(onClick = { selectedTab = tab }) {
                            Text(tab, color = if (selectedTab == tab) Color.White else Muted,
                                fontWeight = if (selectedTab == tab) FontWeight.Bold else FontWeight.Normal)
                        }
                    }
                }
                Card(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(containerColor = Panel)
                ) {
                    Box(Modifier.fillMaxSize().padding(22.dp), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.Center, verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text("HorizonTok", color = Accent, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                            Text("Нативное приложение Android", color = Color.White)
                            Text("Источник актуальных видео ещё не подключён.", color = Muted)
                            Text("Не показываем старый кеш как свежую ленту.", color = Muted)
                        }
                    }
                }
            }
        }
    }
}
