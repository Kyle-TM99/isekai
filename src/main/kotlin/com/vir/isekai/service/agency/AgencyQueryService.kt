package com.vir.isekai.service.agency

import com.vir.isekai.dto.request.AgencyRequest
import com.vir.isekai.entity.Channel
import com.vir.isekai.repository.agency.AgencyRepository
import com.vir.isekai.repository.channel.ChannelRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor = [Exception::class])
class AgencyQueryService(
	private val agencyRepository: AgencyRepository,
	private val channelRepository: ChannelRepository,
) {
	fun saveAgency(request: AgencyRequest.Save) {
		val agency = agencyRepository.save(request.toEntity())

		val channels =
			request.channelInfos.map {
				Channel(
					null,
					agency,
					null,
					it.type,
					it.url,
				)
			}

		channelRepository.saveAll(channels)
	}
}