package javabean;


public class Activity {

  private long id;
  private long foodid;
  private java.sql.Timestamp time;
  private double changedPrice;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getFoodid() {
    return foodid;
  }

  public void setFoodid(long foodid) {
    this.foodid = foodid;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public double getChangedPrice() {
    return changedPrice;
  }

  public void setChangedPrice(double changedPrice) {
    this.changedPrice = changedPrice;
  }

}
