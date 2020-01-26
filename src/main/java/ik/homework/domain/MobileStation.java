package ik.homework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MobileStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private float lastKnownX;
    private float lastKnownY;

    public MobileStation() {
    }

    public MobileStation(float lastKnownX, float lastKnownY) {
        this.lastKnownX = lastKnownX;
        this.lastKnownY = lastKnownY;
    }

    public float getLastKnownX() {
        return lastKnownX;
    }

    public void setLastKnownX(float lastKnownX) {
        this.lastKnownX = lastKnownX;
    }

    public float getLastKnownY() {
        return lastKnownY;
    }

    public void setLastKnownY(float lastKnownY) {
        this.lastKnownY = lastKnownY;
    }
}
