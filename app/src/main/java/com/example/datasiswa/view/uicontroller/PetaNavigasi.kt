package com.example.datasiswa.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.datasiswa.view.DetailSiswaScreen
import com.example.datasiswa.view.EntrySiswaScreen
import com.example.datasiswa.view.HomeScreen
import com.example.datasiswa.view.route.DestinasiDetailSiswa
import com.example.datasiswa.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.datasiswa.view.route.DestinasiEntry
import com.example.datasiswa.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController= rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.popBackStack()})
        }
        composable (route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg){
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateToEditItem = { navController.navigate("${DestinasiEntry.route}/$it") },
                navigateBack = { navController.navigateUp() })
        }
        composable(DestinasiEditSiswa.routeWithArgs,
            argument = listOf(navArgument(DEstinasiEditSiswa.itemIdArg){
                type = NavType.IntType
            })){
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = {
                    navController.navigateUp() })
        }
    }
}


