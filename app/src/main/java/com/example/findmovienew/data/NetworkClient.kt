package com.example.findmovienew.data

import com.example.findmovienew.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response
}