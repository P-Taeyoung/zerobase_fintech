package com.zerobase.com.zerobase.consumer.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.zerobase.com.zerobase.kafka.dto.LoanRequestDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class LoanRequestConsumer(
    private val objectMapper: ObjectMapper
) {
    @KafkaListener(topics = ["loan_request"], groupId = "fintech")
    fun loanRequestTopicConsumer(message: String) {
        val loanRequestKafkaDto = objectMapper.readValue(message, LoanRequestDto::class.java)
    }
}