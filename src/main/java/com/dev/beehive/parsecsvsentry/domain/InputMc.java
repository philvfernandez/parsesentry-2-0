package com.dev.beehive.parsecsvsentry.domain;

import com.opencsv.bean.CsvBindByName;

public class InputMc {

    @CsvBindByName(column = "#type*")
    private String type;

    @CsvBindByName(column = "#port_name*")
    private  String port_name;

    @CsvBindByName(column = "#port_number*")
    private String port_number;

    @CsvBindByName(column = "#port_desc")
    private String port_desc;

    @CsvBindByName(column = "#mc_source_addr")
    private String mc_source_addr;

    @CsvBindByName(column = "#mc_group")
    private String mc_group;

    @CsvBindByName(column = "#mc_udp_port")
    private String mc_udp_port;

    @CsvBindByName(column = "#config_id*")
    private String config_id;

    @CsvBindByName(column = "#enabled")
    private String enabled;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPort_name() {
        return port_name;
    }

    public void setPort_name(String port_name) {
        this.port_name = port_name;
    }

    public String getPort_number() {
        return port_number;
    }

    public void setPort_number(String port_number) {
        this.port_number = port_number;
    }

    public String getPort_desc() {
        return port_desc;
    }

    public void setPort_desc(String port_desc) {
        this.port_desc = port_desc;
    }

    public String getMc_source_addr() {
        return mc_source_addr;
    }

    public void setMc_source_addr(String mc_source_addr) {
        this.mc_source_addr = mc_source_addr;
    }

    public String getMc_group() {
        return mc_group;
    }

    public void setMc_group(String mc_group) {
        this.mc_group = mc_group;
    }

    public String getMc_udp_port() {
        return mc_udp_port;
    }

    public void setMc_udp_port(String mc_udp_port) {
        this.mc_udp_port = mc_udp_port;
    }

    public String getConfig_id() {
        return config_id;
    }

    public void setConfig_id(String config_id) {
        this.config_id = config_id;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
