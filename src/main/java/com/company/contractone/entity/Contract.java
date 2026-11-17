package com.company.contractone.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "CTRACT_CONTRACT")
@Entity(name = "ctract_Contract")
@Comment("Хранение данных о Договоре или ДопСоглашении")
public class Contract {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contract")
    private ContractConclusion contractConclusion;

    @JoinColumn(name = "PARENT_CONTRACT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Contract parentContract;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @Column(name = "TYPE_")
    private String type;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ContractConclusion getContractConclusion() {
        return contractConclusion;
    }

    public void setContractConclusion(ContractConclusion contractConclusion) {
        this.contractConclusion = contractConclusion;
    }

    public ContractType getType() {
        return type == null ? null : ContractType.fromId(type);
    }

    public void setType(ContractType type) {
        this.type = type == null ? null : type.getId();
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contract getParentContract() {
        return parentContract;
    }

    public void setParentContract(Contract parentContract) {
        this.parentContract = parentContract;
    }

}
