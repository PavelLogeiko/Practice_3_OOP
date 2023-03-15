// Практическая работа № 2 - ООП
// Задача 1. Реализовать, с учетом ООП-подхода, приложение для проведения исследований с генеалогическим древом.
// Дополнительно использовать абстрактные классы (People) и интерфейсы (Education).

package GeoTree;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nЗадача 1. Реализовать с использованием ООП - подхода работу с генеалогическим древом.\nДополнительно использовать абстрактные классы и интерфейсы");
        // формируем список людей для древа
        Person lena = new Person("Лена", 55, "woman");
        Person ivan = new Person("Иван", 60, "man");
        Person masha = new Person("Маша", 39, "woman");
        Person sasha = new Person("Саша", 41, "man");
        Person lena1 = new Person("Лена", 8, "woman");
        Person gena = new Person("Гена", 12, "man");
        GeoTree gt = new GeoTree();

        // формируем родственные связи между людьми
        gt.append(lena, Relationship.parent, masha, Relationship.children);
        gt.append(ivan, Relationship.parent, sasha, Relationship.children);

        gt.append(masha, Relationship.wife, sasha, Relationship.husband);

        gt.append(masha, Relationship.parent, lena1, Relationship.children);
        gt.append(masha, Relationship.parent, gena, Relationship.children);
        gt.append(sasha, Relationship.parent, lena1, Relationship.children);
        gt.append(sasha, Relationship.parent, gena, Relationship.children);

        gt.append(lena, Relationship.grandParent, lena1, Relationship.grandChildren);
        gt.append(lena, Relationship.grandParent, lena1, Relationship.grandChildren);
        gt.append(ivan, Relationship.grandParent, lena1, Relationship.grandChildren);
        gt.append(ivan, Relationship.grandParent, gena, Relationship.grandChildren);

        // выводим на консоль людей и их родственные связи
        System.out.println("\nВ базе данных есть следующие люди, с родственными связями:");
        print(gt, lena, Relationship.parent); // кому Лена является родителем
        print(gt, ivan, Relationship.parent); // кому Иван является родителем
        System.out.println("");
        print(gt, sasha, Relationship.husband); // кому Саша является мужем
        print(gt, masha, Relationship.wife); // кому Маша является женой
        System.out.println("");
        print(gt, lena1, Relationship.children); // кому Лена1 является дочерью
        print(gt, gena, Relationship.children); // кому Гена является сыном
        System.out.println("");
        print(gt, lena, Relationship.grandParent); // кому Лена является бабушкой
        print(gt, ivan, Relationship.grandParent); // кому Иван является дедушкой
        System.out.println("");
        print(gt, lena1, Relationship.grandChildren); // кому Лена1 является внучкой
        print(gt, gena, Relationship.grandChildren); // кому Гена является внуком
        System.out.println("\nВ базе данных есть следующие мужчины и женщины:");
        print(gt, Gender.woman); // все женщины
        print(gt, Gender.man); // все мужчины
        System.out.println("\nВ базе данных есть следующие люди, моложе 40 лет:");
        print(gt, SearchAge.ageYoung, 40); // все люди моложе 40 лет
        System.out.println("\nВ базе данных есть следующие люди, старше 40 лет:");
        print(gt, SearchAge.ageOld, 40); // все люди от 40 лет

        // реализуем добавление члена семьи в древо (ввод с консоли)
        System.out.printf("\nУ %s и %s родился еще один ребенок (это мальчик), введите пож-та его в базу данных" +
                " (укажите любое имя и возраст для примера).", masha, sasha);

        Scanner in = new Scanner(System.in); // добавляем нового ребенка через консоль
        System.out.println("\nВведите имя нового ребенка: ");
        String newChildrenName = in.nextLine();
        System.out.println("Введите возраст нового ребенка (цифру): ");
        int newChildrenAge = in.nextInt();
        in.close();
        Person newChildren = new Person(newChildrenName, newChildrenAge, "man");

        // формируем родственные связи нового ребенка
        gt.append(masha, Relationship.parent, newChildren, Relationship.children); // связь нового ребенка с родителями
        gt.append(sasha, Relationship.parent, newChildren, Relationship.children); // связь нового ребенка с родителями
        gt.append(lena, Relationship.grandParent, newChildren, Relationship.grandChildren); // связь нового ребенка с бабушкой
        gt.append(ivan, Relationship.grandParent, newChildren, Relationship.grandChildren);// связь нового ребенка с дедушкой
        System.out.println("\nОбновленная база данных по мужчинам и женщинам: ");
        print(gt, Gender.woman); // все женщины
        print(gt, Gender.man); // все мужчины

        // выводим на консоль людей и их родственные связи, с учетом нового члена семьи
        System.out.println("\nОбновленная база данных по детям и их связям с родителями, бабушкой и дедушкой: ");
        print(gt, lena1, Relationship.children); // кому Лена1 является дочерью
        print(gt, gena, Relationship.children); // кому Гена является сыном
        print(gt, newChildren, Relationship.children); // кто родители нового ребенка
        System.out.println("");
        print(gt, lena1, Relationship.grandChildren); // кому Лена1 является внучкой
        print(gt, gena, Relationship.grandChildren); // кому Гена является внуком
        print(gt, newChildren, Relationship.grandChildren); // кто бабушка и дедушка нового ребенка

// Comparator сравнение по Имени
        System.out.println("\nИспользуя интерфейс Comparator, выясним одинаковые ли имена у бабушки и внучки.");
        PersonNameComp personNameComp = new PersonNameComp();
        System.out.println("Интерпретация результата: Ноль - имена совпадают; Отрицательное число - имена не совпадают:");
        System.out.println("Результат: "+ personNameComp.compare(lena, lena1));
        System.out.printf("Проверка, данные из базы: имя бабушки - %s, имя внучки - %s\n", lena.getFullName(), lena1.getFullName());

// Comparator сравнение по возрасту
        System.out.println("\nИспользуя интерфейс Comparator, выяснить одинаковый ли возраст у жены и мужа.");
        System.out.println("Интерпретация результата: Ноль - возраст совпадает; Отрицательное число - возраст не совпадает:");
        PersonAgeComp personAgeComp = new PersonAgeComp();
        System.out.println(("Результат: " + personAgeComp.compare(masha, sasha)));
        System.out.printf("Проверка, данные из базы: возраст жены %s - %d, возраст мужа %s - %d\n",
                masha.getFullName(), masha.getAge(), sasha.getFullName(), sasha.getAge());

        System.out.println("\n_______конец_______");
    }
// вызов метода исследования - выборка людей по возрасту
    static void print(GeoTree tree, SearchAge se, int age){
        String st = "";
        if (se == SearchAge.ageYoung) st = "моложе";
        else if (se == SearchAge.ageOld) st = "старше";
        System.out.printf("Люди %s %d: ", st, age);
        System.out.println(new Research(tree).spend(se, age));
    }

    static void print(GeoTree tree, Person people, Relationship rs) {
        System.out.printf("%s - %s по отношению к: ", people, rs.toString());
        System.out.println(new Research(tree).spend(people, rs));
    }

    static void print(GeoTree tree, Gender gender) {
        System.out.printf("%s: ", gender);
        System.out.println(new Research(tree).spend(gender));
    }
}
