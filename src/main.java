public static void main(String[] args) {
    HashMap<Integer, String> map = new HashMap<>();

    System.out.println("--- Тест PUT ---");
    map.put(1, "Один");
    map.put(2, "Два");
    map.put(3, "Три");
    map.put(1, "Первый");

    System.out.println("Размер: " + map.size());
    System.out.println("Ключ 1: " + map.get(1));

    System.out.println("\n--- Тест REMOVE ---");
    System.out.println("Удалено: " + map.remove(2));
    System.out.println("Ключ 2 после удаления: " + map.get(2));
    System.out.println("Размер: " + map.size());

    System.out.println("\n--- Тест RESIZE ---");
    for (int i = 10; i < 30; i++) {
        map.put(i, "Value" + i);
    }
    System.out.println("Размер после серии вставок: " + map.size());
    System.out.println("Ключ 25: " + map.get(25));

    System.out.println("\n--- Тест NULL-ключей ---");
    map.put(null, "NULL");
    System.out.println("NULL-ключ: " + map.get(null));
    System.out.println("Размер с NULL-ключом: " + map.size());
}
