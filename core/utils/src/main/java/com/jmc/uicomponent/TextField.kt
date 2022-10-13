package com.jmc.uicomponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.jmc.theme.WhiteAluminum
import com.jmc.utils.textFieldOnSurface


@Composable
fun SearchTextField(
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {}
) =
    BaseTextField(label = "", onValueChange = onValueChange) { showHint, innerTextField ->
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (showHint) {
                    Hint(hint)
                }
                innerTextField()
            }
        }
    }

@Composable
fun TextField(
    hint: String,
    label: String,
    onValueChange: (String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) =
    BaseTextField(
        label = label,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions
    ) { showHint, innerTextField ->
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
        ) {
            if (showHint) {
                Hint(hint)
            }
            innerTextField()
        }
    }

@Composable
fun PasswordTextField(
    hint: String,
    label: String,
    onValueChange: (String) -> Unit = {},
    forgotPassword: () -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) = BaseTextField(
    label = label,
    onValueChange = onValueChange,
    keyboardOptions = keyboardOptions,
    visualTransformation = visualTransformation
) { showHint, innerTextField ->
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize(),
    ) {
        if (showHint) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Hint(hint, Modifier.weight(1f))
                Forgot(forgotPassword)
            }
        }
        innerTextField()
    }
}

@Composable
private fun Forgot(forgotPassword: () -> Unit) = Text(
    text = "FORGOT?",
    style = MaterialTheme.typography.overline,
    color = MaterialTheme.colors.textFieldOnSurface,
    modifier = Modifier.clickable { forgotPassword() }
)

@Composable
private fun Hint(text: String, modifier: Modifier = Modifier) = Text(
    text = text,
    style = MaterialTheme.typography.subtitle1,
    color = WhiteAluminum,
    modifier = modifier
)



