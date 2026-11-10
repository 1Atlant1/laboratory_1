package com.example.myapplication.domain


object TextProccesor {
    fun processText(input: String): List<String> {
        return input.split(' ', '.', ',', ';', ':', '-', '!', '?', '"')
            .map { it.trim().uppercase() }.filter { it.isNotEmpty() }.toSet().sorted()
    }
}