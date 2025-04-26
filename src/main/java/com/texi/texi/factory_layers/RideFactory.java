package com.texi.texi.factory_layers;

public interface RideFactory {
    BookRide bookingRide(String name,String from, String to);
    CancelRide cancelRide(String userName);
}
