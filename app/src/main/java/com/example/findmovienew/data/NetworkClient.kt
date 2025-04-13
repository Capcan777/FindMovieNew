package com.example.findmovienew.data

import com.example.findmovienew.data.dto.Response

interface NetworkClient {
    suspend fun doRequestSuspend(dto: Any): Response
}