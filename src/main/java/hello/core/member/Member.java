package hello.core.member;

public class Member {

    //회원 엔티티
    private long id;
    private String name;
    private Grade grade;


    //constructor
    public Member(long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
