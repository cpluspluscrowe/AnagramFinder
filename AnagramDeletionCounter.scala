/*
 Hackerrank Solution: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
object AnagramCounter extends App {
  /*
A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Determine this number.

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
   */
    def makeAnagram(a: String, b: String): Int = {
      val aInOrder = a.toCharArray().sorted
      val bInOrder = b.toCharArray().sorted
      var aIndex = 0
      var bIndex = 0
      var countOfExtraChars = 0
      while(aIndex < aInOrder.size && bIndex < bInOrder.size){
        val currentA = aInOrder(aIndex)
        val currentB = bInOrder(bIndex)
        if(currentA == currentB){
          aIndex = aIndex + 1
          bIndex = bIndex + 1
        }
        else if(currentA > currentB){
          bIndex = bIndex + 1
          countOfExtraChars = countOfExtraChars+ 1
        }else{
          aIndex = aIndex + 1
          countOfExtraChars = countOfExtraChars + 1
        }
      }
      return countOfExtraChars + (aInOrder.size - aIndex) + (bInOrder.size - bIndex)
    }
  println(makeAnagram("cde","abc"))
}
