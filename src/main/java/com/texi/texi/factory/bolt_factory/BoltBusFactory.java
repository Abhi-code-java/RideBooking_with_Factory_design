package com.texi.texi.factory.bolt_factory;

import com.texi.texi.factory.bolt.BoltBusBooking;
import com.texi.texi.factory.bolt.BoltBusCancel;
import com.texi.texi.factory_layers.BookRide;
import com.texi.texi.factory_layers.CancelRide;
import com.texi.texi.factory_layers.RideFactory;

public class BoltBusFactory implements RideFactory {
    @Override
    public BookRide bookingRide(String name, String from, String to) {
        return new BoltBusBooking();
    }

    @Override
    public CancelRide cancelRide(String userName) {
        return new BoltBusCancel();
    }
}
