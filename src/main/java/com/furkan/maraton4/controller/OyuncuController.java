package com.furkan.maraton4.controller;
import com.furkan.maraton4.dto.request.DefaultOyuncuDto;
import com.furkan.maraton4.dto.request.OyuncuSaveRequestDto;
import com.furkan.maraton4.dto.request.OyuncuUpdateRequestDto;
import com.furkan.maraton4.dto.response.OyuncuResponseDto;
import com.furkan.maraton4.repository.entity.Oyuncu;
import com.furkan.maraton4.service.OyuncuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.furkan.maraton4.constants.RestEndPoints.*;
@RestController
@RequestMapping(VERSION+API+OYUNCU)
@RequiredArgsConstructor
public class OyuncuController {
    private final OyuncuService oyuncuService;

    @PostMapping(SAVE)
    @CrossOrigin(origins = "*")
    public ResponseEntity<String>  createOyuncu(@RequestBody OyuncuSaveRequestDto dto){
        oyuncuService.save(dto);
        return ResponseEntity.ok("oyuncu save edildi");
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<OyuncuResponseDto>>  findAll(){
        return ResponseEntity.ok(oyuncuService.findAllDto());
    }

    @PostMapping(UPDATE)
    public ResponseEntity<String> updateOyuncu(@RequestBody OyuncuUpdateRequestDto dto){
        oyuncuService.updateDto(dto);
        return ResponseEntity.ok("oyuncu update edildi");
    }


    @GetMapping(FINDBYNAME)
    public ResponseEntity<List<OyuncuResponseDto>> findByName(DefaultOyuncuDto dto){
        return ResponseEntity.ok(oyuncuService.findByName(dto));
    }

    @DeleteMapping(DELETE)
    public ResponseEntity<String> deleteById(DefaultOyuncuDto dto){
        oyuncuService.deleteById(dto);
        return ResponseEntity.ok("oyuncu silindi");
    }

    @GetMapping(FINDBYGRATHERTHAN)
    public ResponseEntity<List<OyuncuResponseDto>> findByPuanGreaterThan(DefaultOyuncuDto dto){
       return ResponseEntity.ok(oyuncuService.findByPuanGreaterThan(dto)) ;
    }
}
