package javabean;


public class User {

  private long id;
  private long telNumber;
  private String pwd;
  private int identify;
  private String address;


  public User(long telNumber, String pwd, int identify, String address) {
    this.telNumber = telNumber;
    this.pwd = pwd;
    this.identify = identify;
    this.address = address;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getTelNumber() {
    return telNumber;
  }

  public void setTelNumber(long telNumber) {
    this.telNumber = telNumber;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public int getIdentify() {
    return identify;
  }

  public void setIdentify(int identify) {
    this.identify = identify;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
