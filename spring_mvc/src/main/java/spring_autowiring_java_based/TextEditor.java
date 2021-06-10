package spring_autowiring_java_based;

public class TextEditor 
{
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) 
	{
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}

	public void spellCheck() 
	{
		spellChecker.checkSpelling();
	}
	
}