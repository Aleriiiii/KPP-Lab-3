package ua.khnu.kpp;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        System.out.println("=== Демонстрація ЛР № 3 (Масиви) ===");
        
        ArrayManager manager = new ArrayManager(3, 3);
        manager.fillRandom();
        
        System.out.println("Масив заповнений випадковими числами:");
        manager.print();
        
        manager.sortAll();
        System.out.println("\nМасив після сортування:");
        manager.print();
        
        System.out.println("\nПеревірка методу toString():\n" + manager);
    }
}