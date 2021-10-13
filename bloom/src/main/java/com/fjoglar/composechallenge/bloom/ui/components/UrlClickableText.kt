package com.fjoglar.composechallenge.bloom.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

private const val URL_TAG = "URL"

@Composable
fun UrlClickableText(
    text: String,
    modifier: Modifier = Modifier,
    urls: Map<String, String> = mapOf(),
    textAlign: TextAlign? = null,
    style: TextStyle = TextStyle.Default,
) {
    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }

    val uriHandler = LocalUriHandler.current
    val annotatedText = createAnnotatedText(text, urls)

    Text(
        text = annotatedText,
        style = style,
        textAlign = textAlign,
        modifier = modifier.pointerInput(urls.keys) {
            detectTapGestures { offset ->
                layoutResult.value?.let { textLayoutResult ->
                    val position = textLayoutResult.getOffsetForPosition(offset)
                    annotatedText.getStringAnnotations(position, position).firstOrNull()
                        ?.let { result ->
                            if (result.tag == URL_TAG) {
                                uriHandler.openUri(result.item)
                            }
                        }
                }
            }
        },
        onTextLayout = { layoutResult.value = it }

    )
}

private fun createAnnotatedText(
    text: String,
    actions: Map<String, String>
): AnnotatedString =
    buildAnnotatedString {
        append(text)

        actions.forEach { action ->
            val linkText = action.key
            val url = action.value

            val startIndex = text.indexOf(linkText)
            val endIndex = startIndex.plus(linkText.length)

            addStyle(
                style = SpanStyle(textDecoration = TextDecoration.Underline),
                start = startIndex,
                end = endIndex
            )

            addStringAnnotation(
                tag = URL_TAG,
                annotation = url,
                start = startIndex,
                end = endIndex
            )
        }
    }

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun UrlClickableTextPreview() {
    BloomTheme {
        Surface {
            UrlClickableText(
                text = stringResource(id = R.string.log_in_legal_terms),
                urls = mapOf(
                    stringResource(id = R.string.log_in_terms_of_use) to "http://google.com",
                    stringResource(id = R.string.log_in_privacy_policy) to "http://google.com",
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}