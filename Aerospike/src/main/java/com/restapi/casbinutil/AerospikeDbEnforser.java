//package com.restapi.casbinutil;
//
//
//import com.restapi.Application;
//import org.apache.commons.io.IOUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.casbin.jcasbin.main.Enforcer;
//import org.casbin.jcasbin.model.Model;
//
//
//import java.nio.charset.Charset;
//
//public class AerospikeDbEnforser {
//        private static volatile Enforcer ENFORCER;
//        private AerospikeDbEnforser() {
//        }
//        private static Logger LOGGER = LogManager.getLogger(com.restapi.casbinutil.AerospikeDbEnforser.class.getName());
//        public static Enforcer getCasbinEnForcer() {
//            if (ENFORCER == null) {
//                synchronized (AerospikeDbEnforser.class) {
//                    if (ENFORCER == null) {
//                        try {
//                            Model model = new Model();
//                            model.loadModelFromText(IOUtils.toString(ClassLoader.getSystemResource("casbin/model.conf"), Charset.defaultCharset()));
//                            CasbinAeroAdapter aeroAdapter = Application.getApplicationContext().getBean(CasbinAeroAdapter.class);
//                            ENFORCER = new Enforcer(model, aeroAdapter);
//                        } catch (Exception e) {
//                            if (LOGGER.isErrorEnabled())
//                                LOGGER.error("Enforcer creation failed : " + e.getMessage());
//                        }
//                    }
//                }
//            }
//            return ENFORCER;
//        }
//    }
//
