package com.company.contractshortdiag.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CTRACT_CONTRACT", indexes = {
        @Index(name = "IDX_CTRACT_CONTRACT_ORDER", columnList = "ORDER_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_ROOT_CONTRACT", columnList = "ROOT_CONTRACT_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_PARENT_CONTRACT", columnList = "PARENT_CONTRACT_ID")
})
@Entity(name = "ctract_Contract")
@Comment("Хранение данных о Договоре или ДопСоглашении")
public class Contract {

    @Id
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    private UUID id;

    @JoinTable(name = "CSD_CONTRACT_CONTRACT_CONCLUSION_LINK",
            joinColumns = @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTRACT_CONCLUSION_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<ContractConclusion> contractConclusions;

    @JoinColumn(name = "ROOT_CONTRACT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Contract rootContract;

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

    public Contract getRootContract() {
        return rootContract;
    }

    public void setRootContract(Contract rootContract) {
        this.rootContract = rootContract;
    }

    public void setContractConclusions(List<ContractConclusion> contractConclusions) {
        this.contractConclusions = contractConclusions;
    }

    public List<ContractConclusion> getContractConclusions() {
        return contractConclusions;
    }

}
