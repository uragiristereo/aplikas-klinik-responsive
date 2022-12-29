package id.co.polbeng.clinicsapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about")
    object Schedule : Screen("schedule")
    object Registration : Screen("registration/{doctorId}") {
        fun createRoute(doctorId: String) = "schedule/$doctorId";
    }
    object Member : Screen("member")
}
