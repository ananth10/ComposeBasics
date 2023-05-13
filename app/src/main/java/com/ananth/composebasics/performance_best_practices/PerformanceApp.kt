package com.ananth.composebasics.performance_best_practices

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PerformanceApp() {
    MaterialTheme() {
//        BackwardsWrite(list = getTransactionList())
        TestDerivedStateOf()
    }
}

data class Transaction(val date: LocalDate, val balance: Double)

@RequiresApi(Build.VERSION_CODES.O)
fun getTransactionList(): List<Transaction> {
    return listOf(
        LocalDate.now() to 10.0,
        LocalDate.now() to 20.0,
        LocalDate.now() to 30.0
    ).map { Transaction(it.first, it.second) }
}