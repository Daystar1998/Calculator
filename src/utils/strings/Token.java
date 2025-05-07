package utils.strings;

/*
 * Class for defining a lexical token
 */
public class Token {

	private LexicalCategory category;
	private String value;
	
	public Token(LexicalCategory category, String value) {
		
		this.category = category;
		this.value = value;
	}
	
	public LexicalCategory getCategory() {
	
		return category;
	}
	
	public String getValue() {
	
		return value;
	}
}
