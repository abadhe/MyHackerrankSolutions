// Given an array of words and an array of sentences, determine which
// words are anagrams of each other. Calculate how many sentences
// can be created by replacing any word with one of its anagrams.
// Example
// wordSet = (sten', Silent, R: 81
// sentence a Eisten it is silent*
// Determine that istents an anagram el silent. Those two words can
// be replaced with their anagrams. The four sentences that can be
// created are
// * Niter R is stent
// * exten R is laten
// stent it is silent
// silent & ls lote
// Function Description
// Complete the countSentences function in the editor below.
// counSentences has the following, parameters:
// string wordSedn): an array of strings
// string sentences/mil: an array of strings


public List<Integer> function solution(List<String>wordSet, List<String>sentences) {
    List<Integer> list = new ArrayList<>();
    HashMap<String,Integer> map = new HashMap<>();
    for(String word: wordSet){
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        String sortedKey = String.valueOf(arr);
        map.put(sortedKey, map.getOrDefault(sortedKey,0)+1);
    }
  
    for(String sentence: sentences){
        String[] sen = sentence.split(" ");
        int ans = 1;
        for(String s: sen){
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedKey = String.valueOf(arr);
            if(map.containsKey(sortedKey)){
                ans*= map.get(sortedKey);
            }
        }
        list.add(ans);
    }

    return list;
}

