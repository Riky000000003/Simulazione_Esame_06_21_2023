package org.example;

import com.google.gson.Gson;

import java.util.List;

public class ListCarsAnswer
{
    private List<Car> cars;
    private Car c;

    public ListCarsAnswer(List<Car> cars) {
        this.cars = cars;
    }

    public ListCarsAnswer(Car c)
    {
        this.c = c;
    }

    String asJSON()
    {
        Gson g = new Gson();
        String toJson = g.toJson(this);
        return toJson;
    }
}
