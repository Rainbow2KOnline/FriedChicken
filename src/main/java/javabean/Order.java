package javabean;


public class Order {

  private long id;
  private long riderid;
  private long userid;
  private long subOrderid;
  private long status;
  private String address;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRiderid() {
    return riderid;
  }

  public void setRiderid(long riderid) {
    this.riderid = riderid;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public long getSubOrderid() {
    return subOrderid;
  }

  public void setSubOrderid(long subOrderid) {
    this.subOrderid = subOrderid;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
