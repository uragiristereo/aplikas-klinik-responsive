package id.co.polbeng.clinicsapp.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AppRegistration
import androidx.compose.material.icons.outlined.CardMembership
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.co.polbeng.clinicsapp.R
import id.co.polbeng.clinicsapp.ui.components.CustomButton
import id.co.polbeng.clinicsapp.ui.navigation.Screen
import id.co.polbeng.clinicsapp.ui.theme.ClinicsAppTheme

data class NavigationButtonItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen,
)

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            letterSpacing = 0.sp
                        )
                    ) {
                        append(stringResource(id = R.string.app_name))
                    }
                    append("\n\n")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            letterSpacing = 0.5.sp,
                        )
                    ) {
                        append(stringResource(id = R.string.welcome))
                    }
                },
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(36.dp))
            Column(modifier = Modifier.fillMaxWidth(0.75f)) {
                val navigationButtonItem = listOf(
                    NavigationButtonItem(
                        title = stringResource(id = R.string.screen_about),
                        icon = Icons.Outlined.Info,
                        screen = Screen.About
                    ),
                    NavigationButtonItem(
                        title = stringResource(id = R.string.screen_schedule),
                        icon = Icons.Outlined.Event,
                        screen = Screen.Schedule
                    ),
                    NavigationButtonItem(
                        title = stringResource(id = R.string.screen_registration),
                        icon = Icons.Outlined.AppRegistration,
                        screen = Screen.Registration
                    ),
                    NavigationButtonItem(
                        title = stringResource(id = R.string.screen_member),
                        icon = Icons.Outlined.CardMembership,
                        screen = Screen.Member
                    )
                )

                navigationButtonItem.forEachIndexed { index, item ->
                    CustomButton(
                        modifier = Modifier
                            .padding(
                                bottom = when (index) {
                                    navigationButtonItem.size - 1 -> 0.dp
                                    else -> 16.dp
                                },
                            )
                            .height(48.dp),
                        text = item.title,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }

                                restoreState = true
                                launchSingleTop = true
                            }
                        },
                        imageVector = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                        },
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            disabledElevation = 0.dp,
                            hoveredElevation = 0.dp,
                            focusedElevation = 0.dp,
                        ),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    ClinicsAppTheme() {
        HomeScreen(navController = rememberNavController())
    }
}
