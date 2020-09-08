package com.example.loopvsstream.model;

public class Contract {

    private Person contractHolder;
    private boolean active;

    public Person getContractHolder() {
        return contractHolder;
    }

    public Contract setContractHolder(Person contractHolder) {
        this.contractHolder = contractHolder;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Contract setActive(boolean active) {
        this.active = active;
        return this;
    }
}
