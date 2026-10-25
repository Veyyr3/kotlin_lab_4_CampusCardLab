package kg.iuca.campuscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.iuca.campuscard.ui.theme.CampusCardLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusCardLabTheme {
                CampusCardScreen()
            }
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    status: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Column {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Text(text = status)
        }
    }
}

@Composable
fun ScheduleRow(
    time: String,
    title: String,
    room: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = title,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        )
        Text(text = room)
    }
}

@Composable
fun CampusCardScreen() {
    // Главная форма
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp, // Отступ слева
                top = 24.dp,   // Отступ сверху
                end = 16.dp,   // Отступ справа
                bottom = 0.dp  // Снизу отступ не нужен
            )
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.outline,
            )
            .padding(16.dp)
    ) {
        // Шапка
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            ProfileHeader(
                name = "Ada Lovelace",
                status = "In class · Building B"
            )

        // Информация
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Заголовок раздела
            Text(
                text = "Today",
                style = MaterialTheme.typography.titleMedium
            )

            ScheduleRow(time = "09:00", title = "CS101 Intro to CS", room = "Lab 3")
            ScheduleRow(time = "11:00", title = "MATH210 Linear Algebra", room = "A-204")
            ScheduleRow(time = "14:00", title = "Soft Skills", room = "Hall 1")
        }
        // кнопки
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(onClick = {}) {
                Text("Show QR")
            }
            OutlinedButton(onClick = {}) {
                Text("Map")
            }
        }
    }
}}