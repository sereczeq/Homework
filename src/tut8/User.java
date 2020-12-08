package tut8;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String email;
    private String mobile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                email.equals(user.email) &&
                mobile.equals(user.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, mobile);
    }
}
