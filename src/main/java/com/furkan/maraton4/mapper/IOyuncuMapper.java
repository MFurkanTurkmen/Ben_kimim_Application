package com.furkan.maraton4.mapper;

import com.furkan.maraton4.dto.request.DefaultOyuncuDto;
import com.furkan.maraton4.dto.request.OyuncuSaveRequestDto;
import com.furkan.maraton4.dto.request.OyuncuUpdateRequestDto;
import com.furkan.maraton4.dto.response.OyuncuResponseDto;
import com.furkan.maraton4.repository.entity.Oyuncu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOyuncuMapper {
    IOyuncuMapper INSTANCE = Mappers.getMapper(IOyuncuMapper.class);
    Oyuncu toOyuncu(final OyuncuSaveRequestDto dto);
    Oyuncu toOyuncu(final OyuncuUpdateRequestDto dto);
    Oyuncu toOyuncu(final DefaultOyuncuDto dto);


    OyuncuResponseDto toDto(final Oyuncu oyuncu);


}
