package com.zerobase.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = ["com.zerobase"])
@EnableJpaRepositories(basePackages = ["com.zerobase.domain"])  // 리포지토리 경로 지정
@EntityScan(basePackages = ["com.zerobase.domain"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}