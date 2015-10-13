package com.example.alberto.tallerbinding.avanzado.RecyclerView.Model;


import org.apache.commons.lang3.builder.ToStringBuilder;

/**
* Created by Alberto on 09/10/2015.
*/
public class Result {

    private User user;

    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}


