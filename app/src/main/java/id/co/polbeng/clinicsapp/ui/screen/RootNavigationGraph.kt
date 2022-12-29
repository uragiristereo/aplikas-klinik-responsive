package id.co.polbeng.clinicsapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import id.co.polbeng.clinicsapp.ui.navigation.Screen
import id.co.polbeng.clinicsapp.ui.screen.about.AboutScreen
import id.co.polbeng.clinicsapp.ui.screen.home.EmptyScreen
import id.co.polbeng.clinicsapp.ui.screen.home.HomeScreen
import id.co.polbeng.clinicsapp.ui.screen.member.MemberScreen
import id.co.polbeng.clinicsapp.ui.screen.registration.RegistrationScreen
import id.co.polbeng.clinicsapp.ui.screen.schedule.ScheduleScreen
import id.co.polbeng.clinicsapp.utils.LocalCurrentWindowSize
import id.co.polbeng.clinicsapp.utils.WindowSize

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val windowSize = LocalCurrentWindowSize.current

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(route = Screen.Home.route) {
            when (windowSize) {
                WindowSize.COMPACT -> HomeScreen(navController = navController)
                WindowSize.MEDIUM -> EmptyScreen()
                WindowSize.EXPANDED -> EmptyScreen()
            }
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
