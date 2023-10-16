package com.example.sendmessageviewbinding.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que guarda un mensaje que manda una persona emisor a otra persona
 *
 * @author: David Zambrana Romero
 * @version: 1.0
 */

public class Message  implements Serializable, Parcelable {
    public static final String KEY = "Mensaje";
    private String content;
    private Person sender;
    private Person receiver;
    private int id;

    public Message(int id, String content, Person sender, Person receiver) {

        this.id = id; //En la realidad el id se asigna con la infraestrucutura
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    protected Message(Parcel in) {
        content = in.readString();
        sender = in.readParcelable(Person.class.getClassLoader());
        receiver = in.readParcelable(Person.class.getClassLoader());
        id = in.readInt();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public String toString() {
        return "content='" + content + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", id=" + id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //region Método SET y GET de la clase Message

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //endregion
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeParcelable(sender, flags);
        dest.writeParcelable(receiver, flags);
        dest.writeInt(id);
    }



}
