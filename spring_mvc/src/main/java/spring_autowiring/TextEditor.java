package spring_autowiring;

public class TextEditor
{
	private SpellChecker spellChecker;
	private String name;

	public SpellChecker getSpellChecker() 
	{
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) 
	{
		this.spellChecker = spellChecker;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void spellCheck() 
	{
		spellChecker.checkSpelling();
	}

	public TextEditor(SpellChecker spellChecker, String name) {
		super();
		this.spellChecker = spellChecker;
		this.name = name;
	}

	public TextEditor() {
		super();
	}

	@Override
	public String toString() {
		return "TextEditor [spellChecker=" + spellChecker + ", name=" + name + "]";
	}
	
}