package com.texi.texi.factory;

import com.texi.texi.enums.CompanyType;
import com.texi.texi.enums.TranspostType;
import com.texi.texi.factory.bolt_factory.BoltBikeFacory;
import com.texi.texi.factory.bolt_factory.BoltBusFactory;
import com.texi.texi.factory.bolt_factory.BoltCarFactory;
import com.texi.texi.factory.uber_factory.UberBikeFactory;
import com.texi.texi.factory.uber_factory.UberBusFactory;
import com.texi.texi.factory.uber_factory.UberCarFactory;
import com.texi.texi.factory_layers.RideFactory;

import java.util.HashMap;
import java.util.Map;

public class MasterFactoryCreator {
    public static  final Map<String, RideFactory>factory=new HashMap<>();
    static {
        factory.put("UBER_CAR",new UberCarFactory());
        factory.put("UBER_BUS",new UberBusFactory());
        factory.put("UBER_BIKE",new UberBikeFactory());
        factory.put("BOLT_CAR",new BoltCarFactory());
        factory.put("BOLT_BUS",new BoltBusFactory());
        factory.put("BOLT_BIKE",new BoltBikeFacory());
    }
    public static RideFactory getFactory(CompanyType companyType, TranspostType transpostType){
        String key=companyType.name()+"_"+transpostType.name();
        RideFactory rideFactory=factory.get(key);
        if(rideFactory==null){
            throw new IllegalArgumentException("NO BOOKING COMPANY FOUND "+key);
        }
        return rideFactory;
    }
}
