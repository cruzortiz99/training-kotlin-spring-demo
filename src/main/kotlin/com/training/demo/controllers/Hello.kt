package com.training.demo.controllers
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@Tag(name="HelloController")
class HelloController {
    @Operation(description = "Say hello")
    @GetMapping("hello")
    fun greeting(): String {
        return "Hola Mundo"
    }
}