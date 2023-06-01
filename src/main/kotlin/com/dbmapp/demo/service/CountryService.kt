package com.dbmapp.demo.service

import com.dbmapp.demo.data.City
import com.dbmapp.demo.data.CityRepository
import com.dbmapp.demo.data.Country
import com.dbmapp.demo.data.CountryRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class CountryService(val countryRepository: CountryRepository, val cityRepository: CityRepository) {

    fun saveCountry(): Mono<Country> {
        val country = Country(id = null, name = "SA")

        return countryRepository.save(country)
                .flatMap { savedCountry -> saveCity(savedCountry).collectList().then(Mono.just(savedCountry)) }
    }

    fun saveCity(country: Country): Flux<City> {
        return cityRepository.saveAll(mapCity(country))
    }

    fun mapCity(country: Country): Flux<City> {
        val city1 = City(null, "SADL", country.id)
        val city2 = City(null, "SAKL", country.id)
        return Flux.fromIterable(listOf(city1, city2))
    }
}