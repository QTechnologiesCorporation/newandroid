package com.qtechnologiescorporation.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.qtechnologiescorporation.designsystem.spacing

@Composable
fun TermsAndConditionsCheckbox(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.labelSmall
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {
        Checkbox(
            modifier = Modifier.size(20.dp),
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                checkmarkColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        TermsAndConditionsText(
            textStyle = textStyle,
        )
    }
}

@Composable
fun TermsAndConditionsText(
    textStyle: TextStyle = MaterialTheme.typography.labelSmall,
) {
    val termsAndConditionsUrl = "https://www.qtechnologiescorporation.com/"
    val privacyPolicyUrl = "https://www.qtechnologiescorporation.com/"

    DisableSelection {
        Text(
            buildAnnotatedString {
                append("By signing up, you agree to our ")
                withLink(
                    LinkAnnotation.Url(
                        url = termsAndConditionsUrl,
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    )
                ) {
                    append("Terms & Conditions")
                }
                append(" and ")
                withLink(
                    LinkAnnotation.Url(
                        url = privacyPolicyUrl,
                        styles = TextLinkStyles(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    )
                ) {
                    append("Privacy Policy")
                }
                append(".")
            },
            style = textStyle,
        )
    }
}
