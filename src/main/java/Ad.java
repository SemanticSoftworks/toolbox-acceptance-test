import com.google.gson.annotations.Expose;

import java.util.Calendar;

/**
 * Created by softish on 2017-02-20.
 */
public class Ad {

    private long adId;
    private String category;
    private String description;
    @Expose(serialize = true)
    private Calendar duration;
    private long user;
    private String title;

    public Ad() {
    }

    public Ad(long adId, String category, String description, Calendar duration, long user, String title) {
        this.adId = adId;
        this.category = category;
        this.description = description;
        this.duration = duration;
        this.user = user;
        this.title = title;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDuration() {
        return duration;
    }

    public void setDuration(Calendar duration) {
        this.duration = duration;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
