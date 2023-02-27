package com.furkan.maraton4.service;


import com.furkan.maraton4.dto.request.DefaultOyuncuDto;
import com.furkan.maraton4.dto.request.OyuncuSaveRequestDto;
import com.furkan.maraton4.dto.request.OyuncuUpdateRequestDto;
import com.furkan.maraton4.dto.response.OyuncuResponseDto;
import com.furkan.maraton4.exception.EErrorType;
import com.furkan.maraton4.exception.Maraton4Exception;
import com.furkan.maraton4.mapper.IOyuncuMapper;
import com.furkan.maraton4.repository.IOyuncuRepository;
import com.furkan.maraton4.repository.entity.Oyuncu;
import com.furkan.maraton4.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OyuncuService extends ServiceManager<Oyuncu,Long> {

    private final IOyuncuRepository oyuncuRepository;

    public OyuncuService(IOyuncuRepository oyuncuRepository){
        super(oyuncuRepository);
        this.oyuncuRepository = oyuncuRepository;
    }

    public void save(OyuncuSaveRequestDto dto){
    Oyuncu oyuncu= IOyuncuMapper.INSTANCE.toOyuncu(dto);
    if (oyuncu.getUsername().isEmpty() || oyuncuRepository.findOptionalByUsername(dto.getUsername()).get()!=null){
        throw new Maraton4Exception(EErrorType.KULLANICI_BULUNAMADI);
    }
    oyuncu.setPuan(0);
        save(oyuncu);
    }

    public List<OyuncuResponseDto> findAllDto(){
        List<OyuncuResponseDto> dtoList=new ArrayList<>();
        for (Oyuncu oyuncu : findAll()){
            OyuncuResponseDto dto= IOyuncuMapper.INSTANCE.toDto(oyuncu);
            dtoList.add(dto);
        }
        return dtoList;
    }
    public void updateDto(OyuncuUpdateRequestDto dto){
        Oyuncu oyuncu= IOyuncuMapper.INSTANCE.toOyuncu(dto);
        if (oyuncu.getUsername().isEmpty() || oyuncu.getUsername()==oyuncuRepository.findOptionalByUsername(oyuncu.getUsername()).get().getUsername() ){

            throw new Maraton4Exception(EErrorType.KULLANICI_BULUNAMADI,"username olmadan update edemezsin");
        }
        save(oyuncu);
    }

    public List<OyuncuResponseDto> findByName(DefaultOyuncuDto dto){
        List<Oyuncu> oyuncuList = oyuncuRepository.findByAd(dto.getAd());
        List<OyuncuResponseDto> oyuncuDtoList = new ArrayList<>();
        if (!oyuncuList.isEmpty()){
            for (Oyuncu oyuncu:oyuncuList){
                OyuncuResponseDto dto2= IOyuncuMapper.INSTANCE.toDto(oyuncu);
                oyuncuDtoList.add(dto2);
            }
            return oyuncuDtoList;
        }
        throw new Maraton4Exception(EErrorType.KULLANICI_BULUNAMADI,"kullanici listesi bulunamadi");
    }

    public void deleteById(DefaultOyuncuDto dto){
        Oyuncu oyuncu = findById(dto.getId()).get();
        if (oyuncu==null ){
            throw new Maraton4Exception(EErrorType.KULLANICI_BULUNAMADI,"kullanici silerken id'ye ait kullanici bulunamadi");
        }
        delete(oyuncu);
    }

    /**
     * burada DefaultDto kullandığımız için swagger tarafında bir çok parametre gözüküyor
     * !!! -> sadece istediğimiz puandan yüksek olanları sıralamak için puan girmek yeterli.
     */
    public List<OyuncuResponseDto> findByPuanGreaterThan(DefaultOyuncuDto dto){
        List<OyuncuResponseDto> dtoList = new ArrayList<>();
        for (Oyuncu oyuncu : oyuncuRepository.findOptionalByPuanGreaterThan(dto.getPuan()).get() ){
            OyuncuResponseDto dto1=IOyuncuMapper.INSTANCE.toDto(oyuncu);
            dtoList.add(dto1);
        }

        return dtoList;
    }

}