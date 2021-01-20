#include <stdio.h>
#include <wiringPi.h>

#define	L_FWD	22
#define L_REV	23
#define R_FWD	26
#define R_REV	21

int main (void)
{
	printf ("Motion control test\n") ;

	wiringPiSetup () ;
	pinMode(L_FWD, OUTPUT);
	pinMode(L_REV, OUTPUT);
	pinMode(R_FWD, OUTPUT);
	pinMode(R_REV, OUTPUT);

	for (;;)
	{
    printf("L_FWD On\n");
	digitalWrite (L_FWD, HIGH);
	delay (2000) ;
	digitalWrite (L_FWD, LOW) ;	// Off
	delay (500) ;

    printf("L_REV On\n");
	digitalWrite (L_REV, HIGH);
	delay (2000) ;
	digitalWrite (L_REV, LOW) ;	// Off
	delay (500) ;
    
        printf("R_FWD On\n");
	digitalWrite (R_FWD, HIGH);
	delay (2000) ;
	digitalWrite (R_FWD, LOW) ;	// Off
	delay (500) ;
    
        printf("R_REV On\n");
	digitalWrite (R_REV, HIGH);
	delay (2000) ;
	digitalWrite (R_REV, LOW) ;	// Off
	delay (500) ;
    
    
	}
	return 0 ;
}

