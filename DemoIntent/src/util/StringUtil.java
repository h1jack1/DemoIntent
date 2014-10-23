package util;

/**
 * Some useful String utility methods.
 *
 * Notes:
 *     StringBuffer - Strings in Java are immutable; meaning a String's contents can't change after
 *                    it's been created. For example: String threeStrings = "String 1" + "String 2";
 *                    Class StringBuffer allows the String contents to be altered, replaced, added,
 *                    deleted, etc. Use StringBuffer's toString( ) method to get back the newly
 *                    modified String :)
 *
 *     The use of class StringBuffer is not the only way to implement the required behaviour.
 *     Java's class String has regex-style methods that could eliminate/reduce much of the code
 *     down to 1 or 2 statements.
 *     I purposefully chose class StringBuffer to help you with building your lab :)
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class StringUtil {

	// NOP
	private StringUtil() { }

	/**
	 * Replace all occurrences of letter in plainMessage with toUpperCase(letter)
	 * @param plainMessage
	 * @param letter
	 * @return plainMessage with all occurrences of letter in upper-case.
	 */
    public static String capitalize( String plainMessage, char letter ) {

    	StringBuffer message = new StringBuffer( plainMessage );

        for( int i = 0; i < plainMessage.length(); i++ ) {
            char c = plainMessage.charAt( i );
            if ( Character.isLetter( c ) ) {
            	if ( Character.toUpperCase(c) == Character.toUpperCase(letter) ) {
            		message.setCharAt( i, Character.toUpperCase(c) );
            	} else {
            		message.setCharAt( i, c );
            	}
            } else {
            	// append all non-letters
                message.setCharAt( i, c );
            }
        }

        return message.toString();
    }

	/**
	 * Replace all occurrences of letter in capitalizedMessage with toLowerCase(letter)
	 * @param capitalizedMessage
	 * @param letter
	 * @return capitalizedMessage with all occurrences of letter in lower-case.
	 */
    public static String uncapitalize( String capitalizedMessage, char letter ) {

        StringBuffer message = new StringBuffer( capitalizedMessage );

        for( int i = 0; i < message.length(); i++ ) {
            char c = message.charAt( i );
            if ( Character.isLetter(c) ) {
                if ( Character.toLowerCase(c) == Character.toLowerCase(letter) ) {
                	message.setCharAt( i, Character.toLowerCase(c) );
                } else {
                	message.setCharAt( i, c );
                }
            } else {
            	message.setCharAt( i, c );
            }
        }
        
        return message.toString();
    }
}
