package com.oldgoat5.bmstacticalreference.reference;

/*********************************************************************
 * Object that represents a word and its definition.
 *
 * @author Michael Evans
 * @since 5/12/2015
 *********************************************************************/
public class WordDefinitionObject
{
    private String word;
    private String definition;

    public WordDefinitionObject(String word, String defintion)
    {
        this.word = word;
        this.definition = defintion;
    }

    public String getWord()
    {
        return this.word;
    }

    public String getDefinition()
    {
        return this.definition;
    }
}
