# Text Analyzer
This is simple Java console application which produces a set of statistics data about the file contents.

The tool calculates and prints for each file:

- number of words in the file, restricted by:
	 - stopwords - if passed to the application, those words are not counted. 
	 - capital letter - if flag *capitalLetter* is passed to the application, only words starting with a capital letter are counted
- number of characters in the words, which are counted
