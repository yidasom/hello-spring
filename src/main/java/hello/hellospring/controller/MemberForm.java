package hello.hellospring.controller;

public class MemberForm {
    /** 이메일 */
    private String email;
    /** 이름 */
    private String name;
    /** 비밀번호 */
    private String passwrd;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }
}
