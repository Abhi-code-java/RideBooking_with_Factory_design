package com.texi.texi.factory.uber_factory;

import com.texi.texi.factory.uber.UberCarBooking;
import com.texi.texi.factory.uber.UberCarCancel;
import com.texi.texi.factory_layers.BookRide;
import com.texi.texi.factory_layers.CancelRide;
import com.texi.texi.factory_layers.RideFactory;

public class UberCarFactory implements RideFactory {
    @Override
    public BookRide bookingRide(String name, String from, String to) {
        return new UberCarBooking();
    }

    @Override
    public CancelRide cancelRide(String userName) {
        return new UberCarCancel();
    }
}
