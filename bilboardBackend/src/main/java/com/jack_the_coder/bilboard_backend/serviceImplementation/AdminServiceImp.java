package com.jack_the_coder.bilboard_backend.serviceImplementation;

import com.jack_the_coder.bilboard_backend.io.entity.UniversityEntity;
import com.jack_the_coder.bilboard_backend.io.repository.UniversityRepository;
import com.jack_the_coder.bilboard_backend.service.AdminService;
import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public UniversityDto createUniversity ( UniversityDto universityDto ) {
        ModelMapper modelMapper = new ModelMapper();
        UniversityEntity universityEntity = modelMapper.map( universityDto , UniversityEntity.class );
        UniversityEntity createEntity = universityRepository.save( universityEntity );

        return modelMapper.map( createEntity , UniversityDto.class );
    }

    @Override
    public UniversityDto getUniversity ( long universityId ) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<UniversityEntity> universityEntity = universityRepository.findById( universityId );

        if ( universityEntity.isPresent() ) {
            return modelMapper.map( universityEntity.get() , UniversityDto.class );
        } else {
            return null;
        }
    }
}
