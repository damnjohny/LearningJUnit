import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HumanTest {

    @Test
    public void getAllHumans() {
        Human human = new Human("Alex", 23, Sex.MALE);
        Human human1 = new Human("Slava", 23, Sex.MALE);
        Human human2 = new Human("Tanya", 22, Sex.FEMALE);

        List<Human> expected = Human.getAllHumans();

        List<Human> actual = new ArrayList<>();
        actual.add(human);
        actual.add(human1);
//        actual.add(human2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllHumans() {
    }

    @Test
    public void getHowManyHumans() {
    }

    @Test
    public void testGetHowManyHumans() {
    }

    @Test
    public void getAllAgeHumans() {
    }

    @Test
    public void testGetAllAgeHumans() {
    }

    @Test
    public void getAverageAgeOfAllHumans() {
    }

    @Test
    public void testGetAverageAgeOfAllHumans() {
    }
}