package service;

import dao.IDao;
import model.Hotel;

public class HotelService {

    private IDao<Hotel> HotelIDao;

    public HotelService(IDao<Hotel> hotelIDao) {

        HotelIDao = hotelIDao;
    }

    public Hotel salvar(Hotel hotel){
        HotelIDao.salvar(hotel);
        return hotel;

    }
}
