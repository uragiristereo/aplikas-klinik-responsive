package id.co.polbeng.clinicsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.co.polbeng.clinicsapp.ui.navigation.Screen
import id.co.polbeng.clinicsapp.ui.screen.about.AboutScreen
import id.co.polbeng.clinicsapp.ui.screen.home.HomeScreen
import id.co.polbeng.clinicsapp.ui.screen.member.MemberScreen
import id.co.polbeng.clinicsapp.ui.screen.registration.RegistrationScreen
import id.co.polbeng.clinicsapp.ui.screen.schedule.ScheduleScreen
import id.co.polbeng.clinicsapp.utils.DevicePosture
import id.co.polbeng.clinicsapp.utils.WindowSize

@Composable
fun ClinicsApp(
    windowSize: WindowSize,
    devicePosture: DevicePosture
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController = navController)
        }
        composable(route = Screen.Schedule.route) {
            ScheduleScreen(navController = navController)
        }
        composable(
            route = Screen.Registration.route,
            arguments = listOf(
                navArgument("doctorId") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            RegistrationScreen(navController = navController)
        }
        composable(route = Screen.Member.route) {
            MemberScreen(navController = navController)
        }
    }
}
