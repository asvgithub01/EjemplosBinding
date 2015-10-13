package com.example.alberto.tallerbinding.avanzado.RecyclerView.Model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Alberto on 09/10/2015.
 */
public class Picture {

        private String large;
        private String medium;
        private String thumbnail;

        /**
         * @return The large
         */
        public String getLarge() {
            return large;
        }

        /**
         * @param large The large
         */
        public void setLarge(String large) {
            this.large = large;
        }

        /**
         * @return The medium
         */
        public String getMedium() {
            return medium;
        }

        /**
         * @param medium The medium
         */
        public void setMedium(String medium) {
            this.medium = medium;
        }

        /**
         * @return The thumbnail
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * @param thumbnail The thumbnail
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

    }
