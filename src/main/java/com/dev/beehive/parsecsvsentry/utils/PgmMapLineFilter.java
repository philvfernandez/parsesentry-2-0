package com.dev.beehive.parsecsvsentry.utils;

import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;

public class PgmMapLineFilter implements CsvToBeanFilter {

    private final MappingStrategy mappingStrategy;

    private final String aFilter = "pgmmap";

    public PgmMapLineFilter(MappingStrategy mappingStrategy) {
        this.mappingStrategy = mappingStrategy;
    }


    @Override
    public boolean allowLine(String[] strings) {
        if(aFilter.equals(strings[0])) {
            return true;
        }
        return false;
    }
}
