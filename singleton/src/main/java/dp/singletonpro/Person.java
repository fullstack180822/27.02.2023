package dp.singletonpro;

public class Person {

    int id ;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj instanceof Person == false)
            return false;
        Person p = (Person)obj;
        return (this.id == p.id && this.name.equals(p.name));
    }
}
