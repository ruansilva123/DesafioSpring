package com.challenge.springChallenge.Validations;

public class WeatherValidation {

    public static boolean validateLongititude(int longitude){
        if(longitude > 180 || longitude < -180){
            return false;
        }
        return true;
    }

    public static boolean validateLatitude(int latitude){
        if(latitude > 90 || latitude < -90){
            return false;
        }
        return true;
    }
}
