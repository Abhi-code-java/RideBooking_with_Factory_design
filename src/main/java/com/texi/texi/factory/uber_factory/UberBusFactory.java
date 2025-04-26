package com.texi.texi.factory.uber_factory;

import com.texi.texi.factory.uber.UberBusBooking;
import com.texi.texi.factory.uber.UberBusCancel;
import com.texi.texi.factory_layers.BookRide;
import com.texi.texi.factory_layers.CancelRide;
import com.texi.texi.factory_layers.RideFactory;

public class UberBusFactory implements RideFactory {
    @Override
    public BookRide bookingRide(String name, String from, String to) {
        return new UberBusBooking();
    }

    @Override
    public CancelRide cancelRide(String userName) {
        return new UberBusCancel();
    }
}
