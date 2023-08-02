package com.example.jan.service;


import com.example.jan.model.Delegate;
import com.example.jan.repository.DelegateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DelegateServiceImpl implements DelegateService {


    private final DelegateRepository delegateRepository;

    public DelegateServiceImpl(DelegateRepository delegateRepository) {
        this.delegateRepository = delegateRepository;
    }


    @Override
    public Delegate saveDelegate(Delegate delegate) {
        return delegateRepository.save(delegate);
    }

    @Override
    public Delegate getDelegateById(Long id) {
        return delegateRepository.findById(id).stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Delegate not found with this id: "+ id));
    }

    @Override
    public List<Delegate> getAllDelegates() {
        return delegateRepository.findAll();
    }

    @Override
    public void deleteDelegate(Long id) {
        delegateRepository.deleteById(id);
    }
}
