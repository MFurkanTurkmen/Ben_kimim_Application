package com.furkan.maraton4.mapper;

import com.furkan.maraton4.dto.request.OyunSaveRequestDto;
import com.furkan.maraton4.repository.entity.Oyun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyunMapper {
    IOyunMapper INSTANCE = Mappers.getMapper(IOyunMapper.class);

    Oyun oyun(final OyunSaveRequestDto dto);
}
