# textanalyzer
This is simple Java console application which produces a set of statistics data about the file contents.

The tool calculate and print for each file:

- number of words in the file, restricted by:
	 - stopwords - if passed to the application, those words is not being counted. 
	 - capital letter - if flag *capitalLetter* is passed to the application only words starting with capital letter are being counted
- number of characters in the words, which are being counted
