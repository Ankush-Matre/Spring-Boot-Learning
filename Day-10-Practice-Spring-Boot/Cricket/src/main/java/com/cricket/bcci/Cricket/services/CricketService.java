package com.cricket.bcci.Cricket.services;

import com.cricket.bcci.Cricket.dtos.CricketerDTO;
import com.cricket.bcci.Cricket.entities.CricketerEntity;
import com.cricket.bcci.Cricket.repositories.CricketerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CricketService {

    private final ModelMapper modelMapper;
    private final CricketerRepository cricketerRepository;

    public CricketService(ModelMapper modelMapper, CricketerRepository cricketerRepository) {
        this.modelMapper = modelMapper;
        this.cricketerRepository = cricketerRepository;
    }

    public Optional<CricketerDTO> getCricketerById(Integer id) {
        //Always remember map works on optional not on Object
        //FindById gives Optional not Object
        Optional<CricketerEntity> cricketerEntity = cricketerRepository.findById(id);

        return cricketerEntity
                .map(entity -> modelMapper.map(entity, CricketerDTO.class));
    }

    public List<CricketerDTO> getAllCricketers() {
        List<CricketerEntity> cricketerEntities = cricketerRepository.findAll();
        return cricketerEntities
                .stream()
                .map(cricketerEntity -> modelMapper.map( cricketerEntity, CricketerDTO.class))
                .collect(Collectors.toList());

    }

    public CricketerDTO createNewEmployee(CricketerDTO newCricketer) {
        CricketerEntity saveCricketEnity = modelMapper.map(newCricketer , CricketerEntity.class);
        CricketerEntity toSaveEntity = cricketerRepository.save(saveCricketEnity);
        return modelMapper.map(toSaveEntity , CricketerDTO.class);
    }

    public void isExistByCricketerId(Integer cricketerId){
        boolean exists = cricketerRepository.existsById(cricketerId);
        if(!exists){
            System.out.println("Cricketer Not Exists in database");
        }
    }
    public boolean deleteCricketerById(Integer cricketerId) {
        isExistByCricketerId(cricketerId);
        cricketerRepository.deleteById(cricketerId);
        return true;
    }
}
