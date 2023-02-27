package com.furkan.maraton4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SoruSaveRequestDto {
    private String aciklama;
    private String  dogrucevap;
    private String resim;
    private Long time;
    private int puan;
}
