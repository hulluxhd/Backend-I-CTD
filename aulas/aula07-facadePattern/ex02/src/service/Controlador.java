package service;

import model.Viagem;

public class Controlador {
    private ApiHotel apiHotel;
    private ApiVoo apiVoo;

    public Controlador() {
        apiHotel = new ApiHotel();
        apiVoo = new ApiVoo();
    }

    public void buscar(Viagem cidade){
        System.out.println("As linhas aéreas disponíveis são \n" + apiVoo.buscar(cidade) + "\nE os hotéis disponíveis são \n" + apiHotel.buscar(cidade));
    }
}
