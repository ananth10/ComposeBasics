package com.ananth.composebasics.best_practices

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

//1. Define your screen as state in, events out
@Composable
fun MessageItem(message:String,send:(String)->Unit) {
    Column {
        Text(text = message)
        Button(onClick = { send("hello world") }) {
            Text(text = "Send message")
        }
    }
}

//2. Split up your navigation graph

//fun NavGraphBuilder.DetailScreen(){
//    composable("detail_screen/{product_id}"){
//      val viewModel: ProductViewModel = hiltViewModel()
//      val productState by viewModel.conversationFlow.collectAsStateWithLifecycle()
//        ProductDetail(
//        productState,
//          ::viewModel.deleteProduct(),
//         navigationToCartScreen
//        )
//    }
//}

@Composable
fun ProductDetail() {

}


//3. Build only the public APIs that you need

//4. Module structure->Graph structure