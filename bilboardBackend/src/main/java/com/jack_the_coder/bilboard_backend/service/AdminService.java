package com.jack_the_coder.bilboard_backend.service;

import com.jack_the_coder.bilboard_backend.shared.dto.UniversityDto;

/**
 * @author Hacı Çakın
 * @apiNote This class enables communication between controller and repository
 * @since 10.12.2021
 */
public interface AdminService {

    UniversityDto createUniversity ( UniversityDto universityDto );

    UniversityDto getUniversity ( long universityId );
}
