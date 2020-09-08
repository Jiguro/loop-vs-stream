package com.example.loopvsstream.util;

import com.example.loopvsstream.model.Contract;
import com.example.loopvsstream.model.LegalPerson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ContractUtils {

    public static Map<LegalPerson, List<Contract>> groupContractsByCompany(List<Contract> contracts,
                                                                           boolean onlyIncludeActive) {
        Map<LegalPerson, List<Contract>> result = new HashMap<>();
        for (Contract c : contracts) {
            if (!onlyIncludeActive || c.isActive()) {
                if (c.getContractHolder() instanceof LegalPerson) {
                    LegalPerson companyContractHolder = (LegalPerson) c.getContractHolder();
                    if (!result.containsKey(companyContractHolder)) {
                        result.put(companyContractHolder, new LinkedList<>());
                    }

                    result.get(companyContractHolder).add(c);
                }
            }
        }

        return result;
    }

}
