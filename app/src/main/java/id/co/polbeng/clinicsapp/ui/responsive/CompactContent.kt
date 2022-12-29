package id.co.polbeng.clinicsapp.ui.responsive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import id.co.polbeng.clinicsapp.ui.screen.RootNavigationGraph
import id.co.polbeng.clinicsapp.utils.LocalCurrentWindowSize
import id.co.polbeng.clinicsapp.utils.WindowSize

@Composable
fun CompactContent(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    CompositionLocalProvider(LocalCurrentWindowSize provides WindowSize.COMPACT) {
        RootNavigationGraph(
            navController = navController,
            modifier = modifier,
        )
    }
}
