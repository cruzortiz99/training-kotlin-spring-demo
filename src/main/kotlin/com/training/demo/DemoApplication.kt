package com.training.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = [
	"com.training.demo.controllers",
	"com.training.demo.config"
])
@ConfigurationPropertiesScan(
	basePackages = ["com.training.demo.config"])
@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
