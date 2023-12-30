class Manager extends Collaborator {
    private String responsibility;

    public Manager() {
    }

    public Manager(String name, int age, String department, String company, String country, int price, String responsibility) {
        super(name, age, department, company, country, price);
        this.responsibility = responsibility;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public void doWork() {
        System.out.println("Managing a team.");
    }

    @Override
    public void printInfo() {
        System.out.println("Manager Information:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + getDepartment());
        System.out.println("Company: " + getBrand());
        System.out.println("Country: " + getModel());
        System.out.println("Price: " + getPrice());
        System.out.println("Responsibility: " + getResponsibility());
    }
}
