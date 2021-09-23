import org.junit.Test;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.*;

@XmlRootElement
@XmlType(name = "human")
public class Human {

    private int id;
    private int age;
    private String name;
    private Sex sex;
    private static Map<Integer, Human> allHumans = new HashMap<>();
    private static int countId = 0;


    public Human(String name, int age, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;

        if (!hasHuman()) {
            countId++;
            this.id = countId;
            allHumans.put(id, this);
        }
    }

    public static List<Human> getAllHumans(){
        return new ArrayList<>(allHumans.values());
    }

    public static List<Human> getAllHumans(Sex sex){
        List<Human> listAllHumans = new ArrayList<>();
        for (Human human : allHumans.values()){
            if (human.sex == sex) {
                listAllHumans.add(human);
            }
        }
        return listAllHumans;
    }

    public static int getHowManyHumans(){
        return allHumans.size();
    }

    public static int getHowManyHumans(Sex sex){
        return getAllHumans(sex).size();
    }

    public static int getAllAgeHumans(){
        int countAge = 0;
        for (Human human : allHumans.values()){
            countAge += human.age;
        }
        return countAge;
    }

    public static int getAllAgeHumans(Sex sex){
        int countAge = 0;
        for (Human human : getAllHumans(sex)){
            countAge += human.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllHumans(){
        return getAllAgeHumans() / getHowManyHumans();
    }

    public static int getAverageAgeOfAllHumans(Sex sex){
        return getAllAgeHumans(sex) / getHowManyHumans(sex);
    }



    private boolean hasHuman(){
        for (Human user : allHumans.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && sex == human.sex && name.equals(human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, sex);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 125) {
            System.out.println("Wrong age!");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
