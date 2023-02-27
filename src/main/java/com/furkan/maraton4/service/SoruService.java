package com.furkan.maraton4.service;

import com.furkan.maraton4.dto.request.SoruSaveRequestDto;
import com.furkan.maraton4.dto.response.SoruResponseDto;
import com.furkan.maraton4.exception.EErrorType;
import com.furkan.maraton4.exception.Maraton4Exception;
import com.furkan.maraton4.mapper.ISoruMapper;
import com.furkan.maraton4.repository.ISoruRepository;
import com.furkan.maraton4.repository.ISoruRepository;
import com.furkan.maraton4.repository.entity.Soru;
import com.furkan.maraton4.repository.entity.Soru;
import com.furkan.maraton4.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SoruService extends ServiceManager<Soru,Long> {

    private final ISoruRepository soruRepository;
    public SoruService(ISoruRepository soruRepository){
        super(soruRepository);
        this.soruRepository = soruRepository;
    }
    

    public void save(SoruSaveRequestDto dto){
        Soru soru= ISoruMapper.INSTANCE.toSoru(dto);
        if(soruRepository.findOptionalByDogrucevap(soru.getDogrucevap()).isPresent())
            throw new Maraton4Exception(EErrorType.KULLANICI_BULUNAMADI,"soru zaten mevcut");

        save(soru);
    }

    public List<SoruResponseDto> findAllDto(){
        List<SoruResponseDto> dtoList=new ArrayList<>();
        for (Soru soru : findAll()){
            SoruResponseDto dto= ISoruMapper.INSTANCE.toDto(soru);
            dtoList.add(dto);
        }
        return dtoList;
    }


    public void deleteById(Long id){
        Soru soru = findById(id).get();
        if (soru==null ){
            throw new Maraton4Exception(EErrorType.KULLANICI_BULUNAMADI,"kullanici silerken id'ye ait kullanici bulunamadi");
        }
        delete(soru);
    }

}
