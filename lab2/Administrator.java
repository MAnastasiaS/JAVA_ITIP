class Administrator extends Collaborator  {
    private String role;

    public Administrator() {
    }

    public Administrator(String name, int age, String department, String company, String country, int price, String role) {
        super(name, age, department, company, country, price);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void doWork() {
        System.out.println("Doing administrative work.");
    }

    @Override
    public void printInfo() {
        System.out.println("Administrator Information:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + getDepartment());
        System.out.println("Company: " + getBrand());
        System.out.println("Country: " + getModel());
        System.out.println("Price: " + getPrice());
        System.out.println("Role: " + getRole());
    }
}
