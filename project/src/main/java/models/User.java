package models;

import java.util.Date;
import java.util.Objects;

public class User {
  private Integer unitid;
  private String description;
  private String name;
  private String text;
  private String tweetCoord;
  private Date tweetCreated;
  private String tweetLocation;
  private String userTimezone;

  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
        "unitid=" + unitid +
        ", description='" + description + '\'' +
        ", name='" + name + '\'' +
        ", text='" + text + '\'' +
        ", tweetCoord='" + tweetCoord + '\'' +
        ", tweetCreated=" + tweetCreated +
        ", tweetLocation='" + tweetLocation + '\'' +
        ", userTimezone='" + userTimezone + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(getUnitid(), user.getUnitid()) &&
        Objects.equals(getDescription(), user.getDescription()) &&
        Objects.equals(getName(), user.getName()) &&
        Objects.equals(getText(), user.getText()) &&
        Objects.equals(getTweetCoord(), user.getTweetCoord()) &&
        Objects.equals(getTweetCreated(), user.getTweetCreated()) &&
        Objects.equals(getTweetLocation(), user.getTweetLocation()) &&
        Objects.equals(getUserTimezone(), user.getUserTimezone());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUnitid(), getDescription(), getName(), getText(), getTweetCoord(), getTweetCreated(), getTweetLocation(), getUserTimezone());
  }

  public Integer getUnitid() {
    return unitid;
  }

  public void setUnitid(Integer unitid) {
    this.unitid = unitid;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getTweetCoord() {
    return tweetCoord;
  }

  public void setTweetCoord(String tweetCoord) {
    this.tweetCoord = tweetCoord;
  }

  public Date getTweetCreated() {
    return tweetCreated;
  }

  public void setTweetCreated(Date tweetCreated) {
    this.tweetCreated = tweetCreated;
  }

  public String getTweetLocation() {
    return tweetLocation;
  }

  public void setTweetLocation(String tweetLocation) {
    this.tweetLocation = tweetLocation;
  }

  public String getUserTimezone() {
    return userTimezone;
  }

  public void setUserTimezone(String userTimezone) {
    this.userTimezone = userTimezone;
  }

  public User(Integer unitid, String description, String name, String text, String tweetCoord, Date tweetCreated, String tweetLocation, String userTimezone) {
    this.unitid = unitid;
    this.description = description;
    this.name = name;
    this.text = text;
    this.tweetCoord = tweetCoord;
    this.tweetCreated = tweetCreated;
    this.tweetLocation = tweetLocation;
    this.userTimezone = userTimezone;
  }
}
