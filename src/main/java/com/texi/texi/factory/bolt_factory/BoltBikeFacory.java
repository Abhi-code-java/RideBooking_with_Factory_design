package com.texi.texi.factory.bolt_factory;

import com.texi.texi.factory.bolt.BoltBikeBooking;
import com.texi.texi.factory.bolt.BoltBikeCancel;
import com.texi.texi.factory_layers.BookRide;
import com.texi.texi.factory_layers.CancelRide;
import com.texi.texi.factory_layers.RideFactory;

public class BoltBikeFacory implements RideFactory {
    @Override
    public BookRide bookingRide(String name, String from, String to) {
        return new BoltBikeBooking();
    }

    @Override
    public CancelRide cancelRide(String userName) {
        return new BoltBikeCancel();
    }
}
