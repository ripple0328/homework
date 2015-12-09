package com.company;

import java.util.ArrayList;

/**
 * Created by Qingbo on 12/7/15.
 */
public class ParkingManager {

    ArrayList<Parkinglot> parkinglots = new ArrayList<>();
    Parkinglot parkinglot;
    ParkingToken token;
    Car car;

    public void add(Parkinglot parkinglot) {
        parkinglots.add(parkinglot);
    }

    public ParkingToken park(Car car) {
        for (int i = 0; i < parkinglots.size(); i++) {
            parkinglot = parkinglots.get(i);
            token = parkinglot.park(car);
            if(token != null) {
                return token;
            }
        }
        return null;
    }

    public Car fetch(ParkingToken token) {
        for (int i = 0; i < parkinglots.size(); i++) {
            parkinglot = parkinglots.get(i);
            car = parkinglot.fetch(token);
            if(car != null) {
                return car;
            }
        }
        return null;
    }
}
