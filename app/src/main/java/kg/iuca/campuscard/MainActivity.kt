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
            // Шапка
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                Column {
                    Text("Ada Lovelace", style = MaterialTheme.typography.titleMedium)
                    Text("In class · Building B")
                }
            }
        }
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

            // Слот 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                // Exercise 3: переключайте между Alignment.Top и Alignment.CenterVertically
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "09:00",
                    style = MaterialTheme.typography.titleSmall // Чуть крупнее для Exercise 3
                )
                Text(
                    text = "CS101 Intro to Computer Science", // Длинное название для Exercise 4
                    modifier = Modifier
                        .weight(1f) // Exercise 4: заставляет текст сжиматься/переноситься, не выталкивая номер кабинета
                        .padding(horizontal = 8.dp)
                )
                Text(text = "Lab 3")
            }

            // Слот 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "11:00")
                Text(
                    text = "MATH210 Linear Algebra",
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                )
                Text(text = "A-204")
            }

            // Слот 3
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "14:00")
                Text(
                    text = "Soft Skills",
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                )
                Text(text = "Hall 1")
            }
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
}