package com.texi.texi.factory.bolt_factory;

import com.texi.texi.factory.bolt.BoltCarBooking;
import com.texi.texi.factory.bolt.BoltCarCancel;
import com.texi.texi.factory_layers.BookRide;
import com.texi.texi.factory_layers.CancelRide;
import com.texi.texi.factory_layers.RideFactory;

public class BoltCarFactory implements RideFactory {
    @Override
    public BookRide bookingRide(String name, String from, String to) {
        return new BoltCarBooking();
    }

    @Override
    public CancelRide cancelRide(String userName) {
        return new BoltCarCancel();
    }
}
