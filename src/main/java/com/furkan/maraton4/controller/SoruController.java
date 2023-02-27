package com.furkan.maraton4.controller;
import com.furkan.maraton4.dto.request.SoruSaveRequestDto;
import com.furkan.maraton4.dto.response.SoruResponseDto;
import com.furkan.maraton4.service.SoruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.furkan.maraton4.constants.RestEndPoints.*;
@RestController
@RequestMapping(VERSION+API+SORU)
@RequiredArgsConstructor
public class SoruController {


    private final SoruService soruService;

    @PostMapping(SAVE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> createSoru(@RequestBody SoruSaveRequestDto dto){
        soruService.save(dto);
        return ResponseEntity.ok("soru save edildi");
    }


    @DeleteMapping(DELETE)
    public ResponseEntity<String> deleteById(Long id){
        soruService.deleteById(id);
        return ResponseEntity.ok("soru silindi");
    }
}
