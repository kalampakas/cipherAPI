package com.pgi.vasileios.cipherAPI;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubstitutionRepository extends CrudRepository<SubstitutionStrings, Long> {
    List<SubstitutionStrings> findByName(String name);

}
