package com.furkan.maraton4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OyunResponseDto {
    private Long oyunid;
    private String cevap;
}
