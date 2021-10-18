package me.aydie.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.aydie.task_tracker.R
import me.aydie.dashboard.models.AccountItemModel

@Preview(showBackground = true, widthDp = 300)
@Composable
fun AccountItem(
    modifier: Modifier = Modifier,
    accountName : String? = null,
    accountNumber: Number? = null,
    availableBalance: String? = null,
    balance: String? = null,
    accountIcon: Int = R.drawable.ic_launcher_background
) {
    Column {
        Row(modifier = Modifier
            .padding(8.dp)
            .clickable { }, verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = accountIcon),
                contentDescription = "Account Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column() {
                accountName?.let { Text(text = "Account Name") }
                accountNumber?.let { Text(text = "Account Numbers") }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                availableBalance?.let { Text(text = "$0.00", textAlign = TextAlign.End)  }
                balance?.let { Text(text = "Balance $0.00000", textAlign = TextAlign.End) }
            }
        }
        Divider()
    }
}

@Composable
fun AccountItem(
    modifier: Modifier = Modifier,
    model: AccountItemModel
) {
    AccountItem(modifier, model.accountName, model.accountNumber, model.availableBalance, model.balance)
}