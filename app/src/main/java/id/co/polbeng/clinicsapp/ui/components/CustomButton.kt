package id.co.polbeng.clinicsapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.co.polbeng.clinicsapp.R
import id.co.polbeng.clinicsapp.ui.theme.ClinicsAppTheme

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    imageVector: @Composable (() -> Unit)? = null,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .size(40.dp)
            .shadow(0.dp),
        elevation = elevation,
        shape = RoundedCornerShape(25.dp),
    ) {
        if (imageVector != null) {
            imageVector()
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        }

        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    ClinicsAppTheme {
        CustomButton(
            text = stringResource(id = R.string.btn_submit),
            onClick = {}
        )
    }
}
