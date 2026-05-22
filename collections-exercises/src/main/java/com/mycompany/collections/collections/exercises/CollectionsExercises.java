/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.collections.collections.exercises;

/**
 *
 * @author goreanuvictor
 */
import java.util.*;

public class CollectionsExercises {

    public static void main(String[] args) {
        System.out.println("=== 1. Nume Studenți (ArrayList) ===");
        List<String> names = new ArrayList<>(Arrays.asList("Ana", "Bogdan", "Cristi", "Diana", "Elena"));
        System.out.println("Lista inițială: " + names);
        names.remove(2); // Elimină al 3-lea nume (index 2)
        System.out.println("După ștergerea celui de-al 3-lea nume: " + names);

        System.out.println("\n=== 2. Sumă și Medie (List<Integer>) ===");
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        int sum = 0;
        for (int num : numbers) sum += num;
        System.out.println("Suma: " + sum + " | Media: " + (sum / (double) numbers.size()));

        System.out.println("\n=== 3. Inversare Listă Manual ===");
        List<Integer> toReverse = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i = 0; i < toReverse.size() / 2; i++) {
            int temp = toReverse.get(i);
            toReverse.set(i, toReverse.get(toReverse.size() - 1 - i));
            toReverse.set(toReverse.size() - 1 - i, temp);
        }
        System.out.println("Listă inversată: " + toReverse);

        System.out.println("\n=== 4. Numărător Cuvinte Unice (Set) ===");
        String sentence = "java este un limbaj java este foarte tare";
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(sentence.split(" ")));
        System.out.println("Cuvinte unice (" + uniqueWords.size() + "): " + uniqueWords);

        System.out.println("\n=== 5. Frecvența Cuvintelor (Map) ===");
        String fruits = "apple banana apple orange banana apple";
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : fruits.split(" ")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Frecvență: " + wordCount);

        System.out.println("\n=== 6. Agendă Telefonică (Map) ===");
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Victor", "0722123456");
        phoneBook.put("Ana", "0733987654");
        System.out.println("Toată agenda: " + phoneBook);
        System.out.println("Caută Victor: " + phoneBook.get("Victor"));

        System.out.println("\n=== 7. Sistem Management Studenți ===");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Victor", 8));
        students.add(new Student("Ana", 10));
        students.add(new Student("Bogdan", 9));
        students.add(new Student("Victor", 8)); // Duplicat pentru ex. 9

        System.out.println("Studenți: " + students);
        Student topStudent = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > topStudent.getGrade()) topStudent = s;
        }
        System.out.println("Studentul cu nota cea mai mare: " + topStudent);

        System.out.println("\n=== 8. Sortare Studenți ===");
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Sortat alfabetic: " + students);
        students.sort(Comparator.comparing(Student::getGrade).reversed());
        System.out.println("Sortat după notă (descrescător): " + students);

        System.out.println("\n=== 9. Ștergere Duplicate (Studenți) ===");
        // LinkedHashSet păstrează ordinea inserării, dar elimină duplicatele pe baza metodei equals()
        Set<Student> uniqueStudents = new LinkedHashSet<>(students);
        List<Student> noDuplicatesList = new ArrayList<>(uniqueStudents);
        System.out.println("Fără duplicate: " + noDuplicatesList);

        System.out.println("\n=== 10. (Opțional) LRU Cache ===");
        int capacity = 2; // Cache care ține maxim 2 elemente
        LinkedHashMap<String, String> lruCache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > capacity;
            }
        };
        lruCache.put("A", "Valoare A");
        lruCache.put("B", "Valoare B");
        lruCache.get("A"); // Accesăm A, deci B devine cel mai vechi
        lruCache.put("C", "Valoare C"); // Se adaugă C, deci B va fi șters automat!
        System.out.println("Cache curent: " + lruCache);

        System.out.println("\n=== 11. (Opțional) Combinare două Map-uri ===");
        Map<String, Integer> map1 = new HashMap<>(Map.of("A", 10, "B", 20));
        Map<String, Integer> map2 = new HashMap<>(Map.of("B", 15, "C", 30));
        
        map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
        System.out.println("Map combinat (B trebuie să fie 35): " + map1);
    }
}
