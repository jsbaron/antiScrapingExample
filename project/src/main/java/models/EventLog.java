package models;

import java.sql.Timestamp;
import java.util.Objects;

public class EventLog {

  private String ip;
  private String event;
  private String target;
  private Timestamp date;

  public EventLog(String ip, String event, String target, Timestamp date) {
    this.ip = ip;
    this.event = event;
    this.target = target;
    this.date = date;
  }

  public EventLog() {
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EventLog)) {
      return false;
    }
    EventLog that = (EventLog) o;
    return getIp().equals(that.getIp()) &&
        getEvent().equals(that.getEvent()) &&
        getTarget().equals(that.getTarget()) &&
        getDate().equals(that.getDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIp(), getEvent(), getTarget(), getDate());
  }

  @Override
  public String toString() {
    return "EventLog{" +
        "ip='" + ip + '\'' +
        ", event='" + event + '\'' +
        ", target='" + target + '\'' +
        ", date=" + date +
        '}';
  }

  public String getIp() {
    return ip;
  }

  public String getEvent() {
    return event;
  }

  public String getTarget() {
    return target;
  }

  public Timestamp getDate() {
    return date;
  }
}
