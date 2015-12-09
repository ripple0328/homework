package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkinglotTest {
    Car car;
    Parkinglot parkinglot;
    Parkinglot parkinglot1;
    ParkingToken token;
    ParkingManager parkingManager;

    @Before
    public void setUp() throws Exception {
        Car car = new Car();
        parkinglot = new Parkinglot(1);
        parkinglot1 = new Parkinglot(2);
        parkingManager = new ParkingManager();
        parkingManager.add(parkinglot1);
        parkingManager.add(parkinglot);
    }

    @Test
    public void testParkOneCar() throws Exception {
        token = parkinglot.park(car);
        assertNotNull(token);
    }

    @Test
    public void testFetchOneCar() throws Exception {
        token = parkinglot.park(car);
        Car fetchedCar = parkinglot.fetch(token);
        assertEquals(car, fetchedCar);
    }

    @Test
    public void testCantParkInAFullParkinglot() throws Exception {
        Car car1 = new Car();
        token = parkinglot.park(car);
        ParkingToken token1 = parkinglot.park(car1);
        assertNull(token1);
    }

    @Test
    public void testParkingManagerCanParkCar() throws Exception {
        token = parkingManager.park(car);
        assertNotNull(token);
    }

    @Test
    public void testParkingManagerCanFetchCarViaToken() throws Exception {
        token = parkingManager.park(car);
        Car fetchedCar = parkingManager.fetch(token);
        assertEquals(car, fetchedCar);
    }
}