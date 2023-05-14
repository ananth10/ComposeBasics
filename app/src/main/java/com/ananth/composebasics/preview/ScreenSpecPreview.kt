package com.ananth.composebasics.preview

import androidx.compose.ui.tooling.preview.Preview

@Preview(device = "spec:width=1920dp,height=1080dp,dpi=480,isRound=false,chinSize=0dp,orientation=portrait")
@Preview(name = "phone", device = "spec:width=411dp,height=891dp")
@Preview(name = "tablet", device = "spec:width=1280dp,height=800dp,dpi=480")
@Preview(name = "Desktop", device = "spec:width=1920dp,height=1080dp,dpi=480")
annotation class ScreenSpecPreview()
