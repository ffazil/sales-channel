package com.tracebucket.x.saleschannel.query.repository;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SalesChannelEntryRepository extends ElasticsearchRepository<SalesChannelEntry, String> {
	Page<SalesChannelEntry> findByName(String name,  Pageable pageable);
/*
	Page<SalesChannelEntry> findByDescription(String description,  Pageable pageable);
	Page<SalesChannelEntry> findByChannelType(SalesChannelType channelType,  Pageable pageable);
	Page<SalesChannelEntry> findByNameAndType(String name, SalesChannelType channelType, Pageable pageable);
*/
}
