package com.restapi.Model;

import com.aerospike.mapper.annotations.AerospikeRecord;

/**
 * The type Categories.
 */
@AerospikeRecord (namespace= "test",set="Categories")
public class Categories {
    private int categoriesId;
    private String nature;

    /**
     * Instantiates a new Categories.
     */
    public Categories() {
    }

    /**
     * Instantiates a new Categories.
     *
     * @param categoriesId the categories id
     */
    public Categories(int categoriesId) {
        this.categoriesId = categoriesId;
        this.nature = nature;
    }

    /**
     * Gets categories id.
     *
     * @return the categories id
     */
    public int getCategoriesId() {
        return categoriesId;
    }

    /**
     * Sets categories id.
     *
     * @param categoriesId the categories id
     */
    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    /**
     * Gets nature.
     *
     * @return the nature
     */
    public String getNature() {
        return nature;
    }

    /**
     * Sets nature.
     *
     * @param nature the nature
     */
    public void setNature(String nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoriesId=" + categoriesId +
                ", nature='" + nature + '\'' +
                '}';
    }
}
