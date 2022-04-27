package com.fjoglar.composechallenge.wetrade.data

import com.fjoglar.composechallenge.wetrade.R
import com.fjoglar.composechallenge.wetrade.data.model.Stock

object Repository {

    val stocks = listOf(
        Stock(
            price = "$7,918",
            percentDelta = "-0.54%",
            name = "ALK",
            company = "Alaska Air Group, Inc.",
            graph = R.drawable.home_alk
        ),
        Stock(
            price = "$1,293",
            percentDelta = "+4.18%",
            name = "BA",
            company = "Boeing Co.",
            graph = R.drawable.home_ba
        ),
        Stock(
            price = "$893.50",
            percentDelta = "-0.54%",
            name = "DAL",
            company = "Delta Airlines Inc.",
            graph = R.drawable.home_dal
        ),
        Stock(
            price = "$12,301",
            percentDelta = "+2.51%",
            name = "EXPE",
            company = "Expedia Group Inc.",
            graph = R.drawable.home_exp
        ),
        Stock(
            price = "$12,301",
            percentDelta = "+1.38%",
            name = "EADSY",
            company = "Airbus SE",
            graph = R.drawable.home_eadsy
        ),
        Stock(
            price = "$8,521",
            percentDelta = "+1.56%",
            name = "JBLU",
            company = "Jetblue Airways Corp.",
            graph = R.drawable.home_jblu
        ),
        Stock(
            price = "$521",
            percentDelta = "+2.75%",
            name = "MAR",
            company = "Marriott International Inc.",
            graph = R.drawable.home_mar
        ),
        Stock(
            price = "$5,481",
            percentDelta = "+0.14%",
            name = "CCL",
            company = "Carnival Corp",
            graph = R.drawable.home_ccl
        ),
        Stock(
            price = "$9,184",
            percentDelta = "+1.69%",
            name = "RCL",
            company = "Royal Caribbean Cruises",
            graph = R.drawable.home_rcl
        ),
        Stock(
            price = "$654",
            percentDelta = "+3.23%",
            name = "TRVL",
            company = "Travelocity Inc.",
            graph = R.drawable.home_trvl
        )
    )
}