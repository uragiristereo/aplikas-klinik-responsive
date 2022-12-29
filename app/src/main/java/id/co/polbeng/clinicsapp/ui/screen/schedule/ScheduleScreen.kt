package id.co.polbeng.clinicsapp.ui.screen.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.co.polbeng.clinicsapp.R
import id.co.polbeng.clinicsapp.ui.theme.ClinicsAppTheme

@Composable
fun ScheduleScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.screen_schedule))
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text("Schedule Screen")
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ScheduleScreenPreview() {
    ClinicsAppTheme {
        ScheduleScreen(navController = rememberNavController())
    }
}