package com.vir.isekai.config

import com.p6spy.engine.spy.P6SpyOptions
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration

@Configuration
class P6SpyConfig {
	@PostConstruct
	fun setLogMessageFormat() {
		P6SpyOptions.getActiveInstance().logMessageFormat = "com.vir.isekai.config.P6SpySqlFormatter"
	}
}