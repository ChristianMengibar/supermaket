package com.laguna.supermaket.mapper;

public interface IMapper <I, O>{
    //Mappear todo lo que entremos de in a o, podemos usarla o no
    public O map(I in);
}
