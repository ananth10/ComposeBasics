package com.ananth.composebasics.preview

import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, fontScale = 1.0f, name = "Default (100%)")
@Preview(showBackground = true, fontScale = 0.85f, name = "Small (85%)")
@Preview(showBackground = true, fontScale = 1.15f, name = "Large (115%)")
@Preview(showBackground = true, fontScale = 1.3f, name = "Largest (130%)")
annotation class FontScalePreview()
