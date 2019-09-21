package com.meow.aboutme;

import androidx.annotation.NonNull;

import java.util.Objects;

/**
 * Just a POJO class to store the name and nickname
 */
public final class MyName {
    @NonNull
    private String name, nickname;

    public MyName(@NonNull String name, @NonNull String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public MyName(@NonNull String name) {
        this.name = name;
        this.nickname = "";
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getNickname() {
        return nickname;
    }

    public void setNickname(@NonNull String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyName myName = (MyName) o;
        return getName().equals(myName.getName()) &&
                getNickname().equals(myName.getNickname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNickname());
    }
}
