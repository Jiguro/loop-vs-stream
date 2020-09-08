package com.example.loopvsstream.util;

import com.example.loopvsstream.model.Contract;
import com.example.loopvsstream.model.LegalPerson;
import com.example.loopvsstream.model.NaturalPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ContractUtilsTest {

    private LegalPerson companyA;
    private LegalPerson companyB;

    @BeforeEach
    void beforeEach() {
        companyA = new LegalPerson();
        companyB = new LegalPerson();
    }

    @Test
    void shouldGroupContractsByCompany() {
        Map<LegalPerson, List<Contract>> result = ContractUtils.groupContractsByCompany(testContracts(), false);

        assertThat(result).hasSize(2)
                .containsOnlyKeys(companyA, companyB);
        assertThat(result.get(companyA)).hasSize(2);
        assertThat(result.get(companyB)).hasSize(2);
    }

    @Test
    void shouldGroupContractsByCompany_onlyActive() {
        Map<LegalPerson, List<Contract>> result = ContractUtils.groupContractsByCompany(testContracts(), true);

        assertThat(result).hasSize(2)
                .containsOnlyKeys(companyA, companyB);
        assertThat(result.get(companyA)).hasSize(2);
        assertThat(result.get(companyB)).hasSize(1);
    }

    private List<Contract> testContracts() {
        NaturalPerson individualA = new NaturalPerson();

        return Arrays.asList(
                new Contract().setContractHolder(companyA).setActive(true),
                new Contract().setContractHolder(companyA).setActive(true),
                new Contract().setContractHolder(companyB).setActive(false),
                new Contract().setContractHolder(companyB).setActive(true),
                new Contract().setContractHolder(individualA).setActive(true)
        );
    }
}
