package com.dbmapp.demo.data

import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Table("city")
data class City(
        @Id var id: Int?,
        var name: String,
        var countryId:Int?=null,
)

interface CityRepository: ReactiveCrudRepository<City, Int>{
    fun saveAll(cities: Flux<City>): Flux<City>
}
