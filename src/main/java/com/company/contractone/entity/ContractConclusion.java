package com.company.contractshortdiag.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CTRACT_CONTRACT_CONCLUSION", indexes = {
        @Index(name = "IDX_CTRACT_CONTRACT_CONCLUSION_CONTRACT_PRJ", columnList = "CONTRACT_PRJ_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_CONCLUSION_STATEMENT", columnList = "STATEMENT_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_CONCLUSION_TECHNICAL_SPECIFICATION", columnList = "TECHNICAL_SPECIFICATION_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_CONCLUSION_PARENT_CONTRACT_CONCLUSION", columnList = "PARENT_CONTRACT_CONCLUSION_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_CONCLUSION_OPERATOR", columnList = "OPERATOR_ID"),
        @Index(name = "IDX_CTRACT_CONTRACT_CONCLUSION_ROOT_CONTRACT_CONCLUSION", columnList = "ROOT_CONTRACT_CONCLUSION_ID")
})
@Entity(name = "ctract_ContractConclusion")
public class ContractConclusion {

    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @JoinTable(name = "CSD_CONTRACT_CONCLUSION_CONTRACT_LINK",
            joinColumns = @JoinColumn(name = "CONTRACT_CONCLUSION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Contract> contract;

    @JoinColumn(name = "ROOT_CONTRACT_CONCLUSION_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private ContractConclusion rootContractConclusion;

    @JoinColumn(name = "PARENT_CONTRACT_CONCLUSION_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private ContractConclusion parentContractConclusion;

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

    public ContractConclusion getParentContractConclusion() {
        return parentContractConclusion;
    }

    public void setParentContractConclusion(ContractConclusion parentContractConclusion) {
        this.parentContractConclusion = parentContractConclusion;
    }

    public ContractConclusion getRootContractConclusion() {
        return rootContractConclusion;
    }

    public void setRootContractConclusion(ContractConclusion rootContractConclusion) {
        this.rootContractConclusion = rootContractConclusion;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    public List<Contract> getContract() {
        return contract;
    }

}