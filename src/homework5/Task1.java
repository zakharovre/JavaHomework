package homework5;

public class Task1 {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Виктор", "уборщик", "vik@mail", "555-55-55",
                22000, 60);
        empArray[1] = new Employee("Михаил", "грузчик", "mih@mail", "555-55-56",
                24000, 30);
        empArray[2] = new Employee("Константин", "менеджер", "kon@mail", "555-55-57",
                35000, 45);
        empArray[3] = new Employee("Антон", "консультант", "ant@mail", "555-55-52",
                30000, 22);
        empArray[4] = new Employee("Геннадий", "логист", "gen@mail", "555-55-51",
                32000, 50);
        for (Employee employee : empArray) {
            if(employee.getAge()>40)
                employee.info();
        }
    }
}

