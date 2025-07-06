package com.example.chatbot.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CHAT")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST NAME")
    private String FirstName;
    @Column(name = "LAST NAME")
    private String LastName;
    @Column(name = "PATRONYMIC")
    private String Patronymic;
    @Column(name = "PARTH DATE")
    private String birthDate;
    @Column(name = "MESSAGE")
    private String message;

    public MessageEntity() {
    }

    public MessageEntity(Long id, String firstName, String lastName, String patronymic, String birthDate, String message) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Patronymic = patronymic;
        this.birthDate = birthDate;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(FirstName, that.FirstName) && Objects.equals(LastName, that.LastName) && Objects.equals(Patronymic, that.Patronymic) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, Patronymic, birthDate);
    }
}
