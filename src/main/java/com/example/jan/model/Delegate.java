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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "requisite", length = 5, nullable = false)
    private String requisite;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 30, nullable = false)
    private Type type;

    //TODO: валидация
    @Column(name = "value_name_firm", length = 30)
    private String valueNameFirm;

    //TODO: валидация
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

    //TODO: валидация
    @Basic
    @Column(name = "data_create_date", nullable = false)
    private LocalDateTime dataCreateDate;


    public Delegate() {
        if (this.userCreate == null) {
            this.userCreate = "USER";
        }
        this.userCreate = getUserCreate();

        if (this.dataCreateDate == null) {
            this.dataCreateDate = LocalDateTime.now();
        }
        this.dataCreateDate = getDataCreateDate();

        if (this.isNowActive == null) {
            this.isNowActive = true;
        }
        this.isNowActive = getIsNowActive();

        if (this.requisite == null) {
        }
        this.requisite = getRequisite();

        if (this.type == null) {
        }
        this.type = getType();

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public Boolean getIsNowActive() {
        return isNowActive;
    }

    public void setIsNowActive(Boolean nowActive) {
        isNowActive = nowActive;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public LocalDateTime getDataCreateDate() {
        return dataCreateDate;
    }

    public void setDataCreateDate(LocalDateTime dataCreateDate) {
        this.dataCreateDate = dataCreateDate;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }
}
