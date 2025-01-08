package com.zerobase.com.zerobase.consumer.service

import com.zerobase.com.zerobase.consumer.dto.ReviewResponseDto
import com.zerobase.com.zerobase.kafka.dto.LoanRequestDto
import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.repository.LoanReviewRepository
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestService(
    private val loanReviewRepository: LoanReviewRepository
) {
    companion object {
        const val cssUrl = "http://localhost:8081/css/api/v1/request"
    }
    fun loanRequest(loanRequestDto: LoanRequestDto) {
        val reviewResult = loanRequestToCb(loanRequestDto)
        saveLoanReviewData(reviewResult.toLoanReviewEntity())
    }

    fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto {
        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
        .build()

        return restTemplate.postForEntity(cssUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }

    fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}