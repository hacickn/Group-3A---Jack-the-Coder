package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;

public interface UniversityService {

    UniversityDto createUniversity ( UniversityDto universityDto );

    UniversityDto getUniversity ( long universityId );
}
