package org.example.entity;

import java.util.*; // List, Set, Arrays, Collections gibi sınıfları kullanmak için import edildi
import java.util.stream.Collectors; // Stream API kullanımı için (isteğe bağlı alternatif)

/**
 * Metin içerisindeki benzersiz kelimeleri bulup sıralamak için kullanılan yardımcı sınıf.
 */
public class StringSet {

    /**
     * Verilen sabit bir metin içerisindeki noktalama işaretlerini temizler,
     * benzersiz kelimeleri bulur ve bunları alfabetik olarak sıralanmış bir
     * List<String> olarak döndürür.
     *
     * @return Alfabetik olarak sıralanmış benzersiz kelimelerin listesi.
     */
    public static List<String> findUniqueWords() {
        // 1. İlgili texti bir String değişkenine ata
        String text = "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. " +
                "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, " +
                "and in November he began working on the manuscript in earnest. To add the finishing touches he researched " +
                "natural history in connection with the animals presented in the book and then had the book examined " +
                "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations " +
                "to the original copy, on publication he was advised to find a professional illustrator so the pictures " +
                "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret " +
                "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the" +
                " children.\n\n" +
                "Carroll began planning a print edition of the Alice story in 1863. " +
                "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice." +
                " A diary entry for 2 July says that he received a specimen page of the print edition around that date. " +
                "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations " +
                "by Carroll, dedicating it as a Christmas Gift to a Dear Child in Memory of a Summer's Day." +
                " The published version of Alice's Adventures in Wonderland is about twice the length of " +
                "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, " +
                "that did not appear in the manuscript. The only known manuscript copy of Under Ground " +
                "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

        // 2. String içerisindeki .,!,?" karakterlerini temizle ve metni küçük harfe çevir
        //    (Büyük/küçük harf duyarlılığını ortadan kaldırmak için küçük harfe çevirmek önemlidir)
        //    Metinde bulunan '—' (em dash) karakterini de boşlukla değiştirerek kelimelerin ayrılmasını sağlayalım.
        String cleanedText = text.toLowerCase() // Küçük harfe çevir
                .replace("—", " ") // Em dash'i boşlukla değiştir
                .replaceAll("[.,!?\"]", ""); // İstenen noktalama işaretlerini kaldır

        // 3. Metni kelimelere ayır (boşluk karakterlerine göre)
        //    "\\s+" regex'i bir veya daha fazla boşluk karakterini (boşluk, tab, yeni satır vb.) ifade eder.
        String[] words = cleanedText.split("\\s+");

        // 4. Benzersiz kelimeleri bulmak için Set kullan
        //    Set, elemanların benzersiz olmasını garanti eder.
        //    Boş string'leri eklememek için kontrol yapalım.
        Set<String> uniqueWordSet = new HashSet<>();
        for (String word : words) {
            // Kelimenin başındaki/sonundaki boşlukları temizle ve boş olup olmadığını kontrol et
            String trimmedWord = word.trim();
            if (!trimmedWord.isEmpty()) {
                uniqueWordSet.add(trimmedWord);
            }
        }
        /* // Alternatif olarak Stream API ile:
           Set<String> uniqueWordSet = Arrays.stream(words)
                                            .map(String::trim) // baş/son boşlukları temizle
                                            .filter(word -> !word.isEmpty()) // boş olanları filtrele
                                            .collect(Collectors.toSet()); // Set'e topla
        */


        // 5. Set'i List'e dönüştür ve alfabetik olarak sırala
        List<String> sortedUniqueWords = new ArrayList<>(uniqueWordSet);
        Collections.sort(sortedUniqueWords); // Alfabetik sıralama

        // 6. Sıralanmış listeyi döndür
        return sortedUniqueWords;
    }

    // --- Test etmek için main metodu ---
    public static void main(String[] args) {
        List<String> uniqueWords = findUniqueWords();

        System.out.println("Metindeki Toplam Benzersiz Kelime Sayısı: " + uniqueWords.size());
        System.out.println("\nBenzersiz Kelimeler (Alfabetik Sırayla):");

        // Kelimeleri listele
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        /* // Veya daha kısa bir şekilde yazdırmak için:
           uniqueWords.forEach(System.out::println);
        */
    }
}