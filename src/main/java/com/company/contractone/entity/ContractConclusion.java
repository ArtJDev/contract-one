package com.company.contractone.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "CTRACT_CONTRACT_CONCLUSION")
@Entity(name = "ctract_ContractConclusion")
public class ContractConclusion {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "CONTRACT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Contract contract;

    @JoinColumn(name = "PARENT_CONTRACT_CONCLUSION_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private ContractConclusion parentContractConclusion;

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

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Contract getContract() {
        return contract;
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

    public ContractConclusion getParentContractConclusion() {
        return parentContractConclusion;
    }

    public void setParentContractConclusion(ContractConclusion parentContractConclusion) {
        this.parentContractConclusion = parentContractConclusion;
    }

}