package com.example.jan.model;


import com.example.jan.unit.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "delegate")
@AllArgsConstructor
public class Delegate {

    public Delegate(String valueNameFirm, String valueInsteadNameFirm, boolean isNowActive, LocalDateTime dataCreate) {
        this.valueNameFirm = valueNameFirm;
        this.valueInsteadNameFirm = valueInsteadNameFirm;
        this.isNowActive = isNowActive;
        this.dataCreate = dataCreate;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 30, nullable = false)
    private Type type;

    @Column(name = "value_name_firm", length = 30)
    private String valueNameFirm;

    @Column(name = "value_instead_name_firm", length = 30)
    private String valueInsteadNameFirm;
    @Basic
    @Column(name = "dt_beg", nullable = false)
    private LocalDate dtBeg;
    @Basic
    @Column(name = "dt_end", nullable = false)
    private LocalDate dtEnd;

    @Column(name = "is_now_active", nullable = false)
    private Boolean isNowActive;


    @Column(name = "user_create", length = 255, nullable = false)
    private String userCreate;

    @Basic
    @Column(name = "data_create", nullable = false)
    private LocalDateTime dataCreate;


    public Delegate() {
        this.type = Type.OGRN;
        this.isNowActive = true;
        this.userCreate = "USER";
        this.dataCreate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValueNameFirm() {
        return valueNameFirm;
    }

    public void setValueNameFirm(String valueNameFirm) {
        this.valueNameFirm = valueNameFirm;
    }

    public String getValueInsteadNameFirm() {
        return valueInsteadNameFirm;
    }

    public void setValueInsteadNameFirm(String valueInsteadNameFirm) {
        this.valueInsteadNameFirm = valueInsteadNameFirm;
    }

    public LocalDate getDtBeg() {
        return dtBeg;
    }

    public void setDtBeg(LocalDate dtBeg) {
        this.dtBeg = dtBeg;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(LocalDate dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Boolean isNowActive() {
        return isNowActive;
    }

    public void setNowActive(Boolean nowActive) {
        isNowActive = nowActive;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public LocalDateTime getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(LocalDateTime dataCreate) {
        this.dataCreate = dataCreate;
    }
}
