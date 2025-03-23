package com.example.findmovienew.data.dto


data class NamesSearchResponse(
    val expression: String,
    val results: List<PersonDto>,
    val searchType: String
): Response()