package com.furkan.maraton4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoruResponseDto {
    private String aciklama;
    private String resim;
    private Long time;
    private int puan;
    private int hak;
    private String  dogrucevap;
}
