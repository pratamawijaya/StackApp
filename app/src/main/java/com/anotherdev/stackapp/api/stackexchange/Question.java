package com.anotherdev.stackapp.api.stackexchange;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Question extends RealmObject implements Parcelable {

  @SerializedName("owner") private Owner owner;
  @SerializedName("score") private int score;
  @SerializedName("last_activity_date") private long lastActivityDate;
  @SerializedName("creation_date") private long creationDate;
  @SerializedName("body") private String body;

  @SerializedName("question_id") @PrimaryKey private String questionId;
  @SerializedName("is_answered") private boolean isAnswered;
  @SerializedName("view_count") private int viewCount;
  @SerializedName("answer_count") private int answerCount;
  @SerializedName("title") private String title;

  public Question() {
  }



  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner o) {
    owner = o;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int s) {
    score = s;
  }

  public long getLastActivityDate() {
    return lastActivityDate;
  }

  public void setLastActivityDate(long date) {
    lastActivityDate = date;
  }

  public long getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(long date) {
    creationDate = date;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  public boolean isAnswered() {
    return isAnswered;
  }

  public void setIsAnswered(boolean answered) {
    isAnswered = answered;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int count) {
    viewCount = count;
  }

  public int getAnswerCount() {
    return answerCount;
  }

  public void setAnswerCount(int count) {
    answerCount = count;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String text) {
    title = text;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.owner, flags);
    dest.writeInt(this.score);
    dest.writeLong(this.lastActivityDate);
    dest.writeLong(this.creationDate);
    dest.writeString(this.body);
    dest.writeString(this.questionId);
    dest.writeByte(isAnswered ? (byte) 1 : (byte) 0);
    dest.writeInt(this.viewCount);
    dest.writeInt(this.answerCount);
    dest.writeString(this.title);
  }

  protected Question(Parcel in) {
    this.owner = in.readParcelable(Owner.class.getClassLoader());
    this.score = in.readInt();
    this.lastActivityDate = in.readLong();
    this.creationDate = in.readLong();
    this.body = in.readString();
    this.questionId = in.readString();
    this.isAnswered = in.readByte() != 0;
    this.viewCount = in.readInt();
    this.answerCount = in.readInt();
    this.title = in.readString();
  }

  public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
    @Override public Question createFromParcel(Parcel source) {
      return new Question(source);
    }

    @Override public Question[] newArray(int size) {
      return new Question[size];
    }
  };
}
