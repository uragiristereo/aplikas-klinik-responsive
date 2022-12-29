package id.co.polbeng.clinicsapp.ui.screen.registration

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.co.polbeng.clinicsapp.R
import id.co.polbeng.clinicsapp.ui.components.CustomButton
import id.co.polbeng.clinicsapp.ui.components.CustomExposedDropdownMenu
import id.co.polbeng.clinicsapp.ui.components.CustomRadioButton
import id.co.polbeng.clinicsapp.ui.components.CustomTextField
import id.co.polbeng.clinicsapp.ui.theme.ClinicsAppTheme

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val genders = stringArrayResource(id = R.array.genders)
    val professions = stringArrayResource(id = R.array.professions)

    var name by rememberSaveable { mutableStateOf("") }
    var nik by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }

    var profession by remember { mutableStateOf(professions[0]) }
    var gender by remember { mutableStateOf(genders[0]) }
    var specialist by remember { mutableStateOf(professions[0]) }

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
                    Text(text = stringResource(id = R.string.screen_registration))
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .wrapContentHeight()
                .navigationBarsPadding()
                .imePadding()
                .padding(paddingValues),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                CustomTextField(
                    value = name,
                    onValueChange = { newValue ->
                        name = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_name),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = nik,
                    onValueChange = { newValue ->
                        nik = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_nik),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = age,
                    onValueChange = { newValue ->
                        age = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_age),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = address,
                    onValueChange = { newValue ->
                        address = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_address),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    },
                    singleLine = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomExposedDropdownMenu(
                    options = professions.toList(),
                    value = profession,
                    onValueChange = { newValue ->
                        profession = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_profession),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    },
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    value = phoneNumber,
                    onValueChange = { newValue ->
                        phoneNumber = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_phone_number),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomRadioButton(
                    options = genders.toList(),
                    selectedOption = gender,
                    onOptionSelected = { newValue ->
                        gender = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_gender),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                CustomExposedDropdownMenu(
                    options = professions.toList(),
                    value = specialist,
                    onValueChange = { newValue ->
                        specialist = newValue
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.label_specialist),
                            style = MaterialTheme.typography.subtitle2,
                            color = Color.Black.copy(alpha = 0.60f)
                        )
                    },
                )
                Spacer(modifier = Modifier.height(36.dp))
                CustomButton(
                    text = stringResource(id = R.string.btn_submit),
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun RegistrationScreenPreview() {
    ClinicsAppTheme {
        RegistrationScreen(navController = rememberNavController())
    }
}
