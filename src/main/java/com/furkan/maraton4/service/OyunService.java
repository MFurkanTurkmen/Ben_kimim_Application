package com.furkan.maraton4.service;

import com.furkan.maraton4.dto.request.OyunSaveRequestDto;
import com.furkan.maraton4.dto.response.OyunResponseDto;
import com.furkan.maraton4.exception.EErrorType;
import com.furkan.maraton4.exception.Maraton4Exception;
import com.furkan.maraton4.mapper.IOyunMapper;
import com.furkan.maraton4.repository.IOyunRepository;
import com.furkan.maraton4.repository.entity.Oyun;
import com.furkan.maraton4.repository.entity.Oyuncu;
import com.furkan.maraton4.repository.entity.Soru;
import com.furkan.maraton4.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OyunService extends ServiceManager<Oyun,Long> {
    private final IOyunRepository oyunRepository;
    private final OyuncuService oyuncuService;
    private final SoruService soruService;

    public OyunService(IOyunRepository oyunRepository, OyuncuService oyuncuService, SoruService soruService){
        super(oyunRepository);
        this.oyunRepository = oyunRepository;
        this.oyuncuService =oyuncuService ;
        this.soruService =soruService;
    }
    public void save(OyunSaveRequestDto dto){
        Oyun oyun =IOyunMapper.INSTANCE.oyun(dto);

        if (oyuncuService.findById(oyun.getOyuncuid()).isPresent() || soruService.findById(oyun.getSoruid()).isPresent()){
            oyun.setHak(5);
            save(oyun);
        }else throw new Maraton4Exception(EErrorType.INTERNAL_ERROR);

    }

    public String cevap(OyunResponseDto dto){
        if (findById(dto.getOyunid()).isPresent() && !dto.getCevap().isEmpty()){
            Oyun oyun =findById(dto.getOyunid()).get();
            Soru soru=soruService.findById(oyun.getSoruid()).get();
            Oyuncu oyuncu=oyuncuService.findById(oyun.getOyuncuid()).get();


            while (oyun.getHak()>0 && soru.getDogrucevap().equals(dto.getCevap())){
                System.out.println("while içinde doğru cevap verildi sorunun doğru cevabı" + soru.getDogrucevap()+" dto cevabı "+dto.getCevap());

                oyuncu.setPuan(soru.getPuan());
                oyuncuService.save(oyuncu);

                return "doğru cevap verdiniz aferin: "+soru.getPuan()+" puan kazandınız";

            } if (soru.getDogrucevap()!=dto.getCevap()) {
                oyun.setHak(oyun.getHak()-1);
                save(oyun);
                return "cevap doğru degil tekrar dene";
            }
            if (oyun.getHak()==0) {
                cevap(dto);
                oyuncu.setPuan(oyuncu.getPuan()-2);
                oyuncuService.save(oyuncu);
                return "hakkınız bitti soru bastan baslatılıyor ve puanınızdan 2 puan eksiliyor";
            }
        }
        throw new Maraton4Exception(EErrorType.INTERNAL_ERROR);
    }
}