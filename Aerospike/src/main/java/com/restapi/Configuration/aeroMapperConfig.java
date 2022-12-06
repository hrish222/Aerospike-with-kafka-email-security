package com.restapi.Configuration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.mapper.tools.AeroMapper;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

/**
 * The type Aero mapper config.
 */
@Singleton
public class aeroMapperConfig {
    /**
     * The Config.
     */
    @Inject
    aerospikeConfiguration config;

    /**
     * The Mapper.
     */
    AeroMapper mapper = null;

   // private static Logger logger = LogManager.getLogger(AeroMapperUtil.class.getName());

    /**
     * Sets aerospike client.
     */
    @PostConstruct
    public void setupAerospikeClient() {

        ClientPolicy policy = new ClientPolicy();
        AerospikeClient client = new AerospikeClient(policy,config.getHost(), config.getPort());
        mapper = new AeroMapper.Builder(client).build();
    }

    /**
     * Gets mapper.
     *
     * @return the mapper
     */
    public AeroMapper getMapper() {
        //logger.info("In class " + getClass().getName() + ".getMapper()");
        return this.mapper;
    }
}

