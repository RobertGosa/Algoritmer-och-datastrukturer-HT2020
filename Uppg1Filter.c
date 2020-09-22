#include <stdio.h>
#include <stdlib.h>

void remove(char character){

    if(isalpha(character) || character == 10 || character == ' '){ //ASCII 10 is newline
        putchar(character);
    }else
    {
        putchar(' ');
    }
}



int main()
{
    char character = getchar();

    while(character != EOF){
        remove(character);
        character= getchar();
    }
    return 0;
}
