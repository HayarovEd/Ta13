package appdenga.onlinerubnakartu.data.mapper

import appdenga.onlinerubnakartu.data.remote.LoanDto
import appdenga.onlinerubnakartu.domain.model.Loan

fun List<LoanDto>.mapToLoan(): List<Loan> {
    return this.map {
        Loan(
            imageUrl = it.imageUrl,
            percent = it.percent,
            sumOne = it.sumOne,
            url = it.url,
            age = it.age,
            daysInfo = it.daysInfo
        )
    }
}