package com.furkan.maraton4.mapper;

import com.furkan.maraton4.dto.request.SoruSaveRequestDto;
import com.furkan.maraton4.dto.response.SoruResponseDto;
import com.furkan.maraton4.repository.entity.Soru;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISoruMapper {
    ISoruMapper INSTANCE = Mappers.getMapper(ISoruMapper.class);

    Soru toSoru(final SoruSaveRequestDto dto);

    SoruResponseDto toDto(final Soru soru);
}
