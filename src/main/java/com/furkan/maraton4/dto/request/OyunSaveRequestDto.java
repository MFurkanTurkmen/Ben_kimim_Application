package com.furkan.maraton4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OyunSaveRequestDto {

    private Long soruid;
    private Long oyuncuid;
}
