package web.spittr.web.dto;

import java.util.Date;
import java.util.Objects;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (15.05.18)
 */
public class Spittle {
    private final Long id;
    private final String message;
    private final Date createdAt;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date createdAt) {
        this(message, createdAt, null, null);
    }

    public Spittle(String message, Date createdAt, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.createdAt = createdAt;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spittle spittle = (Spittle) o;
        return Objects.equals(id, spittle.id) &&
                Objects.equals(message, spittle.message) &&
                Objects.equals(createdAt, spittle.createdAt) &&
                Objects.equals(latitude, spittle.latitude) &&
                Objects.equals(longitude, spittle.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, createdAt, latitude, longitude);
    }
}
