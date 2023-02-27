package com.furkan.maraton4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OyuncuResponseDto {

    private String ad;
    private String soyad;
    private String username;
    private String avatar;
    private int puan;
}
