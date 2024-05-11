package com.benardi.btnjc.ui.composables

import DetailScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.benardi.btnjc.R
import com.benardi.btnjc.models.Laptop
import com.benardi.btnjc.nav.NavItem
import com.benardi.btnjc.ui.composables.tabs.HomeScreen
import com.benardi.btnjc.ui.composables.tabs.ListScreen
import com.benardi.btnjc.ui.composables.tabs.ProfileScreen

/**
 * Composable function that defines the navigation screens and their corresponding destinations.
 *
 * @param navController The navigation controller used for handling navigation between screens.
 */
object MainDestinations {
    const val LIST_ROUTE = "list"
    const val ABOUT_ROUTE = "about"
    const val DETAIL_ROUTE = "detail"
}


@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeScreen(navController) }
        composable(NavItem.List.path) { ListScreen(navController) }
        composable(MainDestinations.ABOUT_ROUTE) { ProfileScreen() }

        composable(NavItem.Profile.path) { ProfileScreen() }
        composable(
            route = "${MainDestinations.DETAIL_ROUTE}/{brand}/{model}/{processor}/{ramSizeGB}/{storageSizeGB}/{screenSizeInches}/{priceUSD}/{imageResId}",
            arguments = listOf(
                navArgument("brand") { type = NavType.StringType },
                navArgument("model") { type = NavType.StringType },
                navArgument("processor") { type = NavType.StringType },
                navArgument("ramSizeGB") { type = NavType.IntType },
                navArgument("storageSizeGB") { type = NavType.IntType },
                navArgument("screenSizeInches") { type = NavType.FloatType },
                navArgument("priceUSD") { type = NavType.FloatType },
                navArgument("imageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val laptop = Laptop(
                brand = backStackEntry.arguments?.getString("brand") ?: "",
                model = backStackEntry.arguments?.getString("model") ?: "",
                processor = backStackEntry.arguments?.getString("processor") ?: "",
                ramSizeGB = backStackEntry.arguments?.getInt("ramSizeGB") ?: 0,
                storageSizeGB = backStackEntry.arguments?.getInt("storageSizeGB") ?: 0,
                screenSizeInches = backStackEntry.arguments?.getDouble("screenSizeInches") ?: 0.0,
                priceUSD = backStackEntry.arguments?.getDouble("priceUSD") ?: 0.0,
                imageResId = backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.acer_3 // Provide a default image if needed
            )
            DetailScreen(laptop = laptop, navController)
        }
        composable(
            route = "${MainDestinations.DETAIL_ROUTE}/{brand}/{model}/{processor}/{ramSizeGB}/{storageSizeGB}/{screenSizeInches}/{priceUSD}/{imageResId}",
            arguments = listOf(
                navArgument("brand") { type = NavType.StringType },
                navArgument("model") { type = NavType.StringType },
                navArgument("processor") { type = NavType.StringType },
                navArgument("ramSizeGB") { type = NavType.IntType },
                navArgument("storageSizeGB") { type = NavType.IntType },
                navArgument("screenSizeInches") { type = NavType.FloatType },
                navArgument("priceUSD") { type = NavType.FloatType },
                navArgument("imageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val laptop = Laptop(
                brand = backStackEntry.arguments?.getString("brand") ?: "",
                model = backStackEntry.arguments?.getString("model") ?: "",
                processor = backStackEntry.arguments?.getString("processor") ?: "",
                ramSizeGB = backStackEntry.arguments?.getInt("ramSizeGB") ?: 0,
                storageSizeGB = backStackEntry.arguments?.getInt("storageSizeGB") ?: 0,
                screenSizeInches = backStackEntry.arguments?.getDouble("screenSizeInches") ?: 0.0,
                priceUSD = backStackEntry.arguments?.getDouble("priceUSD") ?: 0.0,
                imageResId = backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.acer_3 // Provide a default image if needed
            )
            DetailScreen(laptop = laptop,navController)
        }
    }
}