package com.pgi.vasileios.cipherAPI;

import java.util.List;

public interface ISubstitutionService {
    List<SubstitutionStrings> findAll();
    List<SubstitutionStrings> findByName(String name);
}
