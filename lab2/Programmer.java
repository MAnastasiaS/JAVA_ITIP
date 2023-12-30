class Programmer extends Collaborator {
    private String language;

    public Programmer() {
    }

    public Programmer(String name, int age, String department, String company, String country, int price, String language) {
        super(name, age, department, company, country, price);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void doWork() {
        System.out.println("Writing code.");
    }

    @Override
    public void printInfo() {
        System.out.println("Programmer Information:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + getDepartment());
        System.out.println("Company: " + getBrand());
        System.out.println("Country: " + getModel());
        System.out.println("Price: " + getPrice());
        System.out.println("Language: " + getLanguage());
    }
}
