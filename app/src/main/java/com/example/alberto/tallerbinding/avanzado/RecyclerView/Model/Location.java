package com.example.alberto.tallerbinding.avanzado.RecyclerView.Model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
* Created by Alberto on 09/10/2015.
*/
public class Location {

    private String street;
    private String city;
    private String state;
    private Integer zip;

    /**
     * @return The street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street The street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The zip
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * @param zip The zip
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
