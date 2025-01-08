package com.zerobase.com.zerobase.consumer.service

import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestService(
    private val loanReviewRepository: LoanReviewRepository
) {
    fun loanRequest() {
        // TODO : CB Component 로 요청보내기
    }

    fun loanRequestToCb() {

    }

    fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}