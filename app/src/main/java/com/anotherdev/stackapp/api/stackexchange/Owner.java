package com.anotherdev.stackapp.api.stackexchange;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Owner extends RealmObject implements Parcelable {

  @SerializedName("user_id") @PrimaryKey private String userId = "";
  @SerializedName("reputation") private int reputation;
  @SerializedName("profile_image") private String profileImage;
  @SerializedName("display_name") private String displayName;
  @SerializedName("link") private String profileUrl;



  public Owner() {
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String id) {
    userId = id;
  }

  public int getReputation() {
    return reputation;
  }

  public void setReputation(int rep) {
    reputation = rep;
  }

  public String getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(String imageUrl) {
    profileImage = imageUrl;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String name) {
    displayName = name;
  }

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String url) {
    profileUrl = url;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.userId);
    dest.writeInt(this.reputation);
    dest.writeString(this.profileImage);
    dest.writeString(this.displayName);
    dest.writeString(this.profileUrl);
  }

  protected Owner(Parcel in) {
    this.userId = in.readString();
    this.reputation = in.readInt();
    this.profileImage = in.readString();
    this.displayName = in.readString();
    this.profileUrl = in.readString();
  }

  public static final Parcelable.Creator<Owner> CREATOR = new Parcelable.Creator<Owner>() {
    @Override public Owner createFromParcel(Parcel source) {
      return new Owner(source);
    }

    @Override public Owner[] newArray(int size) {
      return new Owner[size];
    }
  };
}
