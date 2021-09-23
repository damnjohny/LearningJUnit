import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class HumanTest {
    private Human human;
    private Human human1;
    private Human human2;

    @Before
    public void setUp() {
        human = new Human("Евгений", 35, Sex.MALE);
        human1 = new Human("Марина", 34, Sex.FEMALE);
        human2 = new Human("Алина", 7, Sex.FEMALE);
    }

    @Test
    public void getAllHumans() {
        List<Human> expected = Human.getAllHumans();

        List<Human> actual = new ArrayList<>();
        actual.add(human);
        actual.add(human1);
        actual.add(human2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllHumans_NO_NULL() {
        List<Human> expected = Human.getAllHumans();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllHumans_MALE() {
        List<Human> expected = Human.getAllHumans(Sex.MALE);

        List<Human> actual = new ArrayList<>();
        actual.add(human);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllHumans_MALE_NO_NULL() {
        //добавим проверку на null
        List<Human> expected = Human.getAllHumans(Sex.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllHumans_FEMALE() {
        List<Human> expected = Human.getAllHumans(Sex.FEMALE);

        List<Human> actual = new ArrayList<>();
        actual.add(human1);
        actual.add(human2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllHumans_FEMALE_NO_NULL() {
        //добавим проверку на null
        List<Human> expected = Human.getAllHumans(Sex.FEMALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyHumans() {
        int expected = Human.getHowManyHumans();

        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyHumans_MALE() {
        int expected = Human.getHowManyHumans(Sex.MALE);

        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyHumans_FEMALE() {
        int expected = Human.getHowManyHumans(Sex.FEMALE);

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeHumans() {
        int expected = Human.getAllAgeHumans();

        int actual = 35 + 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeHumans_MALE() {
        int expected = Human.getAllAgeHumans(Sex.MALE);

        int actual = 35;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeHumans_FEMALE() {
        int expected = Human.getAllAgeHumans(Sex.FEMALE);

        int actual = 34 + 7;

        Assert.assertEquals(expected, actual);
    }
}

/**
Cписок аннотаций для JUnit:

@Test – определяет что метод method() является тестовым.
@Before – указывает на то, что метод будет выполнятся перед каждым тестируемым методом @Test.
@After – указывает на то что метод будет выполнятся после каждого тестируемого метода @Test
@BeforeClass – указывает на то, что метод будет выполнятся в начале всех тестов,
        а точней в момент запуска тестов(перед всеми тестами @Test).
@AfterClass – указывает на то, что метод будет выполнятся после всех тестов.
@Ignore – говорит, что метод будет проигнорирован в момент проведения тестирования.
        (expected = Exception.class) – указывает на то, что в данном тестовом методе
        вы преднамеренно ожидаете Exception.
        (timeout = 100) – указывает, что тестируемый метод не должен занимать больше чем 100 миллисекунд.


Основные методы класса Assert для проверки:

fail(String) – указывает на то что бы тестовый метод завалился при этом выводя текстовое сообщение.
assertTrue([message], boolean condition) – проверяет, что логическое условие истинно.
assertsEquals([String message], expected, actual) – проверяет, что два значения совпадают.
Примечание: для массивов проверяются ссылки, а не содержание массивов.
assertNull([message], object) – проверяет, что объект является пустым null.
assertNotNull([message], object) – проверяет, что объект не является пустым null.
assertSame([String], expected, actual) – проверяет, что обе переменные относятся к одному объекту.
assertNotSame([String], expected, actual) – проверяет, что обе переменные относятся к разным объектам.


Adding JUnit 4.12 to Maven

<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.12</version>
<scope>test</scope>
</dependency>
 */