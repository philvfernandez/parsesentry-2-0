package com.dev.beehive.parsecsvsentry.domain;

import com.opencsv.bean.CsvBindByName;

public class PgmMap {

    @CsvBindByName(column = "#type")
    private String type;

    @CsvBindByName(column = "#provider_name")
    private String provider_name;

    @CsvBindByName(column = "#icon_ref")
    private String icon_ref;

    @CsvBindByName(column = "#port")
    private String port;

    @CsvBindByName(column = "#program_num")
    private String program_num;

    @CsvBindByName(column = "#icon_name")
    private String icon_name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getIcon_ref() {
        return icon_ref;
    }

    public void setIcon_ref(String icon_ref) {
        this.icon_ref = icon_ref;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProgram_num() {
        return program_num;
    }

    public void setProgram_num(String program_num) {
        this.program_num = program_num;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }
}
