package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.screens.TextProcessorScreen

@Composable
fun AppRoot(modifier: Modifier = Modifier) {
    TextProcessorScreen(modifier = modifier)
}