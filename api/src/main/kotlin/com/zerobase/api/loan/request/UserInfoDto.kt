package com.zerobase.api.loan.request

import com.zerobase.com.zerobase.kafka.dto.LoanRequestDto
import com.zerobase.domain.domain.UserInfo

class UserInfoDto (
    val userKey: String,
    val userName: String,
    val userRegistrationNumber: String,
    val userIncomeAmount: Long
){
    fun toEntity(): UserInfo =
        UserInfo(
            userKey, userName, userRegistrationNumber, userIncomeAmount
        )

    fun toLoanRequestKafkaDto() = LoanRequestDto(userKey, userName, userIncomeAmount, userRegistrationNumber)
}