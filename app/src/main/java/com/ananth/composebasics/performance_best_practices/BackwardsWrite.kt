package com.ananth.composebasics.performance_best_practices

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BackwardsWrite(modifier: Modifier = Modifier, list: List<Transaction>) {
    var balance by remember { mutableStateOf(0.0) }

    for (transaction in list) {
        Row {
            balance += transaction.balance
            Text(text = "${transaction.date} Balances: $balance")
        }
    }

}

//right approach
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun NoBackwardsWrite(modifier: Modifier = Modifier, list: List<Transaction>) {
//    var balances by remember(list){
//        list.runningReduce{acc, transaction -> acc+transaction.balance}
//    }
//
//    for ((transaction,balance) in list.zip(balances)) {
//            Text(text = "${transaction.date} Balance: $balance")
//    }
//
//}