package com.example.jan.service;


import com.example.jan.model.Delegate;
import com.example.jan.repository.DelegateRepository;
import com.example.jan.unit.Type;
import org.springframework.beans.BeanUtils;
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
        // TODO: вынеси в отдельный метод проверку checkIFIdentical
        if (delegateRepository.existsByRequisiteAndDtBegAndDtEnd(
                delegate.getRequisite(),
                delegate.getDtBeg(),
                delegate.getDtEnd())
        ) {
            throw new IllegalArgumentException(String.format("Delegate with requisite: '%s' and Begin Date:'%s'" +
                            "and End Date:'%s' already exists",
                    delegate.getRequisite(),
                    delegate.getDtBeg(),
                    delegate.getDtEnd()));

        }
        return delegateRepository.save(delegate);
    }

    @Override
    public Delegate saveDelegate(Delegate delegate, Boolean isNowActive, Type type) {
        if (delegateRepository.existsByRequisiteAndDtBegAndDtEnd(
                delegate.getRequisite(),
                delegate.getDtBeg(),
                delegate.getDtEnd())
        ) {
            throw new IllegalArgumentException(String.format("Delegate with requisite: '%s' and Begin Date:'%s'" +
                            "and End Date:'%s' already exists",
                    delegate.getRequisite(),
                    delegate.getDtBeg(),
                    delegate.getDtEnd()));

        }
        if (type == null) {
            delegate.setType(delegate.getType());
        }
        delegate.setType(type);

        if (isNowActive == null) {
            delegate.setIsNowActive(delegate.getIsNowActive());
        }
        delegate.setIsNowActive(isNowActive);
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

    @Override
    public Delegate updateDelegate(Long id, Delegate delegateToUpdate) {
        Delegate existingDelegate = delegateRepository.findById(id)
                .stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This Delegate not found with ID: "+ id));

        BeanUtils.copyProperties(delegateToUpdate, existingDelegate, "id");

        return delegateRepository.save(existingDelegate);
    }





}
