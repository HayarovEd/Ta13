package com.edurda77.presentation

import com.edurda77.domain.model.Loan

data class MainState(
    val moneyList: List<Loan> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = true
)
