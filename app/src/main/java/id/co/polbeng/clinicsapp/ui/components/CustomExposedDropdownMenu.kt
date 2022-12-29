package id.co.polbeng.clinicsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import id.co.polbeng.clinicsapp.ui.theme.ClinicsAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomExposedDropdownMenu(
    modifier: Modifier = Modifier,
    options: List<String>,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (label != null) {
            label()
            Spacer(modifier = Modifier.height(8.dp))
        }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colors.backgroundColor(enabled = enabled).value, shape)
                    .height(40.dp),
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = true,
                textStyle = MaterialTheme.typography.subtitle1,
                cursorBrush = SolidColor(colors.cursorColor(isError).value),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = false,
                decorationBox = { innerTextField ->
                    TextFieldDefaults.OutlinedTextFieldDecorationBox(
                        value = value,
                        visualTransformation = visualTransformation,
                        innerTextField = innerTextField,
                        singleLine = false,
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = colors,
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        border = {
                            TextFieldDefaults.BorderBox(
                                enabled = enabled,
                                isError = isError,
                                interactionSource = interactionSource,
                                colors = colors,
                                shape = shape
                            )
                        },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        }
                    )
                }
            )
            DropdownMenu(
                modifier = Modifier.exposedDropdownSize(),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                properties = PopupProperties(
                    focusable = true,
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        modifier = Modifier.sizeIn(maxHeight = 40.dp),
                        onClick = {
                            onValueChange(selectionOption)
                            expanded = false
                        }
                    ) {
                        Text(
                            text = selectionOption,
                            style = MaterialTheme.typography.body2,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomExposedDropdownMenuPreview() {
    ClinicsAppTheme {
        CustomExposedDropdownMenu(
            options = listOf(
                "Option 1",
                "Option 2",
                "Option 3"
            ),
            value = "Option 1",
            onValueChange = {}
        )
    }
}
