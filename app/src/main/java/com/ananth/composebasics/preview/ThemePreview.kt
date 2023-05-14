package com.ananth.composebasics.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
annotation class ThemePreview()
