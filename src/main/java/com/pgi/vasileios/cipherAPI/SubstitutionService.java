package com.pgi.vasileios.cipherAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubstitutionService implements ISubstitutionService {
    @Autowired
    private SubstitutionRepository rep;

    @Override
    public List<SubstitutionStrings> findAll() {
        return (List<SubstitutionStrings>) rep.findAll();
    }

    @Override
    public List<SubstitutionStrings> findByName(String name) {
        return (List<SubstitutionStrings>) rep.findByName(name);
    }


}
