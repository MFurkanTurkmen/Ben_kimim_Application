package com.furkan.maraton4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OyuncuUpdateRequestDto {
    private String username;
    private String ad;
    private String soyad;
    private String Avatar;
    private String yas;
}
