//Joseph Masterson


public class WordHelper {

	//Instance variables
	private String[] words;
	private int length;
	
	//DefaultConstructor
	public WordHelper()
	{	
		this.length = 0;
		this.words = new String[length];
	}
	
	//Parameterized constructor - the array cannot be directly created
	public WordHelper(int aLength)
	{
		this.setLength(aLength);
		this.words = new String[length];
	}

	//Accesor for the length of the array
	public int getLength() {
		return length;
	}

	//Mutator for the length of the array
	public void setLength(int aLength) {
		if(aLength > 0)
			this.length = aLength;
	}
	
	/*Method to count the number of vowels in a word
	 * Checks each character in the string against vowels, increments counter
	 */
	public static int countVowels(String aWord)
	{
		int count = 0;
		for(int i = 0; i < aWord.length(); i++)
		{
			if(aWord.charAt(i) == 'a' || aWord.charAt(i) == 'A'
					|| aWord.charAt(i) == 'e'|| aWord.charAt(i) == 'E'
					|| aWord.charAt(i) == 'i' || aWord.charAt(i) == 'I'
					|| aWord.charAt(i) == 'o' || aWord.charAt(i) == 'O'
					|| aWord.charAt(i) == 'u' || aWord.charAt(i) == 'U'
					|| aWord.charAt(i) == 'y' ||aWord.charAt(i) == 'Y')
			{
				count++;
			}
		}
		return count;
	}
	
	/* Sorts the matrix by the number of vowels in the word - uses the countVowels method
	 * clones matrix - uses bubble sort and then returns the sorted array
	 */
	public static String[] sortByVowels(String[] xWords)
	{
		String[] vowel = xWords.clone();
		
		int length = vowel.length;
		for(int i = 0; i < length - 1; i++)
		{
			for(int j = 1; j < length - i; j++)
			{
				if(WordHelper.countVowels(vowel[j - 1]) > WordHelper.countVowels(vowel[j]))
				{
					String temp = vowel[j - 1];
					vowel[j - 1] = vowel[j];
					vowel[j] = temp;
				}
			}
		}
		return vowel;
	}
	
	/*Method to count the number of consonants in a word
	 * Checks each character against the vowels, if the letter is not a vowel, the counter increments 
	 */
	public static int countConst(String aWord)
	{
		int count = 0;
		for(int i = 0; i < aWord.length(); i++)
		{
			if(aWord.charAt(i) != 'a' && aWord.charAt(i) != 'A'
					&& aWord.charAt(i) != 'e' && aWord.charAt(i) != 'E'
					&& aWord.charAt(i) != 'i' && aWord.charAt(i) != 'I'
					&& aWord.charAt(i) != 'o' && aWord.charAt(i) != 'O'
					&& aWord.charAt(i) != 'u' && aWord.charAt(i) != 'U'
					&& aWord.charAt(i) != 'y' && aWord.charAt(i) != 'Y')
			{
				count++;
			}
		}
		return count;
	}
	
	/*Sorts the matrix by the number of consonants in the word - uses the countConst method
	 * Clones the matrix - compares the number of consonants, uses bubble sort and then returns the sorted array
	 */
	public static String[] sortByConsonants(String[] xWords)
	{
		String[] consonant = xWords.clone();
		
		int length = consonant.length;
		for(int i = 0; i < length - 1; i++)
		{
			for(int  j = 1; j < length - i; j++)
			{
				if(WordHelper.countConst(consonant[j - 1]) > WordHelper.countConst(consonant[j]))
				{
					String temp = consonant[j - 1];
					consonant[j - 1] = consonant[j];
					consonant[j] = temp;
				}
			}
		}
		return consonant;
	}
	
	/*Sorts the words in the matrix by length
	 * clones the matrix - uses the .length method to comapre the length, bubble sort and then returns the sorted array
	 */
	public static String[] sortByLength(String[] xWords)
	{
		String[] clone = xWords.clone();
		
		int length = clone.length;
		for(int i = 0; i < length - 1; i++)
		{
			for(int j = 1; j < length - i; j++)
			{
				if(clone[j - 1].length() > clone[j].length())
				{
					String temp = clone[j - 1];
					clone[j - 1] = clone[j];
					clone[j] = temp;
				}
			}
		}
		
		return clone;
	}
	
	
}
