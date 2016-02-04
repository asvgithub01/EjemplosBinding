package com.example.alberto.tallerbinding.avanzado.RecyclerView.Model;

import java.util.ArrayList;
import java.util.List;

/**
* Created by Alberto on 09/10/2015.
*/
public class RamdonUserModel {

    private List<Result> results = new ArrayList<Result>();
    private String nationality;
    private String seed;
    private String version;

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     * @return The nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality The nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return The seed
     */
    public String getSeed() {
        return seed;
    }

    /**
     * @param seed The seed
     */
    public void setSeed(String seed) {
        this.seed = seed;
    }

    /**
     * @return The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version The version
     */
    public void setVersion(String version) {
        this.version = version;
    }


}
