package id.co.polbeng.clinicsapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import id.co.polbeng.clinicsapp.ui.responsive.CompactContent
import id.co.polbeng.clinicsapp.ui.responsive.MediumContent
import id.co.polbeng.clinicsapp.utils.WindowSize
import id.co.polbeng.clinicsapp.utils.rememberWindowSizeState

@Composable
fun ClinicsApp() {
    val navController = rememberNavController()

    when (rememberWindowSizeState()) {
        WindowSize.COMPACT -> {
            CompactContent(navController = navController)
        }

        WindowSize.MEDIUM -> {
            MediumContent(navController = navController)
        }

        WindowSize.EXPANDED -> {
            MediumContent(navController = navController)
        }
    }
}
