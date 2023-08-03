package com.example.jan.service;
import com.example.jan.model.Delegate;
import com.example.jan.unit.Type;

import java.util.List;

public interface DelegateService {
    Delegate saveDelegate(Delegate delegate);
    Delegate saveDelegate(Delegate delegate, Boolean activity, Type type);
    Delegate getDelegateById(Long id);
    List<Delegate> getAllDelegates();
    void deleteDelegate(Long id);
    Delegate updateDelegate(Long id, Delegate delegateToUpdate);
}
