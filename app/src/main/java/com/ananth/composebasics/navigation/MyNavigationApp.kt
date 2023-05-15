package com.ananth.composebasics.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ananth.composebasics.R

/**
 * Navigation components have 3 parts
 * 1. NavController - which manages the state of your navigation. this is how we navigate between different destination and also maintains the backstack.
 * 2. NavGraph - Which provides the map for our navController, this is where we define all of your destinations and how they relate to one another.
 * 3. NavHost - which is what we will focus on today. so NavHost is a bounding box container for the part of your UI that should be considered part of navigation.
 * This normally takes the form of a single composable destination, such as a screen that takes the entire space of the NavHost.
 *
 * //outside the NavHost
 * 1. TopAppBar
 * 2. BottomNavigation
 * 3. NavigationRail
 * 4. DrawerLayout
 * movableContentOf() - It allows state to move within the composition by converting the composable lambda into a lambda that moves the state and corresponding nodes to any new location that is called
 * when the previous call leaves the composition the state is temporarily preserved, and if a new call to the lambda enter the composition then the state and associated nodes are moved to the location of the new call.
 * if no new call is added, the state is removed permanently and remember, observers are notified.
 * */

@Composable
fun MyNavHost(modifier: Modifier = Modifier) {
    var navController = rememberNavController()

//    val navHost = remember{
//        movableContentOf<PaddingValues> { innerPadding ->
//         NavHost(navController = navController){
//
//         }
//
//        }
//    }
//    val icons = listOf(R.drawable.ab1_inversions, R.drawable.ab2_quick_yoga)
//    Scaffold(
//        topBar = {},
//        bottomBar = {
//            BottomNavigation {
//                val navBackStackEntry = navController.currentBackStackEntryAsState().value
//                val currentDestination = navBackStackEntry.destination
//                icons.forEach { item ->
//                    BottomNavigationItem(selected =false, onClick = {  },icon = {})
//                }
//            }
//        }
//    ) { innerPadding ->
//        NavHost(navController = navController) {
//            //defined grpah here
//        }
//    }
}