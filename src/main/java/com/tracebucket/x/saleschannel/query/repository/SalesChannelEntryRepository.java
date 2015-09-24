package com.tracebucket.x.saleschannel.query.repository;

import com.tracebucket.x.saleschannel.domain.model.SalesChannelType;
import com.tracebucket.x.saleschannel.query.model.SalesChannelEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SalesChannelEntryRepository extends ElasticsearchRepository<SalesChannelEntry, String> {
	SalesChannelEntry findByName(String name);
	SalesChannelEntry findByCode(String code);
	//Page<SalesChannelEntry> findAll(Pageable pageable);
/*
	Page<SalesChannelEntry> findByDescription(String description,  Pageable pageable);
	Page<SalesChannelEntry> findByChannelType(SalesChannelType channelType,  Pageable pageable);
	Page<SalesChannelEntry> findByNameAndType(String name, SalesChannelType channelType, Pageable pageable);
*/
}
