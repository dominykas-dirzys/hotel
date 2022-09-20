package com.domas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Room {
    private int roomNo;
    private List<Guest> guests = new ArrayList<>();
    private List<Guest> roomHistory = new ArrayList<>();

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public void occupyRoom(Guest guest) {
        if (!guests.isEmpty()) {
            System.out.println("Sorry, room No " + roomNo + " is occupied");
        } else {
            guests.add(guest);
            roomHistory.add(guest);
            System.out.println(guest.getFirstName() + " " + guest.getLastName() + " occupied room No " + roomNo);
        }
    }

    public boolean emptyRoom(Guest guest) {
        Iterator<Guest> i = guests.iterator();
        while(i.hasNext()) {
            Guest g = i.next();
            if (g.getFirstName().toLowerCase().equals(guest.getFirstName().toLowerCase()) && g.getLastName().toLowerCase().equals(guest.getLastName().toLowerCase())) {
                guests.remove(g);
                System.out.println(g.getFirstName() + " " + g.getLastName() + " left room No " + roomNo);
                return true;
            }
        }
        return false;
    }

    public void showRoomHistory() {
        System.out.println("Room was occupied by:");
        if (!roomHistory.isEmpty()) {
            for (int i = 0; i < roomHistory.size(); i++) {
                System.out.println((i+1) + " " + roomHistory.get(i).toString());
            }
        } else {
            System.out.println("Room hasn't had any guests yet");
        }
    }

    public void showRoomStatus() {
        if (guests.isEmpty()) {
            System.out.println("Room is unoccupied");
        } else {
            System.out.println("Room is occupied by - " + guests.toString());
        }
    }

    public int getRoomNo() {
        return roomNo;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}
