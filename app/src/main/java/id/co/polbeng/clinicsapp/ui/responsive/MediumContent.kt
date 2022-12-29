package id.co.polbeng.clinicsapp.ui.responsive

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import id.co.polbeng.clinicsapp.ui.screen.RootNavigationGraph
import id.co.polbeng.clinicsapp.ui.screen.home.HomeScreen
import id.co.polbeng.clinicsapp.utils.LocalCurrentWindowSize
import id.co.polbeng.clinicsapp.utils.WindowSize

@Composable
fun MediumContent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(LocalCurrentWindowSize provides WindowSize.MEDIUM) {
        Row(
            modifier = modifier,
        ) {
            HomeScreen(
                navController = navController,
                modifier = Modifier.weight(0.4f),
            )

            RootNavigationGraph(
                navController = navController,
                modifier = Modifier.weight(0.6f),
            )
        }
    }
}
