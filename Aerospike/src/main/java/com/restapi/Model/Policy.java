package com.restapi.Model;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

import javax.persistence.Id;

/**
 * The type Policy.
 */
@AerospikeRecord(namespace = "test",set = "Policy")
public class Policy {
    /**
     * The Id.
     */
    @AerospikeKey
    @Id
    long id;

    /**
     * The Ptype.
     */
    String ptype ="";

    /**
     * The V 0.
     */
    String v0="";

    /**
     * The V 1.
     */
    String v1="";

    /**
     * The V 2.
     */
    String v2="";

    /**
     * The V 3.
     */
    String v3="";

    /**
     * The V 4.
     */
    String v4="";

    /**
     * The V 5.
     */
    String v5="";

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets ptype.
     *
     * @return the ptype
     */
    public String getPtype() {
        return ptype;
    }

    /**
     * Sets ptype.
     *
     * @param ptype the ptype
     */
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    /**
     * Gets v 0.
     *
     * @return the v 0
     */
    public String getV0() {
        return v0;
    }

    /**
     * Sets v 0.
     *
     * @param v0 the v 0
     */
    public void setV0(String v0) {
        this.v0 = v0;
    }

    /**
     * Gets v 1.
     *
     * @return the v 1
     */
    public String getV1() {
        return v1;
    }

    /**
     * Sets v 1.
     *
     * @param v1 the v 1
     */
    public void setV1(String v1) {
        this.v1 = v1;
    }

    /**
     * Gets v 2.
     *
     * @return the v 2
     */
    public String getV2() {
        return v2;
    }

    /**
     * Sets v 2.
     *
     * @param v2 the v 2
     */
    public void setV2(String v2) {
        this.v2 = v2;
    }

    /**
     * Gets v 3.
     *
     * @return the v 3
     */
    public String getV3() {
        return v3;
    }

    /**
     * Sets v 3.
     *
     * @param v3 the v 3
     */
    public void setV3(String v3) {
        this.v3 = v3;
    }

    /**
     * Gets v 4.
     *
     * @return the v 4
     */
    public String getV4() {
        return v4;
    }

    /**
     * Sets v 4.
     *
     * @param v4 the v 4
     */
    public void setV4(String v4) {
        this.v4 = v4;
    }

    /**
     * Gets v 5.
     *
     * @return the v 5
     */
    public String getV5() {
        return v5;
    }

    /**
     * Sets v 5.
     *
     * @param v5 the v 5
     */
    public void setV5(String v5) {
        this.v5 = v5;
    }
}
