package web.spittr.web.dto;

import java.util.Objects;

/**
 * If you want to use an POJO object as input param from a request
 * See SpitterController.processRegister(...) then this POJO should
 * implement getters and setters of required fields.
 *
 * If setters are absent then the POJO object will be passed in Controller
 * with 'null' fields.
 * Details - https://reversecoding.net/spring-mvc-requestparam-binding-request-parameters/
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.05.18)
 */
public class Spitter {
    private Long id;
    private String userName;
    private String password;

    private String firstName;
    private String lastName;

    public Spitter() {
        //required for serialization / deserialization
    }

    public Spitter(String userName, String password, String firstName, String lastName) {
        this(null, userName, password, firstName, lastName);
    }

    public Spitter(Long id, String userName, String password, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spitter spitter = (Spitter) o;
        return Objects.equals(id, spitter.id) &&
                Objects.equals(userName, spitter.userName) &&
                Objects.equals(password, spitter.password) &&
                Objects.equals(firstName, spitter.firstName) &&
                Objects.equals(lastName, spitter.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, firstName, lastName);
    }
}

