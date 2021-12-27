package javabean;


public class User {

  private long id;
  private long telNumber;
  private String pwd;
  private String identify;
  private String address;


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


  public String getIdentify() {
    return identify;
  }

  public void setIdentify(String identify) {
    this.identify = identify;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
