package com.company.contractshortdiag.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ContractType implements EnumClass<String> {

    CONTRACT_PRJ("A"),
    CONTRACT_AGREEMENT("B"),
    CONTRACT_CONCLUSION_PRJ("C"),
    CONTRACT_CONCLUSION_AGR("D");

    private final String id;

    ContractType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ContractType fromId(String id) {
        for (ContractType at : ContractType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}