package com.mesum.cryptotracker.domain.model

import com.mesum.cryptotracker.data.remote.dto.*

data class CoinDetail(val coinId: String,
                      val name: String,
                      val description: String,
                      val symbol: String,
                      val rank: Int,
                      val is_active: Boolean,
                      val tags: List<String>,
                      val team: List<TeamMember>,
                      val links: Links,
                      val logo: String,
                      val started_at: String,
                      val type: String,
                      val whitepaper: Whitepaper
)
