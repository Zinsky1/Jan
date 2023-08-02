package com.example.jan.service;
import com.example.jan.model.Delegate;

import java.util.List;

public interface DelegateService {
    Delegate saveDelegate(Delegate delegate);
    Delegate getDelegateById(Long id);
    List<Delegate> getAllDelegates();
    void deleteDelegate(Long id);
}
