package cc.softwarefactory.lokki.android.models;

import android.content.Context;

import cc.softwarefactory.lokki.android.utilities.PreferenceUtils;
import cc.softwarefactory.lokki.android.utilities.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"userId", "email"})
public class MainUser extends Person {

    private boolean visibility;   // define visibility scope
    private String battery;      // battery status house keeping info


    @JsonIgnore
    public void setUserId(String userId, Context context) {
        PreferenceUtils.setString(context, PreferenceUtils.KEY_USER_ID, userId);
        super.setUserId(userId);
    }

    @JsonIgnore
    public void setEmail(String email, Context context) {
        PreferenceUtils.setString(context, PreferenceUtils.KEY_USER_ACCOUNT, email);
        super.setEmail(email);
        setPhoto(Utils.getDefaultAvatarInitials(context, getEmail()));
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return getEmail();
    }
}
