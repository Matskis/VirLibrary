package universitblaisepascal.virlibrary;

/**
 * Created by Cyril on 01/03/2016.
 */
public class Point {
    int ID;
    String Address;
    String City;
    String PostalCode;
    float Latitude;
    float Longitude;

    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getPostalCode() {
        return PostalCode;
    }
    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }
    public float getLatitude() {
        return Latitude;
    }
    public void setLatitude(float latitude) {
        Latitude = latitude;
    }
    public float getLongitude() {
        return Longitude;
    }
    public void setLongitude(float longitude) {
        Longitude = longitude;
    }
}
