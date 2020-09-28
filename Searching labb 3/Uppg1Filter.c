#include <stdio.h>
#include <stdlib.h>

void cleanUp(char character){

    if(isalpha(character) || character == 10 || character == ' '){ //if the character is alphabetic, blank or newline, print the character. ASCII 10 is newline
        putchar(character);
    } else {
        putchar(' '); //else print blank
    }
}

int main()
{
    char character = getchar(); //get the character from standard in

    while(character != EOF){ //while the file has not ended
        cleanUp(character); //clean up the text
        character = getchar(); //get the next character
    }
    return 0;
}
