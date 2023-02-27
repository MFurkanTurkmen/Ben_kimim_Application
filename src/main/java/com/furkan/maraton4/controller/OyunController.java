package com.furkan.maraton4.controller;

import com.furkan.maraton4.dto.request.OyunSaveRequestDto;
import com.furkan.maraton4.dto.request.SoruSaveRequestDto;
import com.furkan.maraton4.dto.response.OyunResponseDto;
import com.furkan.maraton4.service.OyunService;
import com.furkan.maraton4.service.SoruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.furkan.maraton4.constants.RestEndPoints.*;
@RestController
@RequestMapping(VERSION+API+OYUN)
@RequiredArgsConstructor
public class OyunController {
    private final OyunService oyunService;

    @PostMapping(SAVE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> createSoru(@RequestBody OyunSaveRequestDto dto){
        oyunService.save(dto);
        return ResponseEntity.ok("oyun save edildi ve baslatildi");
    }
    @GetMapping(CEVAP)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public ResponseEntity<String> cevap(OyunResponseDto dto){

        return ResponseEntity.ok(oyunService.cevap(dto));
    }
}
