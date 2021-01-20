#include <stdio.h>
#include <wiringPi.h>


#define	L_FWD	22
#define L_REV	23
#define R_FWD	26
#define R_REV	21

#define L_TOUCH 27
#define R_TOUCH 25



int main (void)
{
	printf ("Raspberry Pi blink\n") ;

	wiringPiSetup () ;
	pinMode(L_FWD, OUTPUT);
	pinMode(L_REV, OUTPUT);
	pinMode(R_FWD, OUTPUT);
	pinMode(R_REV, OUTPUT);
    pinMode(L_TOUCH, INPUT);
    pinMode(L_TOUCH, INPUT);

	for (;;)
	{
    printf("Go!\n");
    
    digitalWrite (L_REV, LOW);
    digitalWrite (R_REV, LOW);
	digitalWrite (L_FWD, HIGH);
    digitalWrite (R_FWD, HIGH);

    
    while((digitalRead(L_TOUCH) == 0) && (digitalRead(R_TOUCH) == 0));
        {
            delay(20);
        }
        
        digitalWrite (L_FWD, LOW);
        digitalWrite (R_FWD, LOW);

    
        if(digitalRead(L_TOUCH) == 1)
            {
                printf("Obstacle on left side\n");
                digitalWrite (L_REV, HIGH);
                digitalWrite (R_REV, HIGH);
                delay(1500);
                
                digitalWrite (L_REV, LOW);
                digitalWrite (L_FWD, HIGH);
                delay(800);
                
            }
            
        if(digitalRead(R_TOUCH) == 1)
            {
                printf("Obstacle on right side\n");
                digitalWrite (L_REV, HIGH);
                digitalWrite (R_REV, HIGH);
                delay(1500);
                
                digitalWrite (R_REV, LOW);
                digitalWrite (R_FWD, HIGH);
                delay(800);
                
            }    

	}
	return 0 ;
}


