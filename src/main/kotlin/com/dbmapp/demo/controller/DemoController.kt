package com.dbmapp.demo.controller

import com.dbmapp.demo.data.City
import com.dbmapp.demo.data.CityRepository
import com.dbmapp.demo.data.Country
import com.dbmapp.demo.data.CountryRepository
import com.dbmapp.demo.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class DemoController(val countryService: CountryService) {
    @GetMapping("/demo")
    fun demo(): Mono<Country> {
        return countryService.saveCountry()
    }
}