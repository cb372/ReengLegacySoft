# Sample code for Chapter 2

## Example Apache access log

`example-apache-access.log` is a fake web server access log. You can use the one-liner from the book to calculate the 99% percentile response time in microseconds:

```
$ awk '{print $NF}' example-apache-access.log | \
  sort -n | \
  awk '{sorted[c]=$1; c++;} END{print sorted[int(NR*0.99-0.5)]}'
989846
```

## Example of FindBugs annotations usage

`2.2_FindBugsFalsePositive` shows how to use a FindBugs annotation to suppress false positives.

To build: `mvn clean compile findbugs:findbugs`

## Example of FindBugs exclusion rules file

`2.4_WorkDay` shows how to use a FindBugs exclusion file to suppress false positives.

To build: `mvn clean compile findbugs:findbugs`

## Number Guessing Game

`NumberGuessingGame` is an example of a Maven project with FindBugs, PMD and Checkstyle plugins configured.

To build: `mvn clean compile findbugs:findbugs pmd:pmd checkstyle:checkstyle`
