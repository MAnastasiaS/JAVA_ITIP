public class Main {
    public static void main(String[] args) {
        Administrator admin = new Administrator("John", 30, "Administration", "Microsoft", "Japan", 1000, "Admin Role");
        admin.doWork();
        admin.printInfo();

        Programmer programmer = new Programmer("Alice", 25, "Development", "Byte My App", "Russia", 2000, "Java");
        programmer.doWork();
        programmer.printInfo();

        Manager manager = new Manager("Bob", 35, "Management", "IT Pandas", "England", 3000, "Project Management");
        manager.doWork();
        manager.printInfo();

        System.out.println("Number of objects created: " + Collaborator.getCountObject());
    }
}
