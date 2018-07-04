package com.apress.prospring4.ch3.oracle;

import org.springframework.stereotype.Service;

@Service("oracle")
public class BookwormOracle implements Oracle {
    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedies are a waste of money - use the Internet";
    }
}
