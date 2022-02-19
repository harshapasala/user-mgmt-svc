package com.pasala.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
public class User {
    private String uid;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"").append("uid").append("\"").append(": ");
        sb.append("\"").append(this.uid).append("\"");
        sb.append(",");
        sb.append("\"").append("firstName").append("\"").append(": ");
        sb.append("\"").append(this.firstName).append("\"");
        sb.append(",");
        sb.append("\"").append("lastName").append("\"").append(": ");
        sb.append("\"").append(this.lastName).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
