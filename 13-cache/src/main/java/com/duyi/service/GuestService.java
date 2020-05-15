package com.duyi.service;

import com.duyi.bean.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> listGuests();

    Guest getGuest(int id);

    Guest update(Guest guest);

    int delete(int id);

}
