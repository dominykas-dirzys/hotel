package com.domas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable {
    private List<Room> rooms = new ArrayList<>();

    public void createRooms(int numberOfRooms) {
        if (numberOfRooms > 0) {
            for (int i = 1; i <= numberOfRooms; i++) {
                rooms.add(new Room(i));
            }
            System.out.println("Created hotel that has " + numberOfRooms + " rooms");
        } else {
            System.out.println("Hotel must have rooms!");
        }
    }

    public boolean checkIn(Guest guest) {
        for (Room room : rooms) {
            if (room.getGuests().isEmpty()) {
                room.occupyRoom(guest);
                return true;
            }
        }
        System.out.println("Sorry, all rooms are occupied");
        return false;
    }

    public boolean checkOut(Guest guest) {
        for (Room room : rooms) {
            if (room.emptyRoom(guest)) {
                return true;
            }
        }
        System.out.println("No such guest found");
        return false;
    }

    public void showRoomOverview() {
        for (Room room : rooms) {
            if (room.getGuests().isEmpty()) {
                System.out.println("Room No " + room.getRoomNo() + " is unoccupied");
            } else {
                System.out.println("Room No " + room.getRoomNo() + " is occupied by " + room.getGuests().toString());
            }
        }
    }

    public void showRoomHistory(int roomNo) {
        rooms.get(roomNo - 1).showRoomHistory();
    }

    public void showRoomStatus(int roomNo) {
        rooms.get(roomNo - 1).showRoomStatus();
    }
}
