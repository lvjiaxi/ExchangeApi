package com.iduoyu.Entity;

public class KlineDay {
    String symbol;
    long opentime;
    String open;
    String high;
    String low;
    String close;
    String volume;
    String closetime;
    String split;

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public KlineDay() {
    }

    @Override
    public String toString() {
        return "{'"+symbol+'\''+","+opentime+",'"+open+'\''+",'"+high+'\''+",'"+low+'\''+",'"+close+'\''+",'"+volume+'\''+",'"+closetime+'\''+",'"+split+'\''+'}';
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getOpentime() {
        return opentime;
    }

    public void setOpentime(long opentime) {
        this.opentime = opentime;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime;
    }

    public KlineDay(String symbol, long opentime, String open, String high, String low, String close, String volume, String closetime) {

        this.symbol = symbol;
        this.opentime = opentime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closetime = closetime;
    }
}
