package org.example;

import com.google.gson.Gson;

import java.util.*;

public class StoreCar
{
    private List<Car> cars;

    public StoreCar()
    {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car c)
    {
        this.cars.add(c);
    }

    public  void buildList() {
        cars.add(new Car("bmw",3594.9, "123", 2));
        cars.add(new Car("audi",38346.9, "3634", 1));
        cars.add(new Car("ferrari" ,130000.4,"135", 10));
    }

    public Car  moreExpensive()
    {
        Car c2 = null;
        String moreExP="";
        double max=0;
        int i=0;

        for (Car c: cars
             ) {
            if(i==0)
            {
                max = c.getCost();
                moreExP = c.getTarga();
            }
            if(c.getCost()>max)
            {
                max = c.getCost();
                moreExP = c.getTarga();
            }
            i++;
        }

        for (Car c: cars
             ) {
            if(c.getTarga().equals(moreExP))
            {
                c2 = new Car(c.getName(),c.getCost(),c.getTarga(),c.getNumber());
                return c2;
            }
        }

        return c2;
    }

    public List carSort()
    {
        List<Car> sortedList = new ArrayList<>(cars);
        Collections.sort(sortedList, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getName().compareTo(car2.getName());
            }
        });

        return sortedList;
    }

    public String getListAsJSON()
    {
        Gson gson = new Gson();
        String jsonS = gson.toJson(cars);
        return jsonS;
    }

    public String getListAsJSON(List <Car> cars)
    {
        Gson gson = new Gson();
        String jsonS = gson.toJson(cars);
        return jsonS;
    }

    public String getListAsJSON(Car c)
    {
        Gson gson = new Gson();
        String jsonS = gson.toJson(c);
        return jsonS;
    }
}
