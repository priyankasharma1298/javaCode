import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Three {

    public static boolean isPrime(int number){
        if(number <= 1){
            return false;
        }else{
            for(int i =2 ; i<Math.sqrt(number) ; i++){
                if(number % i ==0){
                    return false;
                }
            }
        }


        return true;
    }



    public static int countDigits(int number){
        int count =0;

        String value = Integer.toString(number);
        for (char c  : value.toCharArray()) {
            count ++;    
        }
        return count;

    }

    public static int reverseNumber(int number){
        String reverse ="";
        int rem =0;

        String value = Integer.toString(number);
        while(number!=0){
            rem = number%10;
            reverse+=rem;
            number = number/10;
        }

        return Integer.parseInt(reverse);

    }

    public static boolean checkPallindrome(String str ){
        String reverseString ="";
        for(int i=str.length()-1 ; i>=0 ; i--){
            reverseString += str.charAt(i);
        }
        if(str.equals(reverseString)){
            return true;
        }else{
            return false;
        }
  
    }

    public static String reverseEachWord(String str ){
        String result = "";

        String[] words = str.split(" ");

        for(String word : words){
            char[] chars = word.toCharArray();
            String reversedWord = "";

            for (int i = chars.length - 1; i >= 0; i--) {
                reversedWord += chars[i];
            }
            result+=reversedWord + " ";
        }
        return result;
    
  
    }

    public static Character nonRepeatChar(String str ){

        //swiss
        LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<>();
        for (char  c : str.toCharArray()) {
            lmap.put(c , lmap.getOrDefault(c, 0) +1);
            
        }
        for (Character key : lmap.keySet()) {
            int count = lmap.get(key);
            if (count == 1) {
                return key;
                
            }
        }
        return null;
  
    }


    public static boolean checkArmstrong(int number){

        int result =0;
        int remainder =0;
        int originalNum = number;
        int digits = Integer.toString(number).length();

        while(originalNum!=0){
            remainder = originalNum%10;
            result += Math.pow(remainder, digits);
            originalNum = originalNum/10;
        }
        if(result == number){
            return true;
        }else{
            return false;
        }
        
    }

    public static boolean checkAnagram(String s1 ,  String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        String s1Case = s1.toLowerCase();
        String s2Case = s2.toLowerCase();

        char[] arr1 = s1Case.toCharArray(); 
        char[] arr2 = s2Case.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1 , arr2);  
        
    }

    public static void countConsonantAndVowel(String str ){

        int consonantCount = 0;
        int vowelCount =0;
        
        for (char c : str.toCharArray()) {
            if(c=='a' || c=='e' || c=='i' ||  c=='o' || c=='u' ){
                vowelCount+=1;
            }
            else{
                consonantCount+=1;
            }
            
        }
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
  
    }

    // "aaabb" → "a3b2"
    public static String compressString(String str ){

        
        return "";

        
  
    }

    public static List<Integer> duplicates(List<Integer> list ){

        HashSet<Integer> set = new HashSet<>();
        List<Integer> duplicate = new ArrayList<>();
        
        for (int i : list) {
            if(!set.add(i)){
                duplicate.add(i);

            }        
        }
        return duplicate;
    }


    public static int firstReapeatingElement(List<Integer> list ){

        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (Integer ele : list) {
            map.put(ele, map.getOrDefault(ele,0) +1);
            
        }

        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count >= 2) {
                return key;             
            }
        }
        return -1;
    }


    // Valid parentheses checker
    // Input: "[{()}]" → Output: true

    public static boolean validParenthesis(String input){

        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c=='(' || c=='{'  || c=='['){
                stack.push(c);
            }
            
            else{
                if(stack.isEmpty()){
                    return false;
                }

                char topOfStack = stack.pop();
                if( topOfStack =='(' && c!=')'   ||   topOfStack=='{' && c!='}' ||  topOfStack=='[' && c!=']' ){
                    return false;
                }

            }     
        }
        return stack.isEmpty();   
    }

    // Find longest substring without repeating characters
    //

    public static String substring(String input){

        return "";

        

                 
    }



    public static int stringToInteger(String input){

        // trim spaces
        input = input.trim();

        if(input.isEmpty()){
            return 0;
        }

        //  if the current character at index i is a sign symbol (+ or -)
        int result =0;
        int i=0;
        int sign =1; // positive sign
        if(input.charAt(i) == '-'  || input.charAt(i) == '+'){
            if (input.charAt(i) == '-') {
                sign = -1;
            } else {
                sign = 1;
            }
            i++;
        }

        // conversion : loop till i less than length of str and it is digit
        while (i<input.length()  && Character.isDigit(input.charAt(i))) {
            int digit = input.charAt(i) - '0';
            result = result * 10 + digit;
            i++;
            
        }    
        return result * sign;            
    }


    public static boolean partition( List<Integer> list){

        // 1 5 11 5 => 22 total sum which is div by 2 so it can be partitioned
        // 1 5 12 5 => 23 = not div by 2 so can not be  partitioned into 2 subarrays with equal sum

        int sum=0;
        for (Integer ele : list) {
            sum+=ele;
            
        }
        if(sum%2!=0){
            return false;
        }
        else{
            Set<Integer> possibleSumsSet = new HashSet<>();
            possibleSumsSet.add(0);

            int target = sum / 2;  // 11


            for (Integer element : list) {   // first iteration element =1   ,         2nd iteration ele = 5
                Set<Integer> set = new HashSet<>();   // set ={}     ,                 2nd iteration     set  =  {1}
                for(Integer ps : possibleSumsSet){   // iterate through possibleSumsSet ={0}   , 2nd iteration   possibleSumsSet = {0,1}
                    int newsum = ps + element;  // add 0+1  => newsum   ,              2nd iteration two times loop -> newsum = {0+5}=5 and newsum = {1+5}=6
                    if(newsum == target){    // check if it is equal to totalSum/2
                        return true;
                    }
                    set.add(newsum);     // add the newsum to set => set = {1} ,        2nd iteration    set = {5 , 6}
                }

                possibleSumsSet.addAll(set);   // possibleSumsSet => {0 , 1}   ,        2nd iteration  possibleSumsSet => {0 , 1 , 5, 6} 
                
            }
            
        }

        return false;
             
    }

    // recursion
    public static int factorial(int n) {
        if(n==0 || n==1){    // 0! =1
            return 1;
        }
        else{
            return n*factorial(n-1);
        }    
    }

    // 0 ,1 , 1, 2 3 5 8
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;  
        } else if (n == 1) {
            return 1;  
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);  // Recursive case
        }
    }

    public static int sumOfDigits(int n) {
        // 123 = 6
        if(n==0){
            return 0;
        }
        else{
            return (n % 10) + sumOfDigits(n / 10);     // 3 + sumOfDigits(12)
        }

    }

    //Print all subsets (power set) of a string

    public static void subsetsOfString(String input , String output) {
        if(input.length() ==0){
            System.out.println(output); 
            return;
        }
        String op1 = output;
        String op2 = output + input.charAt(0);
       
        input=input.substring(1);

        subsetsOfString(input, op1);
        subsetsOfString(input, op2);
    

    }






    public static void main(String[] args) {

        System.out.println(isPrime(29));
        System.out.println(countDigits(12345));
        System.out.println(checkArmstrong(153));
        System.out.println(reverseNumber(123));
        System.out.println(checkPallindrome("madam"));
        System.out.println(reverseEachWord("Hello World"));
        System.out.println(nonRepeatChar("swiss"));
        System.out.println(checkAnagram("silent", "lisoen"));
        List<Integer> list = Arrays.asList(1,1,2,2,3,4,5);
        System.out.println(duplicates(list));
        System.out.println(firstReapeatingElement(list));
        System.out.println(validParenthesis("([{}])]"));
        countConsonantAndVowel("abc");
        System.out.println(stringToInteger("-4193 words"));
        List<Integer> mylist = Arrays.asList(1,5,11,5);
        System.out.println(partition(mylist));
        System.out.println(factorial(5));
        System.out.println(fibonacci(6));
        System.out.println(sumOfDigits(123));
       subsetsOfString("ab" , "");







        
    }
    
}
