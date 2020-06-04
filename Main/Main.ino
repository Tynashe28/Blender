#define WATER_PUMP 11
#define SUGAR 10
#define ORANGE 9
#define CONCENTRATE 6
#define BASE 5
#define REDLED 4
#define GREENLED 3
String incomingMessage;
int quantity =0;
void setup(){
    Serial.begin(9600);
    pinMode(REDLED,OUTPUT);
    pinMode(GREENLED,OUTPUT);
    digitalWrite(REDLED,HIGH);
    digitalWrite(GREENLED,LOW);
}
void loop(){
    while (Serial.available()==0){
        /* code */
    }  
    
    incomingMessage = Serial.readString(); 
    if(incomingMessage =="connect"){
        digitalWrite(REDLED,LOW);
        digitalWrite(GREENLED,HIGH);
        Serial.println("c");   
       
    }
    
    else if (incomingMessage =="start"){
      
        // convert to int 
        String amt = incomingMessage.substring(5,incomingMessage.length());
        startOrangeCrushProcess(quantity);
    }else if (incomingMessage =="stop"){
        stopAllProcesses();
    }
    else{

    }
   // Serial.println(incomingMessage.substring(0,4)); 
    
}
void startOrangeCrushProcess(int q){
    int wSpeed = 255;
    int sSpeed = 200;
    int oSpeed = 167;
    int cSpeed = 255;
    int bSpeed = 100;
    analogWrite(WATER_PUMP,wSpeed);
    analogWrite(SUGAR,sSpeed);
    analogWrite(ORANGE,oSpeed);
    analogWrite(CONCENTRATE,cSpeed);
    analogWrite(BASE,bSpeed);
}
void stopAllProcesses(){
    analogWrite(WATER_PUMP,0);
    analogWrite(SUGAR,0);
    analogWrite(ORANGE,0);
    analogWrite(CONCENTRATE,0);
    analogWrite(BASE,0);
}
