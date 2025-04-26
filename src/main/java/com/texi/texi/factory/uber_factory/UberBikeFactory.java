package com.texi.texi.factory.uber_factory;

import com.texi.texi.factory.uber.UberBikeBooking;
import com.texi.texi.factory.uber.UberBikeCancel;
import com.texi.texi.factory_layers.BookRide;
import com.texi.texi.factory_layers.CancelRide;
import com.texi.texi.factory_layers.RideFactory;

public class UberBikeFactory implements RideFactory {
    @Override
    public BookRide bookingRide(String name, String from, String to) {
        return new UberBikeBooking();
    }

    @Override
    public CancelRide cancelRide(String userName) {
        return new UberBikeCancel();
    }
}
