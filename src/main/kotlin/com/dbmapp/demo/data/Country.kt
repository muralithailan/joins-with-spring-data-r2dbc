package com.dbmapp.demo.data

import jakarta.persistence.CascadeType
import jakarta.persistence.OneToMany
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

@Table("country")
data class Country(
        @Id val id: Int?,
        val name: String,
)

interface CountryRepository: ReactiveCrudRepository<Country, Int>{
        fun save(country: Country):Mono<Country>
}
