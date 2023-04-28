import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        MyHashTable<Student, String> hashTable = new MyHashTable<>();
        randomGenerator generator = new randomGenerator();
        for (int i = 0; i < 10000; i ++){
            if (i == 7777){
                hashTable.put(new Student("Svetlan", 2201, 4), "Will be deleted");
            }
            hashTable.put(new Student(generator.generateString(), generator.generateInt(), generator.generateFloat()),
                    generator.generateString());
        }
        testHashTable(hashTable);
    }

    private static void testHashTable(MyHashTable<Student, String> hashTable) throws Exception {
        System.out.println("Test uniform distribution: " + Arrays.toString(hashTable.sizeOfBuckets()) + '\n');

        Student sultan = new Student("Sultan", 2201, 4);
        hashTable.put(sultan, "Will get 100/100");
        System.out.println("Student Sultan successfully putted into HashTable\n");

        System.out.println("Getting value by key Student sultan - " + hashTable.get(sultan) + '\n');

        Student svetlan = new Student("Svetlan", 2201, 4);
        System.out.println("Removing value by key Student Svetlan - " +
                hashTable.remove(svetlan) + '\n');

        System.out.println( "Is svetlan in hashTable? - " + hashTable.contains("Will be deleted"));
        System.out.println( "Is sultan in hashTable? - " + hashTable.contains("Will get 100/100") + '\n');

        System.out.println( "Get key by value - " + hashTable.getKey("Will get 100/100") + '\n');

    }

    private static class randomGenerator{
        final String lexicon = "asdfghjklzxcvbnmqwertyuiopASDFGHJKLZXCVBNMQWERTYUIO";
        final Random random = new Random();

        public String generateString() {
            StringBuilder builder = new StringBuilder();
            int length = random.nextInt(5) + 7;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(random.nextInt(lexicon.length())));
            }
            return builder.toString();
        }

        public int generateInt(){
            return random.nextInt(1000,9999);
        }

        public float generateFloat(){
            return random.nextFloat() * 4;
        }
    }
}
