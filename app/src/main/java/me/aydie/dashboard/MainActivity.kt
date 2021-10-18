package me.aydie.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.aydie.dashboard.components.AccountItem
import me.aydie.dashboard.components.theme.DashboardTheme
import me.aydie.dashboard.models.AccountItemModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardTheme {
                Root()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Root() {
    AccountsList()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun AccountsList() {
    val everyDayAndSavingsItems = MutableList(20) { AccountItemModel("test", 123, "0.00", "0.00") }

    val goalsItems = MutableList(20) { AccountItemModel("test", balance = " 0.00") }

    LazyColumn {
        stickyHeader { AccountHeader(text = "Everyday and Savings") }
        items(everyDayAndSavingsItems) { item -> AccountItem(model = item) }

        stickyHeader { AccountHeader(text = "Goals") }
        items(goalsItems) { item -> AccountItem(model = item) }
    }
}

@Composable
private fun AccountHeader(text: String) {
    Card(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)) {
        Column{
            Text(text = text, modifier = Modifier.padding(8.dp))
            Divider()
        }
    }
}