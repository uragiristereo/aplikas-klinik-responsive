package id.co.polbeng.clinicsapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import id.co.polbeng.clinicsapp.ui.theme.ClinicsAppTheme

@Composable
fun CustomRadioButton(
    modifier: Modifier = Modifier,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        if (label != null) {
            label()
            Spacer(modifier = Modifier.height(8.dp))
        }

        FlowRow(
            modifier = Modifier
                .selectableGroup()
                .fillMaxWidth(),
            mainAxisSpacing = 24.dp,
            crossAxisSpacing = 8.dp
        ) {
            options.forEach { text ->
                Row(
                    modifier = Modifier.height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        modifier = Modifier.semantics {
                            contentDescription = text
                        },
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        },
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(start = 0.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomRadioButtonPreview() {
    ClinicsAppTheme {
        CustomRadioButton(
            options = listOf(
                "Option 1",
                "Option 2",
                "Option 3"
            ),
            selectedOption = "Option 1",
            onOptionSelected = {}
        )
    }
}