package com.briantical

import java.time.LocalDateTime

data class Summary(
    val active: Int=0,
    val deaths : Int =0,
    val confirmed: Int =0,
    val recovered: Int =0
)

data class Tests(
    val total : Int = 0,
    val contacts: Int = 0,
    val pointsofentry: Int = 0
)

data class Locations(
    val address: String,
    val cases: Int = 0
)

data class Confirmed(
    val total: Int = 0,
    val contacts: Int = 0,
    val pointsofentry: Int = 0,
    val locations: Array<Locations>
)

data class Cases(
    val confirmed: Confirmed,
    val active: Int = 0,
    val deaths: Int = 0,
    val recovered: Int = 0
)

data class Reports(
    val date: LocalDateTime = LocalDateTime.now(),
    val tests: Tests,
    val cases: Cases
)

data class Statistics(
    var summary: Summary,
    var reports: Array<Reports>
)

//The report is returned on an API call
data class Report(
    val country: String = "Uganda",
    val population: Int = 42_720_000,
    val source: String = "Ministry of Health (Uganda)",
    var statistics: Statistics
)