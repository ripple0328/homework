package com.company;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {
    private Map<ParkingToken, Car> ParkingSlots;
    private int capacity;

    public Parkinglot(int i) {
        ParkingSlots = new HashMap<ParkingToken, Car>();
        capacity = i;
    }

    public ParkingToken park(Car car) {
        if(ParkingSlots.size() < capacity) {
            ParkingToken token = new ParkingToken();
            ParkingSlots.put(token, car);
            return token;
        } else {
            return null;
        }
    }



    public Car fetch(ParkingToken token) {
        return ParkingSlots.get(token);
    }
}
