package com.furkan.maraton4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultOyuncuDto {

    private String ad;
    private Long id;
    private String Username;
    private int puan;
}
