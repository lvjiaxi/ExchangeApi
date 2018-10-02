package com.iduoyu.Entity;

public class Detail {
    private int id;
    private String symbol;
    private String realtimeprices;
    private String dayvolume;
    private String dayturnvolume;
    private int exchange;
    private double dailyincrease;
    private String coinsum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRealtimeprices() {
        return realtimeprices;
    }

    public void setRealtimeprices(String realtimeprices) {
        this.realtimeprices = realtimeprices;
    }

    public String getDayvolume() {
        return dayvolume;
    }

    public void setDayvolume(String dayvolume) {
        this.dayvolume = dayvolume;
    }

    public String getDayturnvolume() {
        return dayturnvolume;
    }

    public void setDayturnvolume(String dayturnvolume) {
        this.dayturnvolume = dayturnvolume;
    }

    public int getExchange() {
        return exchange;
    }

    public void setExchange(int exchange) {
        this.exchange = exchange;
    }

    public double getDailyincrease() {
        return dailyincrease;
    }

    public void setDailyincrease(double dailyincrease) {
        this.dailyincrease = dailyincrease;
    }

    public String getCoinsum() {
        return coinsum;
    }

    public void setCoinsum(String coinsum) {
        this.coinsum = coinsum;
    }

    public Detail() {
    }

    public Detail(int id, String symbol, String realtimeprices, String dayvolume, String dayturnvolume, int exchange, double dailyincrease, String coinsum) {
        this.id = id;
        this.symbol = symbol;
        this.realtimeprices = realtimeprices;
        this.dayvolume = dayvolume;
        this.dayturnvolume = dayturnvolume;
        this.exchange = exchange;
        this.dailyincrease = dailyincrease;
        this.coinsum = coinsum;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", realtimeprices='" + realtimeprices + '\'' +
                ", dayvolume='" + dayvolume + '\'' +
                ", dayturnvolume='" + dayturnvolume + '\'' +
                ", exchange=" + exchange +
                ", dailyincrease='" + dailyincrease + '\'' +
                ", coinsum='" + coinsum + '\'' +
                '}';
    }
}
